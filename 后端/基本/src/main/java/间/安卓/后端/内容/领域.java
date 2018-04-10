package 间.安卓.后端.内容;

import 间.安卓.后端.数据;

public class 领域 extends 数据 {

    public 领域() {
        super("Domain");
    }

    public String 取领域名() {
        return 读取("name");
    }

    public void 置领域名(String $名称) {
        设置("name", $名称);
    }
    
    public String 取简介() {
        return 读取("sign");
    }
    
    public void 置简介(String $简介) {
        设置("sign",$简介);
    }

}

