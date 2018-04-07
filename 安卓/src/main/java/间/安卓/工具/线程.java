package 间.安卓.工具;

import android.os.*;
import 间.接口.*;

public class 线程 extends 间.工具.线程 {
    
    public 线程(方法 $方法) {
        super($方法);
    }

    public 线程(Object $对象,String $方法名) {
        super($对象,$方法名);
    }
    
    public static boolean 是主线程() {
        return Looper.getMainLooper().getThread() == 取当前线程();
    }
    
}
