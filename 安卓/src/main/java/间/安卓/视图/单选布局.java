package 间.安卓.视图;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import 间.安卓.视图.实现.基本布局;
import 间.安卓.视图.实现.布局实现;
import 间.安卓.视图.实现.视图实现;
import 间.接口.方法;

public class 单选布局 extends RadioGroup implements 基本布局 {
    
    
    public 单选布局(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
    }
    
    public 单选布局(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    @Override
    public void 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
    }

    @Override
    public void 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
    }
    
    public void 置重力(String $重力) {
        布局实现.置重力(this, $重力);
    }

    public void 置方向(String $方向) {
        布局实现.置方向(this, $方向);
    }

    @Override
    public void 加入子视图(View $视图) {
        布局实现.加入子视图(this,$视图);
    }

    @Override
    public <类型 extends View> 类型 找子视图(Object $标签) {
        return 布局实现.找子视图(this,$标签);
    }

    @Override
    public <类型 extends View> 类型 取子视图(int $键值) {
        return 布局实现.取子视图(this,$键值);
    }

    @Override
    public View[] 取子视图() {
        return 布局实现.取子视图(this);
    }

    @Override
    public void 删子视图(View $子视图) {
        布局实现.删子视图(this,$子视图);
    }

    @Override
    public void 删子视图(int $子视图) {
        布局实现.删子视图(this,$子视图);
    }

    @Override
    public void 删子视图() {
        布局实现.删子视图(this);
    }

    @Override
    public void 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
    }

    @Override
    public void 打开(Activity $界面) {
        视图实现.打开(this, $界面);
    }

    @Override
    public void 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public void 置单击事件(方法 $事件) {
        视图实现.置单击事件(this, $事件);
    }

    @Override
    public void 置长按事件(方法 $事件) {
        视图实现.置长按事件(this, $事件);
    }

    @Override
    public void 置触摸事件(方法 $事件) {
        视图实现.置触摸事件(this, $事件);
    }

    @Override
    public void 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
    }

    @Override
    public void 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
    }

    @Override
    public void 置状态(String $状态) {
        视图实现.置状态(this, $状态);
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public void 显示() {
        视图实现.显示(this);
    }

    @Override
    public void 占位() {
        视图实现.占位(this);
    }

    @Override
    public void 隐藏() {
        视图实现.隐藏(this);
    }

    @Override
    public void 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
    }

    @Override
    public void 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
    }

    @Override
    public void 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
    }

    @Override
    public void 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
    }

    @Override
    public void 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
    }

    @Override
    public void 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
    }

    @Override
    public void 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
    }

    @Override
    public void 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
    }

    @Override
    public void 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
    }

    @Override
    public void 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
    }

    @Override
    public void 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
    }

    @Override
    public void 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
    }
    
    @Override
    public void 置上下边距(Object $边距) {
        视图实现.置上下边距(this,$边距);
    }

    @Override
    public void 置左右边距(Object $边距) {
        视图实现.置左右边距(this,$边距);
    }

    @Override
    public void 置上下填充(Object $填充) {
        视图实现.置上下填充(this,$填充);
    }

    @Override
    public void 置左右填充(Object $填充) {
        视图实现.置左右填充(this,$填充);
    }
    
    @Override
    public void 置阴影(Object $阴影) {
        视图实现.置阴影(this, $阴影);
    }
    
}
