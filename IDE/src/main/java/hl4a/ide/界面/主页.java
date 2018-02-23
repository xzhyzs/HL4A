package hl4a.ide.界面;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import hl4a.ide.工具.应用信息;
import hl4a.ide.工具.更新;
import hl4a.ide.布局.布局_主页_底层;
import hl4a.ide.布局.布局_适配器_发现;
import hl4a.ide.布局.布局_适配器_应用;
import hl4a.ide.应用配置信息;
import hl4a.ide.适配器.发现适配器;
import hl4a.ide.适配器.应用适配器;
import java.io.File;
import 间.安卓.工具.处理;
import 间.安卓.工具.应用;
import 间.安卓.工具.提示;
import 间.安卓.工具.文件;
import 间.安卓.工具.线程;
import 间.安卓.弹窗.询问弹窗;
import 间.安卓.弹窗.进度弹窗;
import 间.安卓.组件.界面;
import 间.安卓.视图.弹出菜单;
import 间.工具.ZIP;
import 间.接口.调用;
import 间.收集.哈希表;
import 间.网络.资源;
import 间.网络.连接;
import 间.数据.YAML;
import 间.工具.字符;
import 间.工具.字节;

public class 主页 extends 界面 {

    private 布局_主页_底层 布局;
    private 应用适配器 适配器;
    private 发现适配器 发现;
    private 进度弹窗 安装;
    private 进度弹窗 进度;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_主页_底层(此));
        布局 = (布局_主页_底层)当前视图;
        适配器 = new 应用适配器(此);
        布局.主页.列表.置适配器(适配器);
        布局.主页.列表.置项目单击事件(调用.代理(this, "项目单击"));
        布局.主页.列表.置项目长按事件(调用.代理(this, "项目长按"));
        界面刷新事件();
        发现 = new 发现适配器(此);
        布局.发现.列表.置适配器(发现);
        布局.发现.列表.置项目单击事件(调用.代理(this, "发现单击"));
        布局.发现.置单击事件(调用.配置(this, "断网重试"));
        断网重试();
        安装 = new 进度弹窗(此);
        进度 = new 进度弹窗(此);
        new 线程(this, "检查更新").启动();
    }

    public void 检查更新() {
        if (!更新.检查()) {
            return;
        }
        if (更新.设置.最新 > 应用.取版本号()) {
            跳转界面(更新界面.class);
            结束界面();
        }
    }

    public void 更新回调() {

        if (发现.是断网) {
            布局.发现.列表.隐藏();
            布局.发现.提示.显示();
            布局.发现.进度.隐藏();
            布局.发现.提示.置文本("连接Github失败\n单击重试 ~");
            // 断网
        } else if (发现.getCount() == 0) {
            布局.发现.列表.隐藏();
            布局.发现.提示.显示();
            布局.发现.进度.隐藏();
            布局.发现.提示.置文本("没有更多了\n单击刷新 ~");
        } else {
            布局.发现.列表.显示();
            布局.发现.提示.隐藏();
            布局.发现.进度.隐藏();
        }

    }

    public void 断网重试() {
        布局.发现.列表.隐藏();
        布局.发现.提示.隐藏();
        布局.发现.进度.显示();
        new 线程(发现, "更新").置回调(调用.配置(处理.class, "主线程", this, "更新回调")).启动();
    }

    public void 发现单击(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        布局_适配器_发现 $布局 = (布局_适配器_发现)$视图;
        String $包名 = $布局.包名;
        String $地址 = $布局.地址;
        new 线程(this, "安装应用").启动($包名, $地址);
    }

    public void 安装应用(String $包名,String $地址) {
        String $缓存 = 应用配置信息.应用缓存 + "/" + $包名;
        if (!文件.是文件($缓存, "应用.yml")) 结束界面();
        应用信息 $应用 = 发现适配器.解析($缓存, "应用.yml");
        安装.显示();
        安装.更新("正在安装" + $应用.工程名);
        if (更新.设置 == null) {
            更新.请求();
            if (更新.设置 == null) {
                提示.警告("连接失败 ~");
                安装.隐藏();
                return;
            }
        }
        资源 $内容 = 连接.创建($地址 + "/应用.zip", "GET").同步();
        if (!$内容.已成功()) {
            提示.警告("连接失败 ~");
            return;
        }
        String $保存 = 文件.取缓存目录($应用.包名 + ".zip");
        $内容.保存($保存);
        ZIP.解压($保存, $缓存);
        文件.删除($保存);
        文件.剪切($缓存, 应用配置信息.应用保存 + "/" + $应用.包名);
        发现.更新();
        处理.主线程(适配器, "更新");
        提示.普通("安装成功 ~");
        安装.隐藏();
        处理.主线程(this,"更新回调");
    }

    public void 项目单击(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        hl4a.ide.工具.应用 $内容 = ((布局_适配器_应用)$视图).内容;
        if ($内容.信息.更新 == null) {
            直接跳转($内容);
            return;
        }
        进度.显示();
        进度.更新("检查更新 ~");
        new 线程(this, "应用更新").启动($内容);
    }

    public void 应用更新(hl4a.ide.工具.应用 $内容) {
        if (!更新.检查()) 直接跳转($内容);
        $内容.信息.更新 = $内容.信息.更新.replace("<中心>", 更新.设置.中心);
        资源 $返回 = 连接.创建($内容.信息.更新 + "/应用.yml", "GET").同步();
        if (!$返回.已成功()) 直接跳转($内容);
        String $文本 = $返回.文本();
        应用信息 $最新 = YAML.解析($文本, 应用信息.class);
        if ($最新 == null) 直接跳转($内容);
        if ($最新.版本号 == $内容.信息.版本号) {
            字符.保存($内容.取地址("应用.yml"), $文本);
            $内容.信息 = $最新;
            直接跳转($内容);
        } else {
            进度.更新("正在更新应用 ~");
            String $缓存 = 应用配置信息.下载缓存 + $最新.包名;
            字符.保存($缓存 + "/应用.yml", $文本);
            资源 $图标 = 连接.创建($内容.信息.更新 + "/图标.png", "GET").同步();
            if ($图标.已成功()) {
                byte[] $字节 = $图标.字节();
                字节.保存($缓存 + "/图标.png", $字节);
            }
            资源 $应用 = 连接.创建($内容.信息.更新 + "/应用.zip", "GET").同步();
            if (!$应用.已成功()) {
                提示.警告("更新失败 ~");
                进度.隐藏();
                return;
            }
            String $保存 = 文件.取缓存目录($最新.包名 + ".zip");
            $应用.保存($保存);
            ZIP.解压($保存, $缓存);
            文件.删除($保存);
            文件.删除($内容.取地址());
            文件.剪切($缓存, $内容.取地址());
            发现.更新();
            处理.主线程(适配器, "更新");
            提示.普通("更新成功 ~");
            直接跳转($内容);
        }
    }

    public void 直接跳转(hl4a.ide.工具.应用 $内容) {
        进度.隐藏();
        String $地址 = $内容.取源码("入口.js");
        if (文件.是文件($地址)) {
            文件.替换地址("@", 文件.检查地址($内容.取地址("资源")) + "/");
            跳转脚本($地址);
        } else {
            提示.警告("没有入口文件");
        }
    }

    private 询问弹窗 删除;

    public void 项目长按(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        hl4a.ide.工具.应用 $内容 = ((布局_适配器_应用)$视图).内容;
        弹出菜单 $菜单 = new 弹出菜单($视图);
        删除 = new 询问弹窗(此);
        删除.置问题("删除应用", 调用.配置(this, "删除应用", $内容));
        $菜单.添加("删除", 调用.配置(删除, "显示"));
        $菜单.显示();
    }

    public void 删除应用(hl4a.ide.工具.应用 $应用) {
        删除.隐藏();
        文件.删除($应用.地址);
        提示.普通("删除完成 ~");
        界面刷新事件();
    }


    @Override
    public void 界面刷新事件() {
        适配器.更新();
        if (适配器.getCount() == 0) {
            布局.主页.底层.隐藏();
            布局.主页.提示.显示();
        } else {
            布局.主页.底层.显示();
            布局.主页.提示.隐藏();
        }
    }

}

