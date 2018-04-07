package 间.安卓.组件;

import hl4a.runtime.StubActivity;
import java.util.Iterator;
import 间.安卓.内容.界面;
import 间.收集.无序表;
import 间.收集.集合;
import 间.安卓.工具.服务;
import hl4a.runtime.ContentManagerService;
import android.content.Intent;
import 间.接口.方法;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.content.ComponentName;
import 间.接口.调用;
import hl4a.runtime.IContentManagerService;
import 间.工具.反射;
import android.os.RemoteException;
import 间.接口.返回值;
import 间.工具.线程;
import 间.安卓.工具.提示;
import 间.安卓.插件.界面插件;
import 间.安卓.工具.应用;
import 间.安卓.工具.环境;

public class 组件管理 {

    private static IContentManagerService 服务;

    public static void 连接(final 基本界面 $上下文) {
        final ServiceConnection $连接处理;
        Intent $意图 = new Intent();
        $意图.setPackage($上下文.getPackageName());
        $意图.setAction("hl4a.cm");
        $上下文.bindService($意图,
                         $连接处理 = new ServiceConnection() {
                             @Override
                             public void onServiceConnected(ComponentName $名称,IBinder $绑定器) {
                                 服务 = IContentManagerService.Stub.asInterface($绑定器);
                             }
                             @Override
                             public void onServiceDisconnected(ComponentName $名称) {
                                 连接($上下文);
                             }
                         }, Context.BIND_AUTO_CREATE);
        $上下文.注册插件(new 界面插件() {
                @Override
                public void 界面销毁事件() {
                    $上下文.unbindService($连接处理);
                }
            });
    }

    public static 返回值<Class<? extends 代理界面>> 分配(基本界面 $上下文,Class<? extends 界面> $类) {
        try {
            if (服务 == null) {
                连接($上下文);
                while (服务 == null) {
                    线程.暂停(20);
                    提示.日志("等待连接管理服务 暂停20毫秒");
                }
            }
            return 返回值.创建((Class<? extends 代理界面>)反射.取类(服务.next($类.getName())));
        } catch (RemoteException $错误) {
            return 返回值.创建(null, $错误);
        }
    }



}
