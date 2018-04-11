package 间.安卓.工具;

import android.app.*;
import android.content.*;
import android.os.*;
import java.util.*;
import 间.接口.*;

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

}
