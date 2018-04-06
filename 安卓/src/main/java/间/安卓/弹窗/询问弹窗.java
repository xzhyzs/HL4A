package 间.安卓.弹窗;

import 间.安卓.视图.线性布局;
import android.content.Context;
import android.view.View;

public class 询问弹窗 extends 弹窗 {
    
    private 线性布局 布局;
    
    public 询问弹窗(Context $上下文) {
        super($上下文);
        布局 = new 线性布局($上下文);
        super.置内容(布局);
    }
    
    public void 开关问题(String $问题) {
        
    }

    @Override
    public void 置内容(View $视图) {
        // super.置内容($视图);
    }

    @Override
    public void 置内容(String $内容) {
        // super.置内容($内容);
    }
    
}
