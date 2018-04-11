package 间.收集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 对象哈希表 extends HashMap {

    public 对象哈希表() {
        super();
    }

    public 对象哈希表(Map $表) {
        super($表);
    }

    public int 长度() {
        return size();
    }

    public Boolean 检查(Object $Object) {
        return containsKey($Object);
    }

    public Boolean 检查内容(Object $内容) {
        return containsValue($内容);
    }

    public 对象哈希表 设置(Object $键值,Object $内容) {
        put($键值, $内容);
        return this;
    }

    public <内容> 内容 读取(Object $键值) {
        return (内容)get($键值);
    }

    public <内容> 内容 删除(Object $键值) {
        return (内容)remove($键值);
    }

    public void 清空() {
        clear();
    }

    public boolean 为空() {
        return isEmpty();
    }

    public  列表<Entry> 列表() {
        return new 列表<Entry>().添加所有(entrySet());
    }

    public  列表 内容列表() {
        return new 列表<>().添加所有(values());
    }
}
