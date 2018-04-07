package 间.安卓.资源.布局;

import 间.安卓.视图.线性布局;
import android.content.Context;
import 间.安卓.视图.扩展.标题栏;
import 间.安卓.视图.扩展.滚动文本;

public class 布局_错误界面 extends 线性布局 {
    
    public 标题栏 标题;
    public 滚动文本 文本;
    
    public 布局_错误界面(Context $上下文) {
        super($上下文);
        标题 = new 标题栏(this);
        文本 = new 滚动文本(this);
        文本.置填充("16dp");
    }
    
}
