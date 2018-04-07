package 间.安卓.工具;

import com.taobao.android.dexposed.DeviceCheck;
import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.XC_MethodReplacement;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import 间.工具.反射;
import 间.工具.数组;
import 间.工具.错误;
import 间.接口.方法;
import 间.接口.调用;
import 间.接口.返回值;

public class 拦截 {
    
    public static boolean 可用() {
        return DeviceCheck.isDeviceSupport(环境.取应用());
    }
    
    public static void 钩子所有构造器(Class<?> $类,方法 $调用后) {
        DexposedBridge.hookAllConstructors($类, new 方法钩子(null,$调用后));
    }
    
    public static void 调用超类方法(Object $对象,Member $方法,Object... $参数) {
        try {
            DexposedBridge.invokeSuper($对象, $方法, $参数);
        } catch (NoSuchFieldException $错误) {
            错误.抛出($错误);
        }
    }
    

    public static void 调用超类方法(Object $对象,String $名称,Object... $参数) {
        try {
            Object[] $返回 = 反射.取方法对象($对象,$名称,$参数);
            DexposedBridge.invokeSuper($对象, (Method)$返回[0], $返回[1]);
        } catch (NoSuchFieldException $错误) {
            错误.抛出($错误);
        }
    }

    public static void 替换所有构造器(Class<?> $类,方法 $替换) {
        DexposedBridge.hookAllConstructors($类,new 方法替换($替换));
    }
    
    public static void 钩子所有方法(Class<?> $类,String $方法,方法 $调用后) {
        DexposedBridge.hookAllMethods($类, $方法,new 方法钩子(null,$调用后));
    }

    public static void 钩子所有方法(Class<?> $类,String $方法,方法 $调用前,方法 $调用后) {
        DexposedBridge.hookAllMethods($类, $方法,new 方法钩子($调用前,$调用后));
    }

    public static void 替换所有方法(Class<?> $类,String $方法,方法 $替换) {
        DexposedBridge.hookAllMethods($类, $方法,new 方法替换($替换));
    }
    
    public static void 钩子方法(Class<?> $类,String $方法,方法 $调用后,Class... $参数类型) {
        Object[] $数组 = 数组.转换(Object.class,$参数类型);
        DexposedBridge.findAndHookMethod($类, $方法,数组.添加($数组,new 方法钩子(null,$调用后)));
    }

    public static void 钩子方法(Class<?> $类,String $方法,方法 $调用前,方法 $调用后,Class... $参数类型) {
        Object[] $数组 = 数组.转换(Object.class,$参数类型);
        DexposedBridge.findAndHookMethod($类, $方法,数组.添加($数组,new 方法钩子($调用前,$调用后)));
    }

    public static void 替换方法(Class<?> $类,String $方法,方法 $替换,Class... $参数类型) {
        Object[] $数组 = 数组.转换(Object.class,$参数类型);
        DexposedBridge.findAndHookMethod($类, $方法,数组.添加($数组,new 方法替换($替换)));
    }
    
    public static void 反注册所有() {
        DexposedBridge.unhookAllMethods();
    }
    
    public static class 参数 {
        
        private XC_MethodHook.MethodHookParam 参数;
        
        public 参数(XC_MethodHook.MethodHookParam $参数) {
            参数 = $参数;
        }
        
        public <类型> 类型 取当前对象() {
            return (类型)参数.thisObject;
        }
        
        public Member 取当前方法() {
            return 参数.method;
        }
        
        public Object[] 取传入参数() {
            return 参数.args;
        }
        
        public <类型> 类型 取传入参数(int $键值) {
            if (参数.args.length > ($键值 + 1) || $键值 < 0) {
                return null;
            } else {
                return (类型)参数.args[$键值];
            }
        }
        
        public void 置返回值(Object $对象) {
            参数.setResult($对象);
        }
        
        public <类型> 类型 取返回值() {
            return (类型)参数.getResult();
        }
        
        public 返回值<?> 取返回值或错误() {
            try {
                return 返回值.创建(参数.getResultOrThrowable());
            } catch (Throwable $错误) {
                返回值.创建(null,$错误);
            }
            return null;
        }
        
        public Throwable 取错误() {
            return 参数.getThrowable();
        }
        
        public boolean 有错误() {
            return 参数.hasThrowable();
        }
        
        
    }

    public static class 方法钩子 extends XC_MethodHook {

        public 方法 调用前;
        public 方法 调用后;

        public 方法钩子(方法 $调用前,方法 $调用后) {
            调用前 = $调用前;
            调用后 = $调用后;
        }

        @Override
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam $参数) throws Throwable {
            super.beforeHookedMethod($参数);
            调用.事件(调用前,new 参数($参数));
        }

        @Override
        protected void afterHookedMethod(XC_MethodHook.MethodHookParam $参数) throws Throwable {
            super.afterHookedMethod($参数);
            调用.事件(调用后,new 参数($参数));
        }

    }

    public static class 方法替换 extends XC_MethodReplacement {

        public 方法 替换;

        public 方法替换(方法 $替换) {
            替换 = $替换;
        }

        @Override
        protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam $参数) throws Throwable {
            return 调用.事件(替换,new 参数($参数));
        }

    }
    
}
