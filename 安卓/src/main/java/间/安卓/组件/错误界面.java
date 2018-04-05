package 间.安卓.组件;

import android.os.*;
import 间.接口.*;
import 间.安卓.工具.*;
import 间.安卓.弹窗.*;
import 间.安卓.视图.*;
import 间.安卓.视图.扩展.*;
import 间.安卓.资源.*;
import 间.工具.字符;
import 间.工具.时间;

public class 错误界面 extends 界面 {

    private String 错误内容;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        
        置滑动返回(true);
        
        置标题("崩溃了(ノДＴ)");
        
        取标题栏().左按钮(图标.返回, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    错误界面.this.结束界面();
                    return null;
                }
            });

        取标题栏().右按钮(图标.复制, new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    设备.置剪切板(错误内容);
                    提示.普通("已复制 ~");
                    return null;
                }
            });
        /*
         $标题.右按钮(图标.发送, new 通用方法() {
         @Override
         public Object 调用(Object[] $参数) {
         设备工具.置剪切板(错误内容);
         提示工具.普通("已复制 请发送 ~");
         return null;
         }
         });
         */


        错误内容 = 此.getIntent().getStringExtra("错误");

        if (错误内容 == null) 错误内容 = "未知错误";

        线性布局 $布局 = new 线性布局(此);
        $布局.置填充("16dp");

        滚动文本 $文本 = new 滚动文本($布局);
        $文本.置文本(错误内容);
        
        打开布局($布局);
        
    }

}
