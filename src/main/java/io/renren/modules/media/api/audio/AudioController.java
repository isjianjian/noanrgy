package io.renren.modules.media.api.audio;


import io.renren.common.media.audio.AudioWrapper;
import io.renren.common.media.util.HttpUtil;
import io.renren.modules.media.entity.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 *
 * http://localhost:8080/audio/parse?audioPath=http://s11.mogucdn.com/mlcdn/c45406/170713_3g25ec8fak8jch5349jd2dcafh61c.amr&outType=mp3&sourceType=amr
 *
 * Created by yihui on 2017/7/13.
 */
@RestController
@Slf4j
public class AudioController {


    @RequestMapping(value = "/audio/parse", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseWrapper<AudioResponse> parse(HttpServletRequest httpServletRequest,
                                                AudioRequest audioRequest) {

        InputStream inputStream;
        try {
            if (httpServletRequest instanceof MultipartHttpServletRequest) {
                MultipartFile file = ((MultipartHttpServletRequest) httpServletRequest).getFile("file");
                inputStream = file != null ? file.getInputStream() : null;
            } else {
                inputStream = HttpUtil.downFile(audioRequest.getAudioPath());
            }
        } catch (Exception e) {
            log.error("get audio error! e: {}", e);
            return new ResponseWrapper<>(5001, "get audio resource error!");
        }


        String file;
        try {
             file = AudioWrapper.of(inputStream)
                    .setInputType(audioRequest.getSourceType())
                    .setOutputType(audioRequest.getOutType())
                    .asFile();
        } catch (Exception e) {
            log.error("parse audio error! e: {}", e);
            return new ResponseWrapper<>(5001, "get audio resource error!");
        }


        return new ResponseWrapper<>(new AudioResponse(file));
    }

}
