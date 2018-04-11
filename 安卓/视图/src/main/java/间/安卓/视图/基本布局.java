package 间.安卓.视图;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import 间.安卓.工具.视图;
import android.content.Context;

public abstract class 基本布局<V extends ViewGroup> extends 基本视图<V> {
    
    public 基本布局(Context $上下文) {
        super($上下文);
    }
    
    public 基本布局(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    public void 置方向(String $方向) {
        switch ($方向) {
            default:
            case "上下":case "垂直":case "vertical":
                ((LinearLayout)取视图()).setOrientation(1);break;
            case "左右":case "水平":case "horizontal":
                ((LinearLayout)取视图()).setOrientation(0);break;
        }
    }

    // Gravity

    public void 置重力(String $重力) {
        ((LinearLayout)取视图()).setGravity(视图.检查重力($重力));
    }

    // addView

    public void 加入子视图(View $子元素) {
        取视图().addView($子元素);
    }

    public <类型 extends View> 类型 找子视图(Object $标签) {
        return (类型)取视图().findViewWithTag($标签);
    }

    public <类型 extends View> 类型 取子视图(int $键值) {
        return (类型)取视图().getChildAt($键值);
    }

    public View[] 取子视图() {
        int $数量 = 取视图().getChildCount();
        View[] $所有 = new View[$数量];
        for (int i = 0;i < $数量;i ++) {
            $所有[i] = 取子视图(i);
        }
        return $所有;
    }

    public void 删子视图() {
        取视图().removeAllViews();
    }

    public void 删子视图(View $子视图) {
        取视图().removeView($子视图);
    }

    public void 删子视图(int $子视图) {
        取视图().removeViewAt($子视图);
    }
    
}
