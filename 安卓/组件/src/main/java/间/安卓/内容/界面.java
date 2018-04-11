package 间.安卓.内容;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import 间.安卓.工具.布局;
import 间.安卓.插件.界面插件;
import 间.安卓.组件.基本界面;
import 间.工具.反射;
import 间.收集.有序哈希表;
import 间.数据.基本数据;

public class 界面 {

    public static final int 返回码_成功 = Activity.RESULT_OK;
    public static final int 返回码_失败 = Activity.RESULT_CANCELED;

    public 基本界面 此;
    public Object[] 传入参数;

    public 基本界面 取界面() {
        return 此;
    }
    
    public void 结束界面() {
        此.结束界面();
    }

    public void 打开布局(基本数据 $解析,String $地址) {
        此.打开布局($解析,$地址);
    }

    public void 注册插件(String $标识,界面插件 $插件) {
        此.注册插件($标识, $插件);
    }

    public void 请求权限() {
        此.请求权限();
    }

    public void 置返回值(int $请求码) {
        此.置返回值($请求码);
    }

    public void 置返回值(int $结果码,Intent $意图) {
        此.置返回值($结果码, $意图);
    }

    public void 结束界面(int $延时) {
        此.结束界面($延时);
    }

    public <视图 extends View> 视图 打开布局(View $视图) {
        return 此.打开布局($视图);
    }

    public <视图 extends View> 视图 打开布局(有序哈希表 $内容) {
        return 此.打开布局($内容);
    }

    public <视图 extends View> 视图 解析布局(基本数据 $解析,String $内容) {
        return 此.打开布局(布局.解析(此,$解析,$内容));
    }
    
    public void 跳转界面(Integer $请求码,Class<?> $类,Object... $数据) {
        此.跳转界面($请求码, $类, $数据);
    }

    public void 跳转界面(Class<?> $类) {
        此.跳转界面($类);
    }

    public void 跳转脚本(String $类,Object... $数据) {
        此.跳转脚本($类, $数据);
    }

    public void 跳转脚本(Integer $请求码,String $类,Object... $数据) {
        此.跳转脚本($请求码, $类, $数据);
    }

    public void 跳转脚本(String $类) {
        此.跳转脚本($类);
    }

    public void 跳转界面(Class<?> $类,Object... $数据) {
        此.跳转界面($类, $数据);
    }

    
    public void 界面创建事件(Bundle $恢复) {}
    public void 界面启动事件() {}
    public void 界面刷新事件() {}
    public void 界面遮挡事件() {}
    public void 界面回调事件(int $请求码,int $返回码,Intent $意图) {}
    public void 离开界面事件() {}
    public void 界面销毁事件() {}
    public void 取得焦点事件() {}
    public void 失去焦点事件() {}
    public boolean 按键按下事件(int $按键码,KeyEvent $事件) {return false;}
    public boolean 返回按下事件() {结束界面();return true;}
    public void 收到意图事件(Intent $意图) {}
    public void 保存状态事件(Bundle $输出) {}
    public void 权限回调事件() {}

}
