package 间.安卓.视图;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import 间.安卓.工具.视图;
import 间.安卓.视图.实现.基本布局;

public class 编辑框<V extends EditText> extends 文本视图<V> {

    public 编辑框(Context $上下文) {
        super($上下文);
    }

    public 编辑框(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    @Override
    public View 创建(Context $上下文) {
        return new EditText($上下文);
    }
    
    public void 置默认文本(String $内容) {
        取视图().setHint($内容);
    }

    public String 取默认文本() {
        return 取视图().getHint().toString();
    }

    public void 置默认文本颜色(Object $颜色) {
        取视图().setHintTextColor(视图.检查颜色($颜色));
    }

    public void 置输入类型(Object $类型) {
        取视图().setInputType(视图.检查输入类型($类型));
    }

    public int 取输入类型() {
        return 取视图().getInputType();
    }

    public void 置输入重力(String $重力) {
        取视图().setGravity(视图.检查重力($重力));
    }
    
}
