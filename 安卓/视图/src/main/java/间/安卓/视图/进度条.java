package 间.安卓.视图;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import 间.安卓.工具.绘画;
import 间.安卓.工具.视图;
import 间.安卓.视图.实现.基本布局;
import 间.安卓.视图.实现.基本视图;

public class 进度条<V extends ProgressBar> extends 基本视图<V> {

    public 进度条(Context $上下文) {
        super($上下文);
    }

    public 进度条(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    @Override
    public View 创建(Context $上下文) {
        return new ProgressBar($上下文,null,android.R.attr.progressBarStyleHorizontal);
    }
    
    public void 置进度(int $进度) {
        取视图().setProgress($进度);
    }

    public int 取进度() {
        return 取视图().getProgress();
    }

    public void 置二级进度(int $进度) {
        取视图().setSecondaryProgress($进度);
    }

    public int 取二级进度() {
        return 取视图().getSecondaryProgress();
    }

    public void 置进度颜色(Object $颜色) {
        取视图().setProgressDrawable(绘画.颜色转绘画($颜色));
        取视图().setSecondaryProgressTintList(视图.创建单颜色列表($颜色));
    }
    
    
}
