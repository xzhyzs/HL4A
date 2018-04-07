package 间.安卓.组件;

import android.os.Bundle;
import 间.安卓.内容.界面;
import 间.安卓.工具.提示;
import 间.安卓.工具.设备;
import 间.安卓.视图.扩展.滚动文本;
import 间.安卓.视图.线性布局;
import 间.安卓.资源.图标;
import 间.接口.方法;
import 间.安卓.资源.布局.布局_错误界面;

public class 错误界面 extends 基本界面 {

    private String 错误内容;
    private 布局_错误界面 布局;
    
    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        布局 = 打开布局(new 布局_错误界面(this));
        布局.文本.置文本(getIntent().getStringExtra("错误"));
        置滑动返回(true);
        布局.标题.置标题("崩溃了(ノДＴ)");
        布局.标题.左按钮(图标.返回, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    错误界面.this.结束界面();
                    return null;
                }
            });
        布局.标题.右按钮(图标.复制, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    设备.置剪切板(错误内容);
                    提示.普通("已复制 ~");
                    return null;
                }
            });

        
    }

}
