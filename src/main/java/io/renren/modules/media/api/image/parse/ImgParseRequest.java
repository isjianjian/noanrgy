package io.renren.modules.media.api.image.parse;


import io.renren.modules.media.entity.IRequest;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * markdown to image
 * <p>
 * Created by yihui on 2017/9/12.
 */
@Data
public class ImgParseRequest implements IRequest {

    private static final long serialVersionUID = 683602660797514455L;

    /**
     * 1. markdown 格式的文本内容
     * 2. markdown 文本对应的http链接
     */
    private String content;


    /**
     * 输出图片的宽度
     */
    private Integer w;

    @Override
    public boolean validate() {
        return !StringUtils.isBlank(content);
    }
}
