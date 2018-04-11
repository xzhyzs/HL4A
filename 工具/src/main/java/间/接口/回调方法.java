package 间.接口;

public abstract class 回调方法<类型> implements 方法 {

    public abstract void 回调(返回值<类型> $回调);
    
    @Override
    public Object 调用(Object[] $参数) {
        回调((返回值<类型>)$参数[0]);
        return null;
    }
    
}
