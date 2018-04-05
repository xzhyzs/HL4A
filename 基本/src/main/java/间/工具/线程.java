package 间.工具;

import 间.接口.*;
import java.io.IOException;

public class 线程 extends Thread {
    
    private Object[] 参数;
    private 方法 方法;
    private 方法 回调;
    private UncaughtExceptionHandler 处理;
    
    public 线程(方法 $方法) {
        方法 = $方法;
        处理 = 线程.取错误处理对象();
    }
    
    public 线程(Object $对象,String $方法名) {
        this(调用.代理($对象,$方法名));
    }
    
    public 线程 置回调(方法 $回调) {
        回调 = $回调;
        return this;
    }

    @Override
    public void run() {
       线程.置错误处理对象(处理);
       调用.事件(回调,调用.事件(方法,参数));
    }

    public void 启动(Object... $参数) {
        参数 = $参数;
        start();
    }
    
    public void 暂停() {
        suspend();
    }

    public void 重启() {
        resume();
    }

    public static void 暂停(long $长度) {
        try {
            Thread.sleep($长度);
        } catch (InterruptedException $错误) {}
    }

    public static Thread 取当前线程() {
        return Thread.currentThread();
    }
    
    public static StackTraceElement[] 取调用栈() {
        return 取调用栈(1);
    }
    
    public static StackTraceElement[] 取调用栈(int $结束) {
        return 取调用栈(取当前线程(),$结束 + 1);
    }
    
    public static StackTraceElement[] 取调用栈(Thread $线程,int $结束) {
        $结束 ++;
        StackTraceElement[] $调用栈 =  $线程.getStackTrace();
        return 数组.截取($调用栈,null,$调用栈.length - 1 - $结束);
    }

    public static boolean 是线程() {
        return 取当前线程() instanceof 线程;
    }

    public static void 置错误处理(方法 $处理) {
        置错误处理对象(new 错误处理($处理));
    }

    public static void 置错误处理对象(UncaughtExceptionHandler $处理) {
        Thread.setDefaultUncaughtExceptionHandler($处理);
    }
    
    public static UncaughtExceptionHandler 取错误处理对象() {
        return Thread.getDefaultUncaughtExceptionHandler();
    }
    

    public 方法 启动 = new 方法() {
        @Override
        public Object 调用(Object[] $参数) {
            启动($参数);
            return null;
        }
    };

}
