package 间.安卓.后端.内容;

import 间.安卓.后端.数据;
import 间.安卓.后端.用户;
import 间.安卓.后端.权限;
import 间.安卓.后端.查询;
import 间.接口.返回值;
import 间.收集.有序列表;
import 间.接口.方法;
import 间.接口.回调方法;
import 间.安卓.工具.线程;
import 间.接口.调用;
import 间.安卓.工具.处理;

public class 关注 extends 数据 {
    
    public 关注() {
        super("Star");
    }
    
    public 关注(用户 $用户,用户 $目标) {
        this();
        置关注用户($用户);
        置关注目标($目标);
    }
    
    public void 置关注用户(用户 $用户) {
        设置("user",$用户);
        置权限(new 权限($用户));
    }

    public 用户 取关注用户() {
        return 取用户("user");
    }

    public void 置关注目标(用户 $用户) {
        设置("target",$用户);
    }

    public 用户 取关注目标() {
        return 取用户("terget");
    }
    
    public void 关注() {
        关注(null);
    }
    
    public void 关注(final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    处理.主线程($回调,同步关注());
                    return null;
                }
            }).启动();
    }
    
    public 返回值<Void> 同步关注() {
        if (取关注用户().equals(取关注目标())) {
            return 返回值.创建(null,new Exception("不能关注自己 ~"));
        }
        查询<关注> $查询 = 查询.新建("Star",关注.class);
        $查询.等于("user",取关注用户());
        $查询.等于("target",取关注目标());
        返回值<有序列表<关注>> $结果 = $查询.查询();
        if (!$结果.成功()) {
            return 返回值.创建(null,$结果.取错误());
        } else {
            if ($结果.取内容().isEmpty()) {
                return 同步保存();
            } else {
                return 返回值.创建(null,new Exception("已经关注过了 ~"));
            }
        }
    }
    
    
}
