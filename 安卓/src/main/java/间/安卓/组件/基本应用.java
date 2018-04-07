package 间.安卓.组件;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import 间.安卓.工具.应用;
import 间.安卓.工具.检查;
import 间.安卓.插件.应用插件;
import 间.收集.集合;

public class 基本应用 extends Application {

    public final 集合<应用插件> 所有插件 = new 集合<>();
    public final 组件管理 组件 = new 组件管理();
    
    static {

        检查.禁用Xposed();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        应用.初始化应用(this);
        应用创建事件();
        for (应用插件 $单个 : 所有插件) {
            $单个.初始化();
        }

    }

    public void 注册插件(应用插件 $插件) {
        if ($插件 == null)return;
        synchronized (所有插件) {
            所有插件.添加($插件);
            $插件.应用 = this;
        }

    }
   
    @Override
    public void onConfigurationChanged(Configuration $新设置) {
        super.onConfigurationChanged($新设置);
        设置改变事件($新设置);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        应用销毁事件();
    }

    

    public void 应用创建事件() {}
    public void 应用销毁事件() {}
    public void 处理环境事件(Context $上下文) {}
    public void 设置改变事件(Configuration $新设置) {}

}
