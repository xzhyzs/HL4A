package 间.安卓.视图.扩展;

import 间.安卓.视图.线性布局;
import android.content.Context;
import android.view.ViewGroup;
import 间.安卓.视图.滚动视图;
import android.view.View;

public class 设置组 extends 滚动视图 {

    public 线性布局 底层;
    
    public 设置组(Context $上下文) {
        super($上下文);
        底层 = new 线性布局($上下文);
        super.加入子视图(底层);
    }

    public 设置组(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    public 设置视图 新建设置() {
        return new 设置视图(底层);
    }
    
    public 设置视图 新建设置(String $名称) {
        设置视图 $设置 = 新建设置();
        $设置.置标题($名称);
        return $设置;
    }

    @Override
    public void 加入子视图(View $视图) {
        底层.加入子视图($视图);
    }


}
    

