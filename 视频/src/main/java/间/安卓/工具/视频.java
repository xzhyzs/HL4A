package 间.安卓.工具;

import cn.dxjia.ffmpeg.library.FFmpegNativeHelper;
import 间.工具.字符;

public class 视频 {

    private static String 临时字幕 = 文件.检查地址("%动图生成/sentences.ass");
    
    public static void 初始化() {
        FFmpegNativeHelper.init();
    }
    
    public static String 执行(String $命令,Object... $模板) {
        return FFmpegNativeHelper.runCommand(String.format($命令, $模板));
    }

    public static void 视频到字幕GIF(String $视频,String $ASS,String[] $字幕,String $输出,boolean $低质量) {
        $视频 = 文件.检查地址($视频);
        $输出 = 文件.检查地址($输出);
        String $配置 = 字符.读取($ASS);
        for (int $键值 = 0;$键值 < $字幕.length;$键值 ++) {
            String $对应 = "<%= sentences[" + $键值 + "] %>";
            if (字符.是否出现($配置, $对应)) {
                $配置 = 字符.替换($配置,$对应,$字幕[$键值]);
            }
        }
        字符.保存(临时字幕,$配置);
        if ($低质量) {
            执行("ffmpeg -i %s -r 5 -vf ass=%s,scale=180:-1 -y %s", $视频, 临时字幕, $输出);
        } else {
            执行("ffmpeg -i %s -r 6 -vf ass=%s,scale=300:-1 -y %s", $视频, 临时字幕, $输出);
        }
    }

}
