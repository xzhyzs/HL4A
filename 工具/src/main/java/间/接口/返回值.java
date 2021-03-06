package 间.接口;

public class 返回值<内容> {
    
    public static 返回值<Void> 成功 = new 返回值<Void>().置状态(true);
    public static 返回值<Void> 失败 = new 返回值<Void>().置状态(false);
    
    public static <内容> 返回值<内容> 创建(内容 $内容,Throwable $错误) {
        return new 返回值<内容>().置错误($错误);
    }
    
    public static <内容> 返回值<内容> 创建(内容 $内容,boolean $状态) {
        return new 返回值<内容>().置状态($状态);
    }
    
    public static <内容> 返回值<内容> 创建(内容 $内容,boolean $状态,Throwable $错误) {
        return new 返回值<内容>().置状态($状态).置错误($错误);
    }
    
    public static <内容> 返回值<内容> 创建(内容 $内容) {
        return new 返回值<内容>().置内容($内容);
    }
    
    private 内容 内容;
    private Boolean 状态;
    private Throwable 错误;
    
    public 返回值<内容> 置内容(内容 $内容) {
        内容 = $内容;
        return this;
    }
    
    public 返回值<内容> 置状态(boolean $状态) {
        状态 = $状态;
        return this;
    }
    
    public 返回值<内容> 置错误(Throwable $错误) {
        错误 = $错误;
        return this;
    }
    
    public 返回值<内容> 置错误(String $错误) {
        错误 = new RuntimeException($错误);
        return this;
    }
    
    public 内容 取内容() {
        return 内容;
    }
    
    public <错误 extends Throwable> 错误 取错误() {
        return (错误)错误;
    }
    
    public String 取错误信息() {
        return 错误 == null ? "null" :错误.getMessage();
    }
    
    public boolean 成功() {
        return 状态 == null ? 错误 == null : 状态;
    }
    
}
