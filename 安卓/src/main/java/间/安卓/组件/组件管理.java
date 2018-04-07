package 间.安卓.组件;

import java.util.Iterator;
import 间.收集.无序表;
import 间.收集.集合;
import hl4a.runtime.StubActivity;

public class 组件管理 {
    
    private 集合<Class<?>> 剩余 = new 集合<>();
    private 无序表 分配 = new 无序表<>();
    private 无序表 反向 = new 无序表<>();
    private Iterator<Class<?>> 遍历;

    public 组件管理() {
        剩余.添加所有(StubActivity.class.getDeclaredClasses());
        遍历 = 剩余.iterator();
    }
    
    public Class<?> 分配界面(Class<?> $类) {
        if (分配.检查($类)) return 分配.读取($类);
        if (!遍历.hasNext()) return null;
        Class<?> $代理 = 遍历.next();
        分配.设置($类,$代理);
        反向.设置($代理,$类);
        return $代理;
    }
    
}
