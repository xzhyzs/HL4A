package 间.安卓.后端.视图;

import android.content.Context;
import android.view.ViewGroup;
import 间.安卓.后端.内容.留言;
import 间.安卓.后端.用户;
import 间.安卓.视图.列表视图;
import 间.安卓.视图.圆形图;
import 间.安卓.视图.文本视图;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.进度圈;
import 间.安卓.视图.适配器.基本适配器;
import 间.接口.回调方法;
import 间.接口.方法;
import 间.接口.返回值;
import 间.收集.有序哈希表;
import 间.收集.有序列表;
import 间.安卓.工具.字体;
import 间.安卓.工具.提示;
import 间.工具.时间;
import 间.收集.对象哈希表;
import com.avos.avoscloud.AVObject;

public class 留言板 extends 线性布局 {
    
    private 文本视图 文本;
    private 进度圈 进度;
    private 列表视图 列表;
    private 留言适配器 适配器;
    
    public 留言板(Context $上下文) {
        super($上下文);
        置高度("250dp");
        置重力("中间");
        文本 = new 文本视图(this);
        文本.置文本颜色("控件");
        文本.置单击事件(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    更新();
                    return null;
                }
            });
        文本.隐藏();
        进度 = new 进度圈(this);
        进度.置自动(true);
        列表 = new 列表视图(this);
        适配器 = new 留言适配器();
        列表.置适配器(适配器);
        列表.隐藏();
    }
    
    public 留言板(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }
    
    private 用户 当前;
    
    public void 置用户(用户 $用户) {
        当前 = $用户;
    }
    
    public void 更新() {
        提示.普通("正在更新 ~");
        进度.显示();
        文本.隐藏();
        列表.隐藏();
        当前.取留言(new 回调方法<有序列表<留言>>() {
                @Override
                public void 回调(返回值<有序列表<留言>> $回调) {
                    if ($回调.成功()) {
                        适配器.清空();
                        有序列表<留言> $所有 = $回调.取内容();
                        if ($所有.isEmpty()) {
                            进度.隐藏();
                            文本.显示();
                            文本.置文本("还没有留言 ~");
                            列表.隐藏();
                            return;
                        }
                        for (留言 $单个 : $所有) {
                            对象哈希表 $参数 = new 对象哈希表();
                            $参数.设置("留言",$单个);
                            适配器.添加($参数);
                        }
                        适配器.发送重绘事件();
                        进度.隐藏();
                        文本.隐藏();
                        列表.显示();
                    } else {
                        进度.隐藏();
                        文本.显示();
                        文本.置文本($回调.取错误信息());
                        列表.隐藏();
                    }
                    
                }
            });
    }
    
    public class 留言适配器 extends 基本适配器<布局_适配器_留言> {
        
        @Override
        public 布局_适配器_留言 创建() {
            return new 布局_适配器_留言();
        }

        @Override
        public 布局_适配器_留言 处理(final 布局_适配器_留言 $视图,对象哈希表 $参数) {
            final 留言 $留言 = $参数.读取("留言");
            用户 $用户 = $留言.取发言用户();
            $用户.刷新(new 回调方法<用户>() {
                    @Override
                    public void 回调(返回值<用户> $回调) {
                        if (!$回调.成功()) {
                            $视图.隐藏();
                            return;
                        }
                        $回调.取内容().显示头像($视图.头像);
                        $视图.用户名.置文本($回调.取内容().取用户名());
                        $视图.时间.置文本(时间.比较($留言.取发言时间()));
                        $视图.内容.置文本($留言.取发言内容());
                    }
                });
            return $视图;
        }
        
    }
    
    public class 布局_适配器_留言 extends 线性布局 {

        public 线性布局 头像布局;
        public 圆形图 头像;
        public 线性布局 信息布局;
        public 文本视图 用户名;
        public 文本视图 时间;
        public 文本视图 内容;
        
        public 布局_适配器_留言() {
            super(留言板.this.getContext());
            置方向("水平");
            置高度("自动");
            置填充("16dp");
            头像布局 = new 线性布局(this);
            头像布局.置宽度("自动");
            头像布局.置填充("8dp");
            头像 = new 圆形图(头像布局);
            头像.置宽度("35dp");
            头像.置高度("35dp");
            信息布局 = new 线性布局(this);
            信息布局.置重力("中间垂直");
            用户名 = new 文本视图(信息布局);
            用户名.置文本颜色("黑色");
            用户名.置文本字体(字体.无衬线体.加粗);
            时间 = new 文本视图(信息布局);
            时间.置上边距("4dp");
            时间.置文本大小("10sp");
            时间.置下边距("8dp");
            内容 = new 文本视图(信息布局);
            内容.置文本颜色("黑色");
            内容.置文本字体(字体.有衬线体.普通);
        }

    }
    
}
