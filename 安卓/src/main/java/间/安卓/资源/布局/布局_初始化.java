package 间.安卓.资源.布局;

import android.content.Context;
import 间.安卓.工具.主题;
import 间.安卓.工具.应用;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.进度圈;
import 间.安卓.视图.进度条;
import 间.安卓.组件.基本界面;
import 间.安卓.组件.界面;

public class 布局_初始化 extends 线性布局 {

    public 布局_初始化(基本界面 $界面) {
        super($界面);

        置填充("填充");
        置重力("下边");

        进度条 $进度 = new 进度条(this);
        $进度.置自动(true);
        $进度.置标签("进度");
        //$进度.置宽度("最大");
        $进度.置自动(true);
        //$进度.置填充("4dp");

    }

}
