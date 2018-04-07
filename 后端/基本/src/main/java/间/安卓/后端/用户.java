package 间.安卓.后端;

import com.avos.avoscloud.后端错误;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestEmailVerifyCallback;
import com.avos.avoscloud.SignUpCallback;
import 间.接口.方法;
import 间.接口.调用;
import 间.接口.返回值;
import android.content.Context;
import 间.安卓.工具.环境;
import android.graphics.Bitmap;
import com.avos.avoscloud.AVCallback;
import 间.工具.编码;
import 间.安卓.工具.图片;
import 间.工具.字节;
import java.io.InputStream;
import 间.安卓.工具.线程;
import android.widget.ImageView;
import 间.安卓.视图.图片视图;
import 间.安卓.视图.实现.图片实现;
import 间.安卓.工具.处理;
import 间.安卓.工具.设置;
import 间.安卓.工具.提示;
import com.avos.avoscloud.AVFile;
import 间.收集.集合;
import 间.安卓.后端.内容.留言;
import 间.安卓.后端.内容.关注;
import 间.接口.回调方法;

public class 用户 extends AVUser {

    public 用户() {
        super();
    }
    
    public void 取粉丝(final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    调用.事件($回调,同步取粉丝());
                    return null;
                }
            }).启动();
    }
    
    public 返回值<集合<用户>> 同步取粉丝() {

        查询<关注> $查询 = new 查询<>("Star");
        $查询.等于("target",this);
        返回值<集合<关注>> $结果 = $查询.查询();
        if ($结果.成功()) {
            集合<关注> $关注 = $结果.取内容();
            集合<用户> $粉丝 = new 集合<>();
            for (关注 $单个 : $关注) {
                $粉丝.添加($单个.取关注用户());
            }
            return 返回值.创建($粉丝);
        } else {
            return 返回值.创建(null,$结果.取错误());
        }
        
    }
    
    public void 取关注(final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    调用.事件($回调,同步取关注());
                    return null;
                }
            }).启动();
    }
    
    
    public 返回值<集合<用户>> 同步取关注() {
        
        查询<关注> $查询 = new 查询<>("Star");
        $查询.等于("user",this);
        返回值<集合<关注>> $结果 = $查询.查询();
        if ($结果.成功()) {
            集合<关注> $关注 = $结果.取内容();
            集合<用户> $粉丝 = new 集合<>();
            for (关注 $单个 : $关注) {
                $粉丝.添加($单个.取关注目标());
            }
            return 返回值.创建($粉丝);
        } else {
            return 返回值.创建(null,$结果.取错误());
        }
        
    }
    
    public void 取留言(final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    调用.事件($回调,同步取留言());
                    return null;
                }
            }).启动();
    }
    
    public 返回值<集合<留言>> 同步取留言() {
        
        查询<留言> $查询 = new 查询<>("Msg");
        $查询.等于("target",this);
        return $查询.查询();
        
    }

    public void 置用户名(String $用户名) {
        setUsername($用户名);
    }

    public String 取用户名() {
        return getUsername();
    }

    public void 置密码(String $密码) {
        setPassword($密码);
    }

    public void 置邮箱(String $邮箱) {
        setEmail($邮箱);
    }

    public String 取邮箱() {
        return getEmail();
    }

    public void 置签名(String $签名) {
        设置("sign", $签名);
    }

    public String 取签名() {
        return 读取("sign");
    }

    public void 置头像(Bitmap $头像) {
        置文件("icon", 图片.转换($头像));
    }

    public void 置头像(String $头像) {
        置文件("icon", $头像);
    }

    public void 取头像(final 方法 $回调) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    调用.事件($回调, 取头像());
                    return null;
                }
            }).启动();
    }
    
    public void 显示头像(ImageView $图片视图) {
        显示头像($图片视图, null);
    }

    public void 显示头像(final ImageView $图片视图,final Object $默认) {
        new 线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    Bitmap $图片 = 取头像().取内容();
                    if ($图片 == null) {
                        $图片 = 取头像缓存();
                    }
                    final Bitmap $头像 = $图片;
                    处理.主线程(new 方法() {
                            @Override
                            public Object 调用(Object[] $参数) {
                                if ($头像 != null) {
                                    图片实现.置图片($图片视图, $头像);
                                } else if ($默认 != null) {
                                    图片实现.置图片($图片视图, $默认);
                                }
                                return null;
                            }
                        });
                    return null;
                }
            }).启动();
    }

    private static String 头像缓存 = "$头像缓存";

    public Bitmap 取头像缓存() {
        return 图片.读取(头像缓存 + "/" + getObjectId());
    }

    public 返回值<Bitmap> 取头像() {
        返回值<InputStream> $返回 = 取文件("icon");
        if ($返回.成功()) {
            byte[] $图片 = 字节.读取($返回.取内容());
            字节.保存(头像缓存 + "/" + getObjectId(), $图片);
            return 返回值.创建(图片.读取($图片));
        } else {
            return 返回值.创建(null, $返回.取错误());
        }
    }

    public 返回值<Void> 同步注册() {
        try {
            signUp();
        } catch (后端错误 $错误) {
            return 返回值.创建(null, $错误);
        }
        return 返回值.成功;
    }

    public void 注册(final 方法 $回调) {
        signUpInBackground(new SignUpCallback() {
                @Override
                public void done(后端错误 $错误) {
                    if ($错误 == null) {
                        置权限(new 权限(用户.this));
                        保存();
                    }
                    调用.事件($回调, 返回值.创建($错误));
                }
            });
    }

    public void 验证邮箱(String $邮箱) {
        requestEmailVerify($邮箱);
    }

    public void 验证邮箱(String $邮箱,final 方法 $回调) {
        requestEmailVerifyInBackground($邮箱, new RequestEmailVerifyCallback() {
                @Override
                public void done(后端错误 $错误) {
                    调用.事件($回调, 返回值.创建($错误));
                }
            });
    }

    public boolean 检查() {
        return isAuthenticated();
    }

    public void 检查(final 方法 $回调) {
        isAuthenticated(new AVCallback<Boolean>() {
                @Override
                protected void internalDone0(Boolean $返回,后端错误 avException) {
                    调用.事件($回调,返回值.创建(null,$返回 == null ? false : $返回,avException));
                }
            });
    }

    public static void 登出() {
        logOut();
    }

    public static 返回值<用户> 同步登录(String $账号,String $密码) {
        try {
            return 返回值.创建(logIn($账号, $密码, 用户.class));
        } catch (后端错误 $错误) {
            return 返回值.创建(null, $错误);
        }
    }

    public static 返回值<用户> 同步登录(String $Token) {
        try {
            返回值<用户> $返回 = 返回值.创建((用户)becomeWithSessionToken($Token, 用户.class));
            if ($返回.成功()) {
                设置.保存("用户Token", $返回.取内容().getSessionToken());
            }
            return $返回;
        } catch (后端错误 $错误) {
            return 返回值.创建(null, $错误);
        }
    }


    public static void 登录(String $Token,final 方法 $回调) {
        becomeWithSessionTokenInBackground($Token, new LogInCallback<用户>() {
                @Override
                public void done(用户 $用户,后端错误 $错误) {
                    调用.事件($回调, 返回值.创建($用户, $错误));
                }
            }, 用户.class);
    }

    public static void 登录(String $账号,String $密码,final 方法 $回调) {
        logInInBackground($账号, $密码, new LogInCallback<用户>() {
                @Override
                public void done(用户 $用户,后端错误 $错误) {
                    调用.事件($回调, 返回值.创建($用户, $错误));
                }
            }, 用户.class);
    }

    public static boolean 已登录() {
        return 取当前用户() != null;
    }

    public static 用户 取当前用户() {
        return getCurrentUser(用户.class);
    }


}
