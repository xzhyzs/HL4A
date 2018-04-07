package 间.安卓.后端.视图;

import android.content.Context;
import android.view.ViewGroup;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.列表视图;

public class 留言板 extends 线性布局 {
    
    private 列表视图 列表;
    
    public 留言板(Context $上下文) {
        super($上下文);
    }
    
    public 留言板(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }
    
}
