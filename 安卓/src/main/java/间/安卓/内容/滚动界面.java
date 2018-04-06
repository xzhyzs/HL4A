package 间.安卓.内容;

import android.os.Bundle;
import android.view.View;
import 间.安卓.视图.滚动视图;

public class 滚动界面 extends 界面 {

    private 滚动视图 滚动;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        滚动 = new 滚动视图(此);
        super.打开布局(滚动);
    }

    @Override
    public <视图 extends View> 视图 打开布局(View $视图) {
        滚动.删子视图();
        滚动.加入子视图($视图);
        置当前视图($视图);
        return (视图)$视图;
    }
    
}
