package 间.安卓.弹窗;

import android.app.*;
import 间.安卓.资源.布局.*;
import 间.安卓.视图.*;
import 间.安卓.工具.*;
import 间.接口.*;

public class 进度弹窗 extends 弹窗 {
    
    public 布局_加载中 布局;
    public 文本视图 文本;
    
    public 进度弹窗(Activity $界面) {
        super($界面);
        布局 = new 布局_加载中($界面);
        文本 = 布局.文本;
        置内容(布局);
        无限(true);
    }
    
    public void 无限(boolean $是否) {
        处理.主线程调用(布局.进度,"置自动",$是否);
    }
    
    public void 更新(int $进度) {
        处理.主线程调用(布局.进度,"置进度",$进度);
    }
    
    public void 更新(String $内容) {
        处理.主线程调用(文本,"置文本",$内容);
    }
  
    
}
