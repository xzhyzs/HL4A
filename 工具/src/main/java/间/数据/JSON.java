package 间.数据;

import 间.收集.有序哈希表;
import org.json.JSONObject;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONArray;
import 间.收集.有序列表;

public class JSON {

    public static 有序哈希表 解析(String $内容) {
        return 数据转哈希表($内容);
    }

    public static String 转换(有序哈希表 $数据) {
        return new JSONObject($数据).toString();
    }

    private static 有序哈希表 数据转哈希表(String $数据) {
        try {
            JSONObject $对象 = new JSONObject($数据);
            return JSON转哈希表($对象);
        } catch (JSONException $错误) {
            return null;
        }
    }

    private static 有序哈希表 JSON转哈希表(JSONObject $对象) throws JSONException {
        有序哈希表 $返回 = new 有序哈希表();
        JSONArray $键值表 = $对象.names();
        int $所有 = $键值表.length();
        for (int $键值 = 0;$键值 < $所有;$键值 ++) {
            String $单个 = $键值表.getString($键值);
            Object $内容 = $对象.get($单个);
            if ($内容 instanceof JSONObject) {
                $内容 = JSON转哈希表((JSONObject)$内容);
            }
            if ($内容 instanceof JSONArray) {
                $内容 = JSON转集合((JSONArray)$内容);
            }
            $返回.设置($单个,$内容);
        }
        return $返回;
    }

    private static 有序列表 JSON转集合(JSONArray $表) throws JSONException {
        有序列表 $返回 = new 有序列表();
        int $所有 = $表.length();
        for (int $键值 = 0;$键值 < $所有;$键值 ++) {
            Object $内容 = $表.get($键值);
            if ($内容 instanceof JSONObject) {
                $内容 = JSON转哈希表((JSONObject)$内容);
            }
            if ($内容 instanceof JSONArray) {
                $内容 = JSON转集合((JSONArray)$内容);
            }
            $返回.添加($内容);
        }
        return $返回;
    }

}
