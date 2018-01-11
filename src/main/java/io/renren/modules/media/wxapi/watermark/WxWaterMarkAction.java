package io.renren.modules.media.wxapi.watermark;

import io.renren.common.media.img.wartermark.WaterMarkWrapper;
import io.renren.common.media.util.ImageUtil;
import io.renren.modules.media.annotation.ValidateDot;
import io.renren.modules.media.entity.ResponseWrapper;
import io.renren.modules.media.entity.Status;
import io.renren.modules.media.wxapi.WxBaseAction;
import io.renren.modules.media.wxapi.WxBaseResponse;
import io.renren.modules.media.wxapi.helper.ImgGenHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 水印服务
 * Created by yihui on 2017/9/29.
 */
@RestController
@Slf4j
public class WxWaterMarkAction extends WxBaseAction {

    @RequestMapping(path = "/wx/water", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @ValidateDot
    public ResponseWrapper<WxBaseResponse> markWater(HttpServletRequest httpServletRequest,
                                                     WxWaterMarkRequest wxWaterMarkRequest) {
        BufferedImage img = getImg(httpServletRequest);
        if (img == null) {
            return ResponseWrapper.errorReturnMix(Status.StatusEnum.ILLEGAL_PARAMS, "主图不能为空");
        }


        BufferedImage logo = null;
        try {
            if (StringUtils.isNotBlank(wxWaterMarkRequest.getLogo())) {
                logo = ImageUtil.getImageByPath(ImgGenHelper.TMP_UPLOAD_PATH + "/" + wxWaterMarkRequest.getLogo());
            }
        } catch (Exception e) {
            log.error("read logo from local disk error! path: {}, e", wxWaterMarkRequest.getLogo(), e);
        }


        String sign = wxWaterMarkRequest.getSign();
        if (wxWaterMarkRequest.getSignEnabled() == 0) {
            sign = " ";
        } else if (StringUtils.isBlank(sign)) {
            sign = " 图文小工具";
        }


        BufferedImage water = WaterMarkWrapper.of(img)
                .setStyle(wxWaterMarkRequest.getStyle())
                .setWaterLogo(logo)
                .setWaterInfo(sign)
                .setWaterColor(Color.LIGHT_GRAY)
                .setPaddingY(40)
                .setPaddingX(40)
                .setInline(true)
                .setWaterOpacity(wxWaterMarkRequest.getOpacity() == null ? 0.85f : wxWaterMarkRequest.getOpacity() / 100.f)
                .setWaterLogoHeight(wxWaterMarkRequest.getLogoHeight() == null ? 0 : wxWaterMarkRequest.getLogoHeight())
                .setRotate(wxWaterMarkRequest.getRotate() == null ? 0 : wxWaterMarkRequest.getRotate())
                .build()
                .asImage();
        WxBaseResponse wxBaseResponse = new WxBaseResponse();
        wxBaseResponse.setImg(ImgGenHelper.saveImg(water));
        return ResponseWrapper.successReturn(wxBaseResponse);
    }


}
