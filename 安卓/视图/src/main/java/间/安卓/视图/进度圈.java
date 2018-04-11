package 间.安卓.视图;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import 间.安卓.视图.实现.基本布局;

public class 进度圈<V extends ProgressBar> extends 进度条<V> {

    public 进度圈(Context $上下文) {
        super($上下文);
    }

    public 进度圈(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    @Override
    public View 创建(Context $上下文) {
        return new ProgressBar($上下文,null,android.R.attr.progressBarStyleInverse);
    }
    
}
