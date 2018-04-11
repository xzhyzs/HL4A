package 间.收集;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class 哈希表<键值,内容> extends HashMap<键值,内容> {

    public 哈希表() {
        super();
    }
    
    public 哈希表(Map<键值,内容> $表) {
        super($表);
    }

    public int 长度() {
        return size();
    }

    public Boolean 检查(Object $键值) {
        return containsKey($键值);
    }

    public Boolean 检查内容(Object $内容) {
        return containsValue($内容);
    }

    public 哈希表<键值,内容> 设置(键值 $键值,内容 $内容) {
        put($键值, $内容);
        return this;
    }

    public 内容 读取(Object $键值) {
        return get($键值);
    }

    public 内容 删除(Object $键值) {
        return remove($键值);
    }

    public void 清空() {
        clear();
    }
    
    public boolean 为空() {
        return isEmpty();
    }
    
    public 列表<Entry<键值,内容>> 列表() {
        return new 列表<Entry<键值,内容>>().添加所有(entrySet());
    }
    
    public 列表<内容> 内容列表() {
        return new 列表<内容>().添加所有(values());
    }

}
