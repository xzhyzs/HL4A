package 间.安卓.后端.内容;

import 间.安卓.后端.数据;
import 间.安卓.后端.用户;
import 间.安卓.后端.权限;
import java.util.Date;
import 间.工具.时间;
import 间.收集.有序列表;

public class 留言 extends 数据 {
    
    public 留言() {
        super("Msg");
    }
    
    public 留言(用户 $用户,用户 $目标,String $内容) {
        this();
        置发言用户($用户);
        置目标用户($目标);
        置发言内容($内容);
    }
    
    public void 置发言用户(用户 $用户) {
        设置("user",$用户);
        置权限(new 权限($用户));
    }
    
    public 用户 取发言用户() {
        return 取用户("user");
    }
    
    public void 置目标用户(用户 $用户) {
        设置("target",$用户);
    }

    public 用户 取目标用户() {
        return 取用户("terget");
    }
    
    public void 置发言内容(String $内容) {
        设置("msg",$内容);
    }
    
    public String 取发言内容() {
        return 读取("msg");
    }
    
    public 留言 取上级() {
        return 读取("super");
    }
    
    public void 置上级(留言 $上级) {
        设置("super",$上级);
    }
    
    public Date 取发言时间() {
        return 取创建时间();
    }
    
}
