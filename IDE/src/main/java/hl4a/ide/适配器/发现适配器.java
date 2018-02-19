package hl4a.ide.适配器;

import android.content.Context;
import android.view.View;
import hl4a.ide.工具.发现;
import hl4a.ide.工具.应用信息;
import hl4a.ide.工具.更新;
import hl4a.ide.布局.布局_适配器_发现;
import hl4a.ide.应用配置信息;
import java.util.Map;
import 间.安卓.工具.图片;
import 间.安卓.工具.处理;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.工具.线程;
import 间.安卓.网络.请求;
import 间.安卓.网络.资源;
import 间.安卓.视图.适配器.基本适配器;
import 间.工具.字节;
import 间.收集.哈希表;
import 间.收集.集合;
import 间.数据.YAML;
import 间.工具.字符;

public class 发现适配器 extends 基本适配器 {

    public Context 上下文;

    public 发现适配器(Context $上下文) {
        上下文 = $上下文;
    }

    public void 更新() {
        String $缓存 = 应用配置信息.应用缓存;
        if (文件.是文件($缓存, "应用.yml")) {
            推送(YAML.读取($缓存 + "/应用.yml"));
        }
        if (更新.应用地址 == null) {
            更新.请求();
        }
        if (更新.应用地址 == null) {
            提示.警告("网络不给力 ~");
            return;
        }
        资源 $返回 = new 请求(更新.应用地址).默认缓存().同步();
        if ($返回 == null || !$返回.是否成功()) {
            提示.警告("网络不给力 ~");
            return;
        }
        String $文本 = $返回.取文本();
        字符.保存($缓存 + "/应用.yml", $文本);
        哈希表 $列表 = YAML.解析($文本);
        推送($列表);
    }

    public void 推送(哈希表 $列表) {
        数据 = new 集合<>();
        for (Map.Entry $单个 : $列表.entrySet()) {
            String $名称 = (String)$单个.getKey();
            String $地址 = (String)$单个.getValue();
            if (更新.中心 != null)
                $地址 = $地址.replace("<中心>", 更新.中心);
            哈希表 $表 = new 哈希表();
            $表.设置("包名", $名称);
            $表.设置("地址", $地址);
            数据.添加($表);
            处理.主线程(this, "发送更新事件");
        }
    }

    @Override
    public View 创建() {
        return new 布局_适配器_发现(上下文);
    }

    @Override
    public View 处理(View $视图,哈希表<String, Object> $参数) {
        String $包名 = (String)$参数.读取("包名");
        String $地址 = (String)$参数.读取("地址");
        布局_适配器_发现 $布局 = (布局_适配器_发现)$视图;
        //$布局.名称.置文本($包名);
        $布局.包名 = $包名;
        $布局.地址 = $地址;
        new 线程(this, "加载内容").启动($布局, $包名, $地址);
        return $视图;
    }

    private static 应用信息 解析(String... $文件) {
        return YAML.读取(字符.分解($文件, "/"), 应用信息.class);
    }

    public void 加载内容(布局_适配器_发现 $视图,String $包名,String $地址) {
        String $缓存 = 应用配置信息.应用缓存 + "/" + $包名;
        boolean $断网 = 更新.中心 == null;
        if (文件.是文件($缓存, "应用.yml")) {
            应用信息 $原有 = 解析($缓存, "应用.yml");
            处理.主线程($视图.名称, "置文本", $原有.工程名);
        } else if ($断网) {
        } else {
            资源 $返回 = new 请求($地址 + "/应用.yml").同步();
            if ($返回 == null || !$返回.是否成功()) {
                处理.主线程($视图.名称, "置文本", "加载失败");
            } else {
                String $文本 = $返回.取文本();
                字符.保存($缓存 + "/应用.yml", $文本);
                应用信息 $信息 = YAML.解析($文本, 应用信息.class);
                处理.主线程($视图.名称, "置文本", $信息.工程名);
            }
        }
        if (文件.是文件($缓存, "图标.png")) {
            处理.主线程($视图.图标, "置图片", 图片.读取($缓存 + "/图标.png"));
        } else if ($断网) {
            $视图.图标.置图片(android.R.drawable.sym_def_app_icon);
        } else {
            $视图.图标.置图片(android.R.drawable.sym_def_app_icon);
            资源 $图标 = new 请求($地址 + "/图标.png").默认缓存().同步();
            if ($图标 != null && $图标.是否成功()) {
                byte[] $字节 = $图标.取字节();
                处理.主线程($视图.图标, "置图片", 图片.读取($字节));
                字节.保存($缓存 + "/图标.png", $字节);
            }
        }

    }



}
