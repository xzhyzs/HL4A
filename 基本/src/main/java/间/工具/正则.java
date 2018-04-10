package 间.工具;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class 正则 {
    
    private Pattern 表达式;
    
    public 正则(String $内容) {
        表达式 = Pattern.compile($内容);
    }
    
    public 结果[] 匹配(String $文本) {
        Matcher $结果 = 表达式.matcher($文本);
        结果[] $返回 = new 结果[$结果.groupCount()];
        for (int $键值 = 0;$键值 < $结果.groupCount();$键值 ++) {
            $返回[$键值] = new 结果($结果.group($键值),$结果.start($键值),$结果.end($键值));
        }
        return $返回;
    }
    
    public class 结果 {
       
        public final String 内容;
        public final int 开始;
        public final int 结束;
        
        public 结果(String $内容,int $开始,int $结束) {
            内容 = $内容;
            开始 = $开始;
            结束 = $结束;
        }
        
    }
    
}
