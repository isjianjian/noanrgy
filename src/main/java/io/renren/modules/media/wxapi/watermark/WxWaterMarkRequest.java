package io.renren.modules.media.wxapi.watermark;


import io.renren.common.media.img.wartermark.WaterMarkOptions;
import io.renren.modules.media.entity.IRequest;
import lombok.Data;

/**
 * Created by yihui on 2017/9/29.
 */
@Data
public class WxWaterMarkRequest implements IRequest {

    /**
     * logo 的相对地址
     */
    private String logo;


    /**
     * 1 表示允许签名， 0 表示无签名
     */
    private int signEnabled;

    /**
     * 水印签名
     */
    private String sign;


    /**
     * 水印样式，主要是绘制的方式
     */
    private String style = WaterMarkOptions.WaterStyle.OVERRIDE_RIGHT_BOTTOM.name();


    private Integer opacity;


    private Integer rotate;


    private Integer logoHeight;


    @Override
    public boolean validate() {
        return true;
    }
}
