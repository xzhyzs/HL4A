package 间.收集;

import java.util.*;

public class 无序表 extends HashMap {

    private static final long serialVersionUID = 3530384865377424460L;

    public 无序表() {
        super();
    }

    public 无序表(Map $表) {
        super($表);
    }

    public int 长度() {
        return size();
    }

    public Boolean 检查(Object $键值) {
        return containsKey($键值);
    }

    public Boolean 检查内容(Object $键值) {
        return containsValue($键值);
    }

    public 无序表 设置(Object $键值,Object $内容) {
        put($键值, $内容);
        return this;
    }

    public <内容> 内容 读取(Object $键值) {
        return (内容)get($键值);
    }
    
    public Object 读取对象(Object $键值) {
        return get($键值);
    }

    public <内容> 内容 删除(Object $键值) {
        return (内容)remove($键值);
    }

    public void 清空() {
        clear();
    }
}
