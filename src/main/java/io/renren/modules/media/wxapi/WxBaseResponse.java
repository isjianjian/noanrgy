package io.renren.modules.media.wxapi;

import io.renren.modules.media.entity.IResponse;
import lombok.Data;

/**
 * Created by yihui on 2017/9/18.
 */
@Data
public class WxBaseResponse implements IResponse {

    private String base64result;

    private String prefix;

    private String img;

    private String url;
}
