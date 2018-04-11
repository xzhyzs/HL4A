package 间.安卓.工具;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Window;
import android.view.WindowManager;
import java.util.List;
import 间.安卓.工具.应用;
import 间.工具.ZIP;
import 间.工具.字符;
import 间.工具.时间;
import 间.工具.线程;
import 间.工具.错误;
import 间.接口.打印处理;
import 间.接口.方法;
import 间.接口.调用;
import 间.收集.有序列表;
import 间.收集.有序哈希表;
import 间.注解.代理;
import 间.工具.注解;
import android.content.pm.PackageManager.NameNotFoundException;

public class 应用 {

    public static String 取应用名(String $包名) {
        return 取信息($包名).应用名;
    }

    public static String 取应用名() {
        return 取信息().应用名;
    }

    public static String 取包名() {
        return 取信息().包名;
    }

    public static int 取版本号(String $包名) {
        return 取信息($包名).版本号;
    }

    public static int 取版本号() {
        return 取信息().版本号;
    }

    public static String 取版本名(String $包名) {
        return 取信息($包名).版本名;
    }

    public static String 取版本名() {
        return 取信息().版本名;
    }

    public static String 取地址(String $包名) {
        return 取信息($包名).地址;
    }

    public static String 取地址() {
        return 取信息().地址;
    }

    public static long 取更新时间(String $包名) {
        return 取信息($包名).更新时间;
    }

    public static long 取更新时间() {
        return 取信息().更新时间;
    }

    public static final class 信息 {

        public String 应用名;
        public String 包名;
        public int 版本号;
        public String 版本名;
        public String 地址;
        public long 更新时间;

        public 信息(PackageInfo $信息) {
            地址 = $信息.applicationInfo.sourceDir;
            包名 = $信息.packageName;
            应用名 = $信息.applicationInfo.loadLabel(环境.取应用().getPackageManager()).toString();
            版本号 = $信息.versionCode;
            版本名 = $信息.versionName;
            更新时间 = $信息.lastUpdateTime;
        }

        @Override
        public boolean equals(Object $对象) {
            if (super.equals($对象)) {
                return true;
            }
            if ($对象 instanceof 信息) {
                return 包名.equals(((信息)$对象).包名);
            }
            return false;
        }

    }

    public static boolean 是更新() {
        Long $上次 =  ZIP.取CRC(取信息().地址);
        Long $记录 = (Long)设置.读取("安装包CRC");
        设置.保存("安装包CRC", $上次);
        return $记录 == null || !$上次.equals($记录);
    }

    @代理("错误处理")
    public static void 处理错误(Thread $线程, Throwable $错误) {
        String $错误内容 = 错误.取整个错误($错误);
        字符.保存("%HL4A/错误日志/" + 应用.取应用名() + "/" + 时间.格式() + ".log", $错误内容);
        if (!($线程 instanceof 间.工具.线程)) {
            System.exit(0);
        }
    }
    
    public static void 初始化(Application $应用) {
        环境.置应用($应用);
        初始化();
    }
    
    public static void 初始化() {
        文件.初始化();
        线程.置错误处理(注解.代理(应用.class,"错误处理"));
    }

    public static void 启动(String $包名) {
        环境.取应用().startActivity(环境.取应用().getPackageManager().getLaunchIntentForPackage($包名));
    }

    public static String[] 取所有权限() {
        try {
            return 环境.取应用().getPackageManager().getPackageInfo(应用.取包名(), PackageManager.GET_PERMISSIONS).requestedPermissions;
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
        return new String[0];
    }

    private static 有序哈希表<String,信息> 信息缓存 = new 有序哈希表<>();

    private static 信息 取信息() {
        return 取信息(环境.取应用().getPackageName());
    }

    public static 信息 取信息(String $包名) {
        if (信息缓存.检查($包名)) {
            return 信息缓存.读取($包名);
        }
        try {
            PackageInfo $信息 = 环境.取应用().getPackageManager().getPackageInfo($包名, PackageManager.GET_ACTIVITIES);
        if ($信息 == null)return null;
        信息 $返回 = new 信息($信息);
        信息缓存.设置($包名, $返回);
        return $返回;
        } catch (PackageManager.NameNotFoundException $错误) {}
        return null;
    }

    public static 信息 取安装包信息(String $地址) {
        $地址 = 文件.检查地址($地址);
        PackageInfo $信息 = 环境.取应用().getPackageManager().getPackageArchiveInfo($地址, PackageManager.GET_ACTIVITIES);
        if ($信息 == null)return null;
        信息 $返回 = new 信息($信息);
        return $返回;
    }

    public static int 取状态栏高度(Activity $界面) {
        int $ = $界面.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return $界面.getResources().getDimensionPixelSize($);
    }


    public static boolean 在后台() {
        ActivityManager am = (ActivityManager) 环境.取应用()
            .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskList = am.getRunningTasks(1);
        if (taskList != null && !taskList.isEmpty()) {
            ComponentName topActivity = taskList.get(0).topActivity;
            if (topActivity != null
                && !topActivity.getPackageName().equals(
                    环境.取应用().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean 是横屏() {
        return 环境.取应用().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean 已安装(String $包名) {
        PackageManager $PM = 环境.取应用().getPackageManager();
        try {
            $PM.getPackageInfo($包名, 0);
            return true;
        } catch (PackageManager.NameNotFoundException $错误) {
            return false;
        }
    }

    public static void 全屏(Activity $界面) {
        Window window = $界面.getWindow();
        WindowManager.LayoutParams $参数 = window.getAttributes();
        $参数.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes($参数);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public static void 竖屏(Activity $界面) {
        $界面.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void 横屏(Activity $界面) {
        $界面.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

}
