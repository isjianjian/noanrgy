package io.renren.modules.media.wxapi.qrcode;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import io.renren.common.media.qrcode.QrCodeDeWrapper;
import io.renren.common.media.qrcode.QrCodeGenWrapper;
import io.renren.common.media.qrcode.QrCodeOptions;
import io.renren.modules.media.entity.ResponseWrapper;
import io.renren.modules.media.entity.Status;
import io.renren.modules.media.wxapi.WxBaseAction;
import io.renren.modules.media.wxapi.WxBaseResponse;
import io.renren.modules.media.wxapi.helper.ImgGenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by yihui on 2017/10/15.
 */
@RestController
@Slf4j
public class WxQrCodeAction extends WxBaseAction {


    @RequestMapping(path = "wx/qrcode/encode", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseWrapper<WxBaseResponse> parse(HttpServletRequest request, WxQrCodeEncRequest qrCodeEncRequest) {
        BufferedImage logo;
        try {
             logo = getImg(request);
        } catch (Exception e) {
            logo = null;
        }


        try {
            BufferedImage ans = QrCodeGenWrapper.of(qrCodeEncRequest.getContent())
                    .setW(qrCodeEncRequest.getSize())
                    .setH(qrCodeEncRequest.getSize())
                    .setLogo(logo)
                    .setLogoStyle(QrCodeOptions.LogoStyle.ROUND)
                    .setLogoBorder(true)
                    .setLogoBgColor(Color.WHITE)
                    .setErrorCorrection(getError(qrCodeEncRequest.getErrorLevel()))
                    .setPadding(qrCodeEncRequest.getPadding())
                    .asBufferedImage();
            String result = ImgGenHelper.saveImg(ans);
            WxBaseResponse response = new WxBaseResponse();
            response.setImg(result);
            return ResponseWrapper.successReturn(response);
        } catch (Exception e) {
            log.error("create qrcode error!: {}", e);
            return ResponseWrapper.errorReturnMix(Status.StatusEnum.FAIL_MIX, "生成失败!");
        }
    }

    private ErrorCorrectionLevel getError(int level) {
        switch (level) {
            case 0: return ErrorCorrectionLevel.L;
            case 1: return ErrorCorrectionLevel.M;
            case 2: return ErrorCorrectionLevel.Q;
            default: return ErrorCorrectionLevel.H;
        }
    }


    @RequestMapping(path = "wx/qrcode/decode", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseWrapper<String> decode(HttpServletRequest request) {
        BufferedImage img = getImg(request);
        if (img == null) {
            return ResponseWrapper.errorReturnMix(Status.StatusEnum.ILLEGAL_PARAMS_MIX, "请选择包含二维码的图片!");
        }

        try {
            String ans = QrCodeDeWrapper.decode(img);
            return ResponseWrapper.successReturn(ans);
        } catch (Exception e) {
            return ResponseWrapper.errorReturnMix(Status.StatusEnum.FAIL_MIX, "解析失败!");
        }
    }

}
