package 间.安卓.组件;

import hl4a.runtime.StubActivity;
import 间.收集.集合;
import 间.工具.反射;
import 间.收集.无序表;
import java.util.Iterator;

public class 界面管理 {
    
    private static 集合<Class<? extends 代理界面>> 剩余 = new 集合<>();
    private static 无序表<Class<? extends 界面>,Class<? extends 代理界面>> 分配 = new 无序表<>();
    private static 无序表<Class<? extends 代理界面>,Class<? extends 界面>> 反向 = new 无序表<>();
    private static Iterator<Class<? extends 代理界面>> 遍历;
    
    static {
        剩余.添加所有((Class<? extends 代理界面>[])StubActivity.class.getDeclaredClasses());
        遍历 = 剩余.iterator();
    }
    
    public static Class<? extends 代理界面> 分配(Class<? extends 界面> $类) {
        if (分配.检查($类)) return 分配.读取($类);
        if (!遍历.hasNext()) return null;
        Class<? extends 代理界面> $代理 = 遍历.next();
        分配.设置($类,$代理);
        反向.设置($代理,$类);
        剩余.删除对象($类);
        return $代理;
    }
    
    public static Class<? extends 界面> 取当前界面(Class<? extends 代理界面> $界面) {
        return 反向.读取($界面);
    }
    
    public static void 界面销毁(代理界面 $界面) {
        剩余.添加($界面.getClass());
    }
    
}
