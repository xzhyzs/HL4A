package 间.安卓.后端.界面;

import android.os.Bundle;
import com.avos.avoscloud.后端错误;
import 间.安卓.内容.界面;
import 间.安卓.后端.布局.布局_注册界面;
import 间.安卓.后端.用户;
import 间.安卓.工具.提示;
import 间.安卓.工具.线程;
import 间.安卓.弹窗.进度弹窗;
import 间.工具.字符;
import 间.接口.调用;
import 间.接口.返回值;

public class 注册界面 extends 界面 {

    private 布局_注册界面 布局;
    private 进度弹窗 进度;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        super.界面创建事件($恢复);
        置滑动返回(true);
        置返回值(返回码_失败);
        打开布局(new 布局_注册界面(this));
        布局 = 取视图();
        取标题栏().返回按钮(此);
        布局.注册.置单击事件(调用.配置(this,"注册"));
        进度 = new 进度弹窗(此);
        进度.置可关闭(false);
    }
    
    public void 注册() {
        String $用户名 = 布局.用户名.取文本();
        String $密码 = 布局.密码.取文本();
        String $邮箱 = 布局.邮箱.取文本();
        if (字符.是空白($用户名)) {
            提示.警告("用户名不能为空 ~");
            return;
        } else if (字符.是空白($密码)) {
            提示.警告("密码不能为空 ~");
            return;
        } else if(字符.是空白($邮箱)) {
            提示.警告("邮箱不能为空 ~");
            return;
        }
        进度.更新("正在注册 ~");
        进度.显示();
        new 线程(this,"线程注册").启动($用户名,$密码,$邮箱);
    }
    
    public void 线程注册(String $用户名,String $密码,String $邮箱) {
        用户 $注册 = new 用户();
        $注册.置用户名($用户名);
        $注册.置密码($密码);
        $注册.置邮箱($邮箱);
        返回值<Void> $结果 = $注册.同步注册();
        if ($结果.成功()) {
            提示.普通("注册成功 ~");
            进度.隐藏();
            置返回值(返回码_成功);
            结束界面();
        } else {
            后端错误 $错误 = $结果.取错误();
            提示.警告($错误.取错误信息());
            进度.隐藏();
        }
    }

}
