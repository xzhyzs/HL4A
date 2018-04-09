package 间.安卓.后端.内容;

import 间.安卓.后端.数据;
import 间.收集.哈希表;
import 间.安卓.工具.检查;

public class 缓存<内容 extends 数据> {
    
    private 哈希表<String,内容> 缓存 = new 哈希表<>();
    
    public 内容 取内容(内容 $内容) {
        if (缓存.检查($内容.getObjectId())) {
            return 缓存.读取($内容.getObjectId());
        }
        return null;
    }
    
    public void 置内容(内容 $内容) {
        缓存.设置($内容.getObjectId(),$内容);
    }
    
}
