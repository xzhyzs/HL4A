package 间.安卓.工具;

import android.app.*;
import android.content.*;
import android.os.*;
import java.util.*;
import 间.接口.*;
import 间.安卓.组件.*;
import 间.安卓.插件.界面插件;

public class 服务 {

    public static void 启动(Context $上下文,Class<?> $类) {
        if (已启动($类.getName()))return;
        $上下文.startService(new Intent($上下文, $类));
    }
    
    public static boolean 已启动(Class<?> $类) {
        return 已启动($类.getName());
    }

    public static boolean 已启动(String $类名) {
        ActivityManager $am = (ActivityManager) 环境.取应用().getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> $服务列表 = (ArrayList<ActivityManager.RunningServiceInfo>)$am.getRunningServices(32767);
        for (ActivityManager.RunningServiceInfo $单个 : $服务列表) {
            if ($单个.service.getClassName().contains($类名)) return true;
        }
        return false;
    }

    public static 连接处理 绑定(基本界面 $界面,Class<?> $类,方法 $成功,方法 $断开) {
        启动($界面,$类);
        连接处理 $处理 = new 连接处理($成功, $断开);
        $界面.bindService(new Intent($界面, $类), $处理, Context.BIND_AUTO_CREATE);
        $界面.注册插件(new 服务插件($处理));
        return $处理;
    }

    public static class 服务插件 extends 界面插件 {

        private 连接处理 处理;
        
        public 服务插件(连接处理 $处理) {
            处理 = $处理;
        }
        
        @Override
        public void 界面销毁事件() {
            当前界面.unbindService(处理);
        }

        @Override
        public void 保存状态事件(Bundle $输出) {
            当前界面.unbindService(处理);
        }
        
    }
    
    public static class 连接处理 implements ServiceConnection {

        基本服务 服务;
        方法 成功;
        方法 断开;
        boolean 已连接 = false;

        public 连接处理(方法 $成功,方法 $断开) {
            成功 = $成功;
            断开 = $断开;
        }

        @Override
        public void onServiceConnected(ComponentName $类名,IBinder $绑定器) {
            已连接 = true;
            服务 = ((基本服务.绑定器)$绑定器).取服务();
            if (成功 != null) 成功.调用(服务);
        }

        @Override
        public void onServiceDisconnected(ComponentName $类名) {
            已连接 = false;
            if (断开 != null) 断开.调用();
        }

        public boolean 已连接() {
            return 已连接;
        }

        public 基本服务 取服务() {
            if (已连接)
                return 服务;
            return null;
        }

    }

}
