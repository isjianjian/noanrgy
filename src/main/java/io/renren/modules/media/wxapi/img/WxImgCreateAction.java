package io.renren.modules.media.wxapi.img;


import io.renren.common.media.img.create.ImgCreateOptions;
import io.renren.common.media.img.create.ImgCreateWrapper;
import io.renren.common.media.img.wartermark.WaterMarkOptions;
import io.renren.common.media.img.wartermark.WaterMarkWrapper;
import io.renren.common.media.tools.ChineseDataExTool;
import io.renren.common.media.util.FontUtil;
import io.renren.common.media.util.ImageUtil;
import io.renren.modules.media.entity.ResponseWrapper;
import io.renren.modules.media.entity.Status;
import io.renren.modules.media.wxapi.WxBaseAction;
import io.renren.modules.media.wxapi.WxBaseResponse;
import io.renren.modules.media.wxapi.common.WxImgCreateTemplateEnum;
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
 * Created by yihui on 2017/9/18.
 */
@RestController
@Slf4j
public class WxImgCreateAction extends WxBaseAction {

    private static final int DEFAULT_SIZE = 640;
    private static final int DEFAULT_SMALL_SIZE = 400;

    private static final int LINE_PADDING = 10;
    private static final int TOP_PADDING = 20;
    private static final int BOTTOM_PADDING = 20;
    private static final int LEFT_PADDING = 20;
    private static final int RIGHT_PADDING = 20;


    @RequestMapping(value = "/wx/create", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseWrapper<WxBaseResponse> create(HttpServletRequest httpServletRequest, WxImgCreateRequest wxImgCreateRequest) {

        BufferedImage bfImg = getImg(httpServletRequest);

        WxImgCreateTemplateEnum cenum = WxImgCreateTemplateEnum.getEnum(wxImgCreateRequest.getTemplateId());
        if (cenum == null) {
            throw new IllegalArgumentException("非法的模板id!");
        }


        int paddingSize, imgSize;
        if (cenum.getDrawStyle() == ImgCreateOptions.DrawStyle.HORIZONTAL) {
            paddingSize = LEFT_PADDING + RIGHT_PADDING;
            imgSize = bfImg.getWidth();
        } else {
            paddingSize = TOP_PADDING + BOTTOM_PADDING;
            imgSize = bfImg.getHeight();
        }
        int size = calculateSize(wxImgCreateRequest.getMsg(), paddingSize, imgSize);
        ImgCreateWrapper.Builder builder = ImgCreateWrapper.build()
                .setImgW(size)
                .setImgH(size)
                .setDrawStyle(cenum.getDrawStyle())
                .setFont(FontUtil.BIG_DEFAULT_FONT)
                .setLeftPadding(LEFT_PADDING)
                .setRightPadding(RIGHT_PADDING)
                .setTopPadding(TOP_PADDING)
                .setBottomPadding(BOTTOM_PADDING)
                .setLinePadding(LINE_PADDING)
                .setBorderLeftPadding(18)
                .setBorderTopPadding(20)
                .setBorderBottomPadding(20)
                .setBorder(false);

        try {
            BufferedImage ans;
            if (cenum.imgEnd()) {
                ans = builder.setAlignStyle(cenum.getAlignStyle())
                        .drawContent(wxImgCreateRequest.getMsg())
                        .setFont(FontUtil.SMALLER_DEFAULT_ITALIC_FONT)
                        .setAlignStyle(cenum.getDrawStyle() == ImgCreateOptions.DrawStyle.HORIZONTAL ? ImgCreateOptions.AlignStyle.RIGHT : ImgCreateOptions.AlignStyle.BOTTOM)
                        .drawContent(getSign(wxImgCreateRequest))
                        .drawContent(" ")
                        .setAlignStyle(ImgCreateOptions.AlignStyle.CENTER)
                        .drawImage(bfImg)
                        .asImage()
                ;
            } else {
                ans = builder.setAlignStyle(ImgCreateOptions.AlignStyle.CENTER)
                        .drawImage(bfImg)
                        .drawContent(" ")
                        .setAlignStyle(cenum.getAlignStyle())
                        .drawContent(wxImgCreateRequest.getMsg())
                        .setFont(FontUtil.SMALLER_DEFAULT_ITALIC_FONT)
                        .setAlignStyle(cenum.getDrawStyle() == ImgCreateOptions.DrawStyle.HORIZONTAL ? ImgCreateOptions.AlignStyle.RIGHT : ImgCreateOptions.AlignStyle.BOTTOM)
                        .drawContent(getSign(wxImgCreateRequest))
                        .asImage()
                ;
            }


            ans = WaterMarkWrapper.of(ans)
                    .setStyle(WaterMarkOptions.WaterStyle.OVERRIDE_LEFT_BOTTOM)
                    .setWaterLogo(ImageUtil.getImageByPath("//Users/yihui/Desktop/xcx/xcx.jpg"))
                    .setWaterInfo("图文小工具")
                    .setWaterColor(Color.LIGHT_GRAY)
                    .setInline(false)
                    .setWaterLogoHeight(80)
                    .setWaterOpacity(0.85f)
                    .build()
                    .asImage();

            ans = WaterMarkWrapper.of(ans)
                    .setStyle(WaterMarkOptions.WaterStyle.OVERRIDE_RIGHT_BOTTOM)
                    .setWaterFont(FontUtil.SMALLER_DEFAULT_ITALIC_FONT)
                    .setWaterInfo("--" + ChineseDataExTool.getNowLunarDate())
                    .setWaterColor(Color.BLACK)
                    .setInline(true)
                    .setWaterOpacity(1)
                    .build()
                    .asImage();


            WxBaseResponse wxBaseResponse = new WxBaseResponse();
//            wxBaseResponse.setBase64result(Base64Util.encode(ans, MediaType.ImagePng.getExt()));
//            wxBaseResponse.setPrefix(MediaType.ImagePng.getPrefix());
            wxBaseResponse.setImg(ImgGenHelper.saveImg(ans));
            return ResponseWrapper.successReturn(wxBaseResponse);
        } catch (Exception e) {
            log.error("WxImgCreateAction!Create image error! e: {}", e);
            return ResponseWrapper.errorReturn(Status.StatusEnum.FAIL);
        }
    }


//    private BufferedImage getImg(HttpServletRequest request) {
//        MultipartFile file = null;
//        if (request instanceof MultipartHttpServletRequest) {
//            file = ((MultipartHttpServletRequest) request).getFile("image");
//        }
//
//        if (file == null) {
//            throw new IllegalArgumentException("图片不能为空!");
//        }
//
//
//        // 目前只支持 jpg, png, webp 等静态图片格式
//        String contentType = file.getContentType();
//        if (!MediaValidate.validateStaticImg(contentType)) {
//            throw new IllegalArgumentException("不支持的图片类型");
//        }
//
//        // 获取BufferedImage对象
//        try {
//            BufferedImage bfImg = ImageIO.read(file.getInputStream());
//            return bfImg;
//        } catch (IOException e) {
//            log.error("WxImgCreateAction!Parse img from httpRequest to BuferedImage error! e: {}", e);
//            throw new IllegalArgumentException("不支持的图片类型!");
//        }
//    }


    private String getSign(WxImgCreateRequest request) {
        if(request.getSignStatus() == null || request.getSignStatus() <= 0) {
            return null;
        }


        if (StringUtils.isBlank(request.getSign())) {
            return ChineseDataExTool.getNowLunarDate();
        }

        return request.getSign();
    }


    private int calculateSize(String msg, int paddingSize, int imgSize) {
        String[] strs = StringUtils.split(msg, "\n");
        int maxLen = 0;
        for (String str : strs) {
            if (str.length() > maxLen) {
                maxLen = str.length();
            }
        }


        // 最长的一行文字长度
        int size = FontUtil.BIG_DEFAULT_FONT.getSize() * (maxLen + 3) + paddingSize;


        // 不能超过默认的长度
        size = Math.min(size, DEFAULT_SIZE);


        // 不能比最小的还要小
        int tmpSize = Math.max(size, DEFAULT_SMALL_SIZE);

        imgSize += paddingSize;
        if (imgSize > size || imgSize  < tmpSize) {
            return tmpSize;
        } else {
            return imgSize;
        }
    }

}
