package io.renren.modules.media.wxapi.templates;


import io.renren.modules.media.entity.IResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by yihui on 2017/9/18.
 */
@Data
public class WxImgCreateTemplateResponse implements IResponse {

    private static final long serialVersionUID = -6139592507413745065L;

    private int num;

    private List<WxImgCreateTemplateCell> list;

}
