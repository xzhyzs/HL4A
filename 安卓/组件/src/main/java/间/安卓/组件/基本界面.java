package 间.安卓.组件;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import java.io.Serializable;
import 间.安卓.工具.主题;
import 间.安卓.工具.布局;
import 间.安卓.工具.应用;
import 间.安卓.工具.权限;
import 间.安卓.工具.环境;
import 间.安卓.工具.线程;
import 间.安卓.工具.设备;
import 间.安卓.插件.应用插件;
import 间.安卓.插件.界面插件;
import 间.工具.反射;
import 间.工具.错误;
import 间.接口.方法;
import 间.接口.返回值;
import 间.收集.有序哈希表;
import 间.收集.哈希表;
import 间.安卓.工具.颜色;
import 间.数据.基本数据;
import 间.安卓.内容.界面;

public class 基本界面 extends Activity {

    public Object[] 传入参数;

    public 哈希表 所有插件 = new 哈希表<>();

    public void 注册插件(界面插件 $插件) {
        注册插件("插件-" + 所有插件.长度(), $插件);
    }

    public void 注册插件(String $标识,界面插件 $插件) {
        if ($插件 == null) return;
        synchronized (所有插件) {
            所有插件.设置($标识, $插件);
            $插件.当前界面 = this;
        }
    }

    @Override
    public void onCreate(Bundle $恢复) {
        super.onCreate($恢复);
        setTheme(主题.取颜色().取主题());
        for (应用插件 $单个 : ((基本应用)环境.取应用()).所有插件) {
            $单个.界面新建(this);
        }
        Intent $意图 = getIntent();
        if ($意图.hasExtra("参数")) {
            传入参数 = (Object[])$意图.getSerializableExtra("参数");
        }
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.界面创建事件($恢复);
        }
        try {
            界面创建事件($恢复);
        } catch (Exception $错误) {
            应用.处理错误(线程.取当前线程(),$错误);
            结束界面();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.界面启动事件();
        }
        界面启动事件();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            for (界面插件 $单个 : 所有插件.values()) {
                $单个.取得焦点事件();
            }
            取得焦点事件();
        } else {
            for (界面插件 $单个 : 所有插件.values()) {
                $单个.失去焦点事件();
            }
            失去焦点事件();
        }
    }

    @Override
    public void onNewIntent(Intent $意图) {
        super.onNewIntent($意图);
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.收到意图事件($意图);
        }
        收到意图事件($意图);
    }

    @Override
    protected void onSaveInstanceState(Bundle $输出) {
        super.onSaveInstanceState($输出);
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.保存状态事件($输出);
        }
        保存状态事件($输出);
    }

    @Override
    public void onResume() {
        super.onResume();
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.界面刷新事件();
        }
        界面刷新事件();
    }

    @Override
    public void onPause() {
        super.onPause();
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.界面遮挡事件();
        }
        界面遮挡事件();
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {
        for (界面插件 $单个 : 所有插件.values()) {
            Boolean $返回 = $单个.按键按下事件(keyCode, event);
            if ($返回 == true) {
                return true;
            }
        }
        if (按键按下事件(keyCode, event)) {
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            for (界面插件 $单个 : 所有插件.values()) {
                if ($单个.返回按下事件()) {
                    return true;
                }
            }
            return 返回按下事件();
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onActivityResult(int $请求码,int $返回码,Intent $意图) {
        super.onActivityResult($请求码, $请求码, $意图);
        for (界面插件 $单个 : 所有插件.values()) {
            if ($单个.界面回调事件($请求码, $返回码, $意图)) return;
        }
        界面回调事件($请求码, $返回码, $意图);
    }

    @Override
    public void onStop() {
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.离开界面事件();
        }
        离开界面事件();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.权限回调事件();
        }
        权限回调事件();
    }

    @Override
    public void onDestroy() {
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.界面销毁事件();
        }
        for (应用插件 $单个 : ((基本应用)环境.取应用()).所有插件) {
            $单个.界面结束(this);
        }
        界面销毁事件();
        super.onDestroy();
    }

    public void 置返回值(int $请求码) {
        setResult($请求码);
    }

    public void 置返回值(int $结果码,Intent $意图) {
        setResult($结果码, $意图);
    }

    public void 结束界面() {
        finish();
    }

    public void 结束界面(final int $延时) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    线程.暂停($延时);
                    finish();
                    return null;
                }
            }).启动();
    }

    public <视图 extends View> 视图 打开布局(View $视图) {
        if ($视图 == null) return null;
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.打开布局事件($视图);
        }
        setTheme(主题.取颜色().取主题());
        间.安卓.工具.布局.打开(this, $视图);
        return (视图)$视图;
    }

    public <视图 extends View> 视图 打开布局(基本数据 $解析,String $地址) {
        return 打开布局(布局.读取(this, $解析, $地址));
    }

    public <视图 extends View> 视图 打开布局(有序哈希表 $内容) {
        return 打开布局(布局.解析(this, $内容));
    }

    public <视图 extends View> 视图 解析布局(基本数据 $解析,String $内容) {
        return 打开布局(布局.解析(this,$解析, $内容));
    }

    public void 跳转界面(Class<?> $类) {
        跳转界面($类, new Object[0]);
    }

    public void 跳转界面(Class<?> $类,Object... $数据) {
        跳转界面(null, $类 , $数据);
    }

    public void 跳转界面(Integer $请求码,Class<?> $类,Object... $数据) {

        if (反射.是子类(界面.class, $类)) {
            
            Intent $意图 = new Intent(this, 组件管理.分配界面($类));
            $意图.putExtra("类",$类);
            if ($数据 != null) 
                $意图.putExtra("参数", (Serializable)$数据);
            if ($请求码 == null)
                startActivity($意图);
            else
                startActivityForResult($意图, $请求码);
            return;
        }
        Intent $意图 = new Intent(this, $类);
        if ($数据 != null)
            $意图.putExtra("参数", (Serializable)$数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

    }

    public void 跳转脚本(String $类) {
        跳转脚本(null, $类, null);
    }

    public void 跳转脚本(String $类,Object[] $数据) {
        跳转脚本(null, $类 , $数据);
    }

    public void 跳转脚本(Integer $请求码,String $类,Object[] $数据) {
        $请求码 = $请求码 == null ? -1 : $请求码;
        Class<?> $界面 = 反射.取类("hl4a.runtime.ScriptActivity");
        if ($界面 != null) {
            Intent $意图 = new Intent(this, $界面);
            $意图.putExtra("脚本", $类);
            if ($数据 != null)
                $意图.putExtra("参数", (Serializable)$数据);
            startActivityForResult($意图, $请求码);
        } else {
            错误.内容("没有脚本运行时 ~");
        }
    }

    public void 请求权限() {
        if (设备.取SDK() < 23) {
            权限回调事件();
            return;
        }
        for (界面插件 $单个 : 所有插件.values()) {
            $单个.请求权限事件();
        }
        权限.默认请求(this);
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
