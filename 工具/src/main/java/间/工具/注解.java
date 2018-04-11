package 间.工具;

import 间.接口.方法;
import java.lang.annotation.AnnotationFormatError;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import 间.收集.列表;
import 间.注解.配置;
import 间.注解.代理;

public class 注解 {

    public static 方法 代理(final Object $实例, String $名称) {
        if ($实例 == null) return null;
        final 信息[] $方法 = 取注解($实例 instanceof Class ? (Class)$实例 : $实例.getClass(), 代理.class , $名称);
        if ($方法.length == 0) {
            错误.内容("没有那样的代理注解: " + $名称 + " 在类: " + $实例.getClass().getSimpleName() + " 的实例");
        } else if ($方法.length > 1) {
            错误.内容("有" + $方法.length + "个这样的注解重复: " + $名称 + " 在类: " + $实例.getClass().getSimpleName() + " 的实例");
        }
        return new 方法() {
            @Override
            public Object 调用(Object[] $参数) {
                try {
                    return $方法[0].方法.invoke($实例, $参数);
                } catch (Exception $错误) {
                    错误.抛出($错误);
                }
                return null;
            }
        };


    }
    
    public static 方法 配置(final Object $实例, String $名称, final Object... $传入参数) {
        if ($实例 == null) return null;
        final 信息[] $方法 = 取注解($实例 instanceof Class ? (Class)$实例 : $实例.getClass(), 配置.class , $名称);
        if ($方法.length == 0) {
            错误.内容("没有那样的配置注解: " + $名称 + " 在类: " + $实例.getClass().getSimpleName() + " 的实例");
        } else if ($方法.length > 1) {
            错误.内容("有" + $方法.length + "个这样的注解重复: " + $名称 + " 在类: " + $实例.getClass().getSimpleName() + " 的实例");
        }
        return new 方法() {
            @Override
            public Object 调用(Object[] $参数) {
                try {
                    return $方法[0].方法.invoke($实例, $传入参数);
                } catch (Exception $错误) {
                    错误.抛出($错误);
                }
                return null;
            }
        };


    }


    public static <注解 extends Annotation> 信息<注解>[] 取注解(Class<?> $类, Class<注解> $注解类, Object $默认值) {
        信息[] $信息 = 取注解($类, $注解类);
        列表<信息> $返回 = new 列表<>();
        for (信息 $单个 : $信息) {
            if ($默认值.equals(反射.调用($单个.注解, "value"))) {
                $返回.添加($单个);
            }
        }
        return $返回.到数组(信息.class);
    }

    public static <注解 extends Annotation> 信息<注解>[] 取注解(Class<?> $类, Class<注解> $注解类) {
        Method[] $所有 = $类.getDeclaredMethods();
        列表<信息> $方法 = new 列表<>();
        for (Method $单个: $所有) {
            for (Annotation $注解 : $单个.getDeclaredAnnotations()) {
                Class<?> $类型 = $注解.annotationType();
                if ($类型.equals($注解类)) {
                    $方法.添加(new 信息<注解>((注解)$注解, $单个));
                }
            }
        }
        return $方法.到数组(信息.class);
    }

    public static class 信息 <类型 extends Annotation> {

        public final 类型 注解;
        public final Method 方法;

        public 信息(类型 $注解, Method $方法) {
            注解 = $注解;
            方法 = $方法;
        }

    }

}
