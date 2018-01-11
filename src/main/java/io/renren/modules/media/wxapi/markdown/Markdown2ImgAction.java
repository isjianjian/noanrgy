package io.renren.modules.media.wxapi.markdown;


import io.renren.common.media.html.Html2ImageWrapper;
import io.renren.common.media.markdown.MarkDown2HtmlWrapper;
import io.renren.common.media.markdown.MarkdownEntity;
import io.renren.common.media.util.DrawUtil;
import io.renren.modules.media.annotation.ValidateDot;
import io.renren.modules.media.entity.ResponseWrapper;
import io.renren.modules.media.entity.Status;
import io.renren.modules.media.wxapi.WxBaseResponse;
import io.renren.modules.media.wxapi.helper.ImgGenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

/**
 * Created by yihui on 2017/10/15.
 */
@RestController
@Slf4j
public class Markdown2ImgAction {

    @RequestMapping(path = "wx/md2img", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @ValidateDot
    public ResponseWrapper<WxBaseResponse> parse(HttpServletRequest request, MarkdownRequest downRequest) throws UnsupportedEncodingException {
        String content = downRequest.getContent();


        MarkdownEntity html = MarkDown2HtmlWrapper.ofContent(content);

        BufferedImage img = null;
        try {
            img = Html2ImageWrapper.ofMd(html)
                    .setW(800)
                    .setAutoW(false)
                    .setAutoH(true)
                    .setOutType("jpg")
                    .build()
                    .asImage();
            // 添加签名
            DrawUtil.drawSign(img);

            String ans = ImgGenHelper.saveImg(img);
            WxBaseResponse response = new WxBaseResponse();
            response.setImg(ans);
            return ResponseWrapper.successReturn(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseWrapper.errorReturnMix(Status.StatusEnum.FAIL_MIX, "转换失败!");
        }
    }

}
