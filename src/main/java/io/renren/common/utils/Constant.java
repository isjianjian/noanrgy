package io.renren.common.utils;

import java.util.HashMap;

/**
 * 常量
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {

    public static final String      USER_IN_COOKIE    = "S_L_ID";
    public static       String      AES_SALT          = "0123456789abcdef";
    public static       String      LOGIN_SESSION_KEY = "login_user";
    public static       Boolean     INSTALLED         = false;
    public static       Boolean     ENABLED_CDN       = true;

    /**
     * 最大页码
     */
    public static final int MAX_PAGE = 100;

    /**
     * 最大获取文章条数
     */
    public static final int MAX_POSTS = 9999;

    /**
     * 文章最多可以输入的文字数
     */
    public static final int MAX_TEXT_COUNT = 200000;

    /**
     * 文章标题最多可以输入的文字个数
     */
    public static final int MAX_TITLE_COUNT = 200;


    /** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;

    public static final String ENV_SUPPORT_163_MUSIC = "app.support_163_music";
    public static final String ENV_SUPPORT_GIST      = "app.support_gist";
    public static final String MP3_PREFIX            = "[mp3:";
    public static final String MUSIC_IFRAME          = "<iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=350 height=106 src=\"//music.163.com/outchain/player?type=2&id=$1&auto=0&height=88\"></iframe>";
    public static final String MUSIC_REG_PATTERN     = "\\[mp3:(\\d+)\\]";
    public static final String GIST_PREFIX_URL       = "https://gist.github.com/";
    public static final String GIST_REG_PATTERN      = "&lt;script src=\"https://gist.github.com/(\\w+)/(\\w+)\\.js\">&lt;/script>";
    public static final String GIST_REPLATE_PATTERN  = "<script src=\"https://gist.github.com/$1/$2\\.js\"></script>";

	/**
	 * 菜单类型
	 * 
	 * @author chenshun
	 * @email sunlightcs@gmail.com
	 * @date 2016年11月15日 下午1:24:29
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    /**
     * 定时任务状态
     * 
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
