package 间.安卓.组件;

import hl4a.runtime.StubActivity;
import java.util.Iterator;
import 间.安卓.内容.界面;
import 间.收集.无序表;
import 间.收集.集合;
import android.content.Intent;
import android.os.IBinder;
import hl4a.runtime.IContentManagerService;
import android.os.RemoteException;

public class 管理服务 extends 基本服务 {

    @Override
    public void 服务创建事件() {
        super.服务创建事件();
        剩余.添加所有((Class<? extends 代理界面>[])StubActivity.class.getDeclaredClasses());
        遍历 = 剩余.iterator();
    }

    @Override
    public IBinder 服务绑定事件(Intent $意图) {
       return new 通信管理();
    }
    
    public class 通信管理 extends IContentManagerService.Stub {

        @Override
        public String next(String $类) throws RemoteException {
            return 分配($类).getName();
        }
        
        
    }
    
    private 集合<Class<? extends 代理界面>> 剩余 = new 集合<>();
    private 无序表 分配 = new 无序表<>();
    private 无序表 反向 = new 无序表<>();
    private Iterator<Class<? extends 代理界面>> 遍历;

    public Class<? extends 代理界面> 分配(String $类) {
        if (分配.检查($类)) return 分配.读取($类);
        if (!遍历.hasNext()) return null;
        Class<? extends 代理界面> $代理 = 遍历.next();
        分配.设置($类,$代理);
        反向.设置($代理,$类);
        return $代理;
    }

}
