package 间.安卓.组件;

import java.util.Iterator;
import 间.收集.哈希表;
import 间.收集.有序列表;
import hl4a.runtime.StubActivity;

public class 组件管理 {
    
    private static 有序列表<Class<?>> 剩余 = new 有序列表<>();
    private static 哈希表<Class<?>,Class<?>> 分配 = new 哈希表<>();
    private static Iterator<Class<?>> 遍历;

    static {
        剩余.添加所有(StubActivity.class.getDeclaredClasses());
        遍历 = 剩余.iterator();
    }
    
    public static Class<?> 分配界面(Class<?> $类) {
        if (分配.检查($类)) return 分配.读取($类);
        if (!遍历.hasNext()) return null;
        Class<?> $代理 = 遍历.next();
        分配.设置($类,$代理);
        return $代理;
    }
    
}
