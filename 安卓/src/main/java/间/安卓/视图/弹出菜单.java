package 间.安卓.视图;

import android.view.*;
import android.widget.*;
import 间.接口.*;
import 间.安卓.视图.事件.*;
import 间.安卓.视图.适配器.*;
import 间.收集.*;
import 间.安卓.工具.*;
import 间.工具.反射;

public class 弹出菜单 extends ListPopupWindow {

    private 数组适配器 适配器;
    private 哈希表<Integer,方法> 单击 = new 哈希表<>();

    public 弹出菜单(View $视图) {
        super($视图.getContext());
        setAnchorView($视图);
        适配器 = new 数组适配器($视图.getContext());
        setAdapter(适配器);
        setOnItemClickListener(new 项目单击(调用.代理(this,"单击事件")));
        setModal(true);
    }

    void 单击事件(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        方法 $单击 = 单击.读取($键值);
        隐藏();
        调用.事件($单击);
    }
    

    private String 最大 = "";

    public void 添加(String $名称,方法 $单击) {
        if ($名称.length() > 最大.length()) {
            最大 = $名称;
        }
        单击.设置(适配器.getCount(), $单击);
        适配器.添加($名称);
        预置宽度();
    }

    private void 预置宽度() {
        int $大小 = 适配器.预测宽度();
        if ($大小 < (设备.取屏幕宽度() * 0.618 * 0.618)) {
            $大小 = new Double(设备.取屏幕宽度() * 0.618 * 0.618).intValue();
        }
        setWidth($大小);
    }

    public void 置宽度(Object $宽度) {
        setWidth(视图.检查大小($宽度));
    }

    public void 显示() {
        if ("".equals(最大)) return;
        show();
    }

    public void 隐藏() {
        dismiss();
    }

}
