package 间.安卓.工具;

import 间.网络.连接工厂;
import 间.网络.连接;
import 间.工具.编码;
import 间.工具.字符;
import 间.网络.资源;
import 间.接口.返回值;
import 间.接口.方法;
import 间.接口.调用;

public class 茉莉 {

    private static 连接工厂 工厂 = new 连接工厂();
    private static int 分析次数 = 8;
    private static String Key;
    private static String Secret;
    private static String 用户名称 = "恶臭的用户";
    private static String 机器人名称 = "奈间机器人";

    static {
        工厂.地址("http://i.itpk.cn/api.php?");
    }

    public static void 置分析次数(int $次数) {
        if ($次数 > 1 && $次数 < 9) {
            分析次数 = $次数;
        }
    }

    public static int 取分析次数() {
        return 分析次数;
    }
    
    public static String 取用户名称() {
        return 用户名称;
    }
    
    public static void 置用户名称(String $名称) {
        用户名称 = $名称;
    }

    public static void 置机器人默认名称(String $名称) {
        机器人名称 = $名称;
    }

    public static String 取机器人默认名称() {
        return 机器人名称;
    }

    public static void 置用户(String $Key,String $Secret) {
        Key = $Key;
        Secret = $Secret;
    }
    
    public static void 请求(final String $内容,final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    处理.主线程($回调,请求($内容));
                    return null;
                }
            }).启动();
    }

    public static 返回值<String> 请求(String $内容) {
        StringBuilder $构建 = new StringBuilder();
        $构建.append("question=" + 编码.链接.编码($内容));
        $构建.append("&limit=" + 分析次数);
        if (!字符.是空白(Key, Secret)) {
            $构建.append("&api_key=" + Key);
            $构建.append("&api_secret=" + Secret);
        }
        连接 $连接 = 工厂.新建($构建.toString());
        资源 $返回 = $连接.同步();
        if ($返回.成功()) {
            String $文本 = $返回.文本();
            if (字符.是否出现($文本,"[cqname]")) {
                $文本 = 字符.替换($文本,"[cqname]",机器人名称);
            }
            if (字符.是否出现($文本,"[name]")) {
                $文本 = 字符.替换($文本,"[name]",用户名称);
            }
            return 返回值.创建($文本);
        }
        return 返回值.创建("网络不给力 ~",false);
    }

}
