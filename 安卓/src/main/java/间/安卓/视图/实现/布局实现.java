package 间.安卓.视图.实现;

import android.view.*;
import android.widget.*;
import 间.安卓.工具.*;
import android.support.v4.view.ViewGroupCompat;

public class 布局实现 {

    private 布局实现() {}

    // Orientation

    public static void 置方向(LinearLayout $视图,String $方向) {
        switch ($方向) {
            default:
            case "上下":case "垂直":case "vertical":
                $视图.setOrientation(1);break;
            case "左右":case "水平":case "horizontal":
                $视图.setOrientation(0);break;
        }
    }

    // Gravity

    public static void 置重力(LinearLayout $视图,String $重力) {
        $视图.setGravity(视图.检查重力($重力));
    }

    // addView

    public static void 加入子视图(ViewGroup $视图,View $子元素) {
        $视图.addView($子元素);
    }
    
    public static <类型 extends View> 类型 找子视图(ViewGroup $视图,Object $标签) {
        return (类型)$视图.findViewWithTag($标签);
    }

    public static <类型 extends View> 类型 取子视图(ViewGroup $视图,int $键值) {
        return (类型)$视图.getChildAt($键值);
    }

    public static View[] 取子视图(ViewGroup $视图) {
        int $数量 = $视图.getChildCount();
        View[] $所有 = new View[$数量];
        for (int i = 0;i < $数量;i ++) {
            $所有[i] = 取子视图($视图, i);
        }
        return $所有;
    }
    
    public static void 删子视图(ViewGroup $视图) {
        $视图.removeAllViews();
    }
    
    public static void 删子视图(ViewGroup $视图,View $子视图) {
        $视图.removeView($子视图);
    }
    
    public static void 删子视图(ViewGroup $视图,int $子视图) {
        $视图.removeViewAt($子视图);
    }

}
