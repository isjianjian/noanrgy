package io.renren.modules.media.wxapi.img;


import io.renren.modules.media.entity.IRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

/**
 * Created by yihui on 2017/9/18.
 */
@Data
public class WxImgCreateRequest implements IRequest {


    /**
     * 文字内容
     */
    private String msg;


    /**
     * 模板ID
     */
    private String templateId;


    private String sign;


    private Integer signStatus;


    @Override
    public boolean validate() {
        return !(StringUtils.isBlank(msg) || StringUtils.isBlank(templateId));
    }
}
