package 间.安卓.后端.视图;

import android.content.Context;
import android.view.ViewGroup;
import 间.安卓.后端.内容.留言;
import 间.安卓.后端.用户;
import 间.安卓.视图.列表视图;
import 间.安卓.视图.圆形图;
import 间.安卓.视图.线性布局;
import 间.安卓.视图.适配器.基本适配器;
import 间.接口.回调方法;
import 间.接口.返回值;
import 间.收集.哈希表;

public class 留言板 extends 线性布局 {
    
    private 列表视图 列表;
    
    public 留言板(Context $上下文) {
        super($上下文);
        置高度("250dp");
        列表 = new 列表视图($上下文);
    }
    
    public 留言板(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }
    
    public void 更新(用户 $用户) {
        $用户.取留言(new 回调方法<留言>() {
                @Override
                public void 回调(返回值<留言> $回调) {
                    
                }
            });
    }
    
    public class 留言适配器 extends 基本适配器<布局_适配器_留言> {

        @Override
        public 布局_适配器_留言 创建() {
            return new 布局_适配器_留言();
        }

        @Override
        public 布局_适配器_留言 处理(布局_适配器_留言 $视图,哈希表 $参数) {
            
            return $视图;
        }
        
    }
    
    public class 布局_适配器_留言 extends 线性布局 {

        public 线性布局 用户栏;
        public 圆形图 头像;

        public 布局_适配器_留言() {
            super(留言板.this.getContext());
            置高度("自动");
            用户栏 = new 线性布局(this);
            用户栏.置高度("自动");
            用户栏.置填充("8dp");
            头像 = new 圆形图();
        }

    }
    
}
