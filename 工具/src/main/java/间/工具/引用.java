package 间.工具;

import java.lang.ref.SoftReference;

public class 引用<类型> extends SoftReference<类型> {
    
    public 引用(类型 $对象) {
        super($对象);
    }
    
    public 类型 读取() {
        return get();
    }
    
}
