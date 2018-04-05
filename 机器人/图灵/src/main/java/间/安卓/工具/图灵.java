package 间.安卓.工具;

import 间.工具.字符;
import 间.工具.线程;
import 间.接口.方法;
import 间.接口.返回值;
import 间.收集.哈希表;
import 间.收集.无序表;
import 间.收集.集合;
import 间.数据.JSON;
import 间.网络.资源;
import 间.网络.连接;
import 间.网络.连接工厂;

public class 图灵 {

    private static 集合<String> 所有用户 = new 集合<>();

    private static 连接工厂 工厂 = new 连接工厂();

    static {
        工厂.模式("POST");
        工厂.地址("http://openapi.tuling123.com/openapi/api/v2");
        工厂.JSON输出(true);
    }

    public static void 添加用户(String apiKey) {
        所有用户.添加(apiKey);
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

    public  static 返回值<String> 请求(String $内容) {
        for (String $单个 : 所有用户) {
            连接 $连接 = 工厂.新建();
            $连接.JSON(取参数表($单个, $内容));
            资源 $资源 = $连接.同步();
            if ($资源.成功()) {
                String $返回 = 解析返回($单个, $资源.文本());
                if ($返回 != null) {
                    return 返回值.创建($返回);
                }
            } else {
                return 返回值.创建("网络不给力 ~",false);
            }
        }
        return 返回值.创建("Key错误 ~",false);
    }

    private static String 解析返回(String $用户,String $内容) {

        if ($内容 == null) return null;
        哈希表 $表 = JSON.解析($内容);
        if ($表 == null) return null;
        if (!$表.检查("intent"))return null;
        哈希表 $意图 = (哈希表)$表.读取("intent");
        if ($意图 == null) return null;
        Integer $状态 = (Integer)$意图.读取("code");
        if ($状态 == null) return null;
        if (应移除($状态)) {
            所有用户.删除对象($用户);
            return null;
        }
        if (转换异常($状态) != null) return null;
        集合<哈希表> $结果 = (集合<哈希表>)$表.读取("results");
        if ($结果 == null) return null;
        for (哈希表 $单个 : $结果) {
            提示.日志($单个);
            if ("text".equals($单个.读取("resultType"))) {
                return (String)((哈希表)$单个.读取("values")).读取("text");
            }
        }
        return null;
    }

    private static 无序表 取参数表(String $用户,String $文本) {
        无序表 $参数 = new 无序表();
        $参数.设置("reqType", 0);
        无序表 $输入 = new 无序表();
        if ($文本.length() > 128) {
            $文本 = 字符.取开始前($文本, 128);
        }
        无序表 $内容 = new 无序表();
        $内容.设置("text", $文本);
        $输入.设置("inputText", $内容);
        无序表 $验证 = new 无序表();
        $验证.设置("apiKey", $用户);
        $验证.设置("userId", 设备.取IMEI());
        $参数.设置("perception", $输入);
        $参数.设置("userInfo", $验证);
        return $参数;
    }

    public static String 转换异常(int $状态码) {
        switch ($状态码) {
            case 0:return "上传成功";
            case 8008:return "服务器错误";
            case 7002:return "上传信息失败";
            case 4602:return "输入内容过长";
            case 4600:return "输入内容为空";
            case 4500:return "id申请超限";
            case 4400:return "没有userId";
            case 4300:return "批量操作超限";
            case 4200:return "上传格式错误";
            case 4100:return "userId获取失败";
            case 4007:return "appKey错误";
            case 4005:case 4002:
                return "无功能权限";
            case 4003:return "没有可用次数";
            case 4001:return "加密方式错误";
            case 4000:return "请求格式错误";
            case 6000:return "暂不支持该功能";
            case 5000:return "没有解析结果";
        }
        return null;
    }

    private static boolean 应移除(int $状态码) {
        switch ($状态码) {
            case 4003:case 4007:return true;
        }
        return false;
    }

}
