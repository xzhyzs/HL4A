package 间.收集;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import 间.工具.字符;
import 间.工具.数组;

public class 对象列表 extends ArrayList {
    
    public 对象列表() {
        super();
    }
    
    public 对象列表(Collection $列表) {
        this();
        添加所有($列表);
    }

    public 对象列表(Object[] $列表) {
        this();
        添加所有($列表);
    }

    public String 分解() {
        return 分解("\n");
    }

    public String 分解(String $分隔) {
        return 分解(this, $分隔);
    }

    public static String 分解(List $集合) {
        return 分解($集合, "");
    }

    public static String 分解(List $集合, String $分隔) {
        return 字符.分解($集合.toArray(), $分隔);
    }

    public 对象列表 添加(int $键值, Object $对象) {
        add($键值, $对象);
        return this;
    }

    public 对象列表 添加(Object $对象) {
        add($对象);
        return this;
    }

    public 对象列表 添加所有(Object[] $对象) {
        for (Object $单个 : $对象) {
            add($单个);
        }
        return this;
    }

    public 对象列表 添加所有(int $键值, Collection<Object> $集合) {
        addAll($键值, $集合);
        return this;
    }

    public 对象列表 添加所有(Collection<Object> $集合) {
        addAll($集合);
        return this;
    }

    public Object 删除(int $键值) {
        return remove($键值);
    }

    public boolean 删除对象(Object $对象) {
        return remove($对象);
    }

    public <内容> 内容 读取(int $键值) {
        return (内容)get($键值);
    }

    public 对象列表 设置(int $键值, Object $对象) {
        set($键值, $对象);
        return this;
    }

    public Boolean 检查(int $键值) {
        return 读取($键值) == null;
    }

    public Boolean 检查(Object $内容) {
        return contains($内容);
    }

    public int 数量() {
        return size();
    }

    public 对象列表 清空() {
        clear();
        return this;
    }

    public Object[] 到数组() {
        return toArray();
    }
    
}
