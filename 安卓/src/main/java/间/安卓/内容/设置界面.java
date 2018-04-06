package 间.安卓.内容;

import android.os.Bundle;
import 间.安卓.视图.扩展.设置组;
import 间.安卓.视图.扩展.设置视图;

public class 设置界面 extends 界面 {

    private 设置组 设置;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        设置 = new 设置组(此);
        打开布局(设置);
    }
    
    public 设置组 取设置() {
        return 设置;
    }
    
    public 设置视图 新建设置() {
        return 设置.新建设置();
    }

    public 设置视图 新建设置(String $名称) {
        return 设置.新建设置($名称);
    }
    
    
}
