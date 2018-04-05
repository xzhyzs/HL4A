package 间.安卓.视图.实现;

import android.view.*;

public interface 基本布局 extends 基本视图 {
    
    public void 加入子视图(View $视图);
    public <类型 extends View> 类型 找子视图(Object $标签);
    public <类型 extends View> 类型 取子视图(int $键值);
    public View[] 取子视图();
    
    public void 删子视图(View $子视图);
    public void 删子视图(int $子视图);
    public void 删子视图();
    
    
}
