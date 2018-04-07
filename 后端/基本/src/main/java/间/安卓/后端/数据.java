package 间.安卓.后端;

import com.avos.avoscloud.后端错误;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import 间.安卓.工具.文件;
import 间.安卓.工具.线程;
import 间.工具.字节;
import 间.工具.断言;
import 间.接口.方法;
import 间.接口.返回值;
import 间.接口.调用;
import com.avos.avoscloud.SaveCallback;
import java.io.InputStream;
import com.avos.avoscloud.GetCallback;
import com.avos.avoscloud.GetDataStreamCallback;
import com.avos.avoscloud.DeleteCallback;
import java.util.Date;

public class 数据 extends AVObject {

    public 数据() {
        super();
        setClassName(getClass().getSimpleName());
    }
    
    public 数据(String $表名) {
        super($表名);
    }

    public Date 取创建时间() {
        return getCreatedAt();
    }
    
    public Date 取更新时间() {
        return getUpdatedAt();
    }
    
    public void 设置(String $键值,Object $内容) {
        put($键值, $内容);
    }

    public <类型> 类型 读取(String $键值) {
        return (类型)get($键值);
    }

    public void 置权限(权限 $权限) {
        setACL($权限);
    }

    public AVFile 置文件(String $键值,String $地址) {
        AVFile $文件 = null;
        put($键值, ($文件 = new AVFile(文件.取名称($地址), 字节.读取($地址))));
        return $文件;
    }

    public AVFile 置文件(String $键值,byte[] $内容) {
        AVFile $文件 = null;
        put($键值, ($文件 = new AVFile($内容)));
        return $文件;
    }
    
    public Date 取时间(String $键值) {
        return getDate($键值);
    }

    public 用户 取用户(String $键值) {
        return getAVUser($键值, 用户.class);
    }

    public AVFile 取文件对象(String $键值) {
        return getAVFile($键值);
    }

    public 返回值<InputStream> 取文件(String $键值) {
        AVFile $文件 = 取文件对象($键值);
        if ($文件 == null) {
            return 返回值.创建(null, new 后端错误(105));
        }
        try {
            return 返回值.创建($文件.getDataStream());
        } catch (后端错误 $错误) {
            return 返回值.创建(null, $错误);
        }
    }

    public void 取文件(final String $键值,final 方法 $回调) {
        AVFile $文件 = 取文件对象($键值);
        if ($文件 == null) {
            调用.事件($回调, 返回值.创建(null, new 后端错误(105)));
            return;
        }
        $文件.getDataStreamInBackground(new GetDataStreamCallback() {
                @Override
                public void done(InputStream $流,后端错误 $错误) {
                    调用.事件($回调, 返回值.创建($流, $错误));
                }
            });

    }

    public 返回值<Void> 同步保存() {
        try {
            save();
            return 返回值.创建(null);
        } catch (后端错误 $错误) {
            return 返回值.创建(null, $错误);
        }
    }

    public void 保存(final 方法 $回调) {
        saveInBackground(new SaveCallback() {
                @Override
                public void done(后端错误 $错误) {
                    调用.事件($回调, 返回值.创建(null, $错误));
                }
            });
    }

    public void 保存() {
        saveInBackground();
    }

    public 返回值<Void> 同步删除() {
        try {
            delete();
            return 返回值.成功;
        } catch (后端错误 $错误) {
            return 返回值.创建(null,$错误);
        }
    }
    
    public void 删除(final 方法 $回调) {
        deleteInBackground(new DeleteCallback() {
                @Override
                public void done(后端错误 $错误) {
                    调用.事件($回调, 返回值.创建(null, $错误));
                }
            });
    }

    public void 删除() {
        deleteInBackground();
    }



}
