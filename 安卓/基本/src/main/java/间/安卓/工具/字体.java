package 间.安卓.工具;

import android.graphics.Typeface;
import 间.工具.*;

public class 字体 {
    
    public static final 字体 普通字体 = new 字体("noraml");
    public static final 字体 无衬线体 = new 字体("sans");
    public static final 字体 有衬线体 = new 字体("serif");
    public static final 字体 等宽字体 = new 字体("monospace");
    
    public final Typeface 普通;
    public final Typeface 加粗; 
    public final Typeface 加粗斜体;
    public final Typeface 斜体;
    
    public 字体(String $名称) {
        普通 = Typeface.create($名称,Typeface.NORMAL);
        加粗 = Typeface.create($名称,Typeface.BOLD);
        加粗斜体 = Typeface.create($名称,Typeface.BOLD_ITALIC);
        斜体 = Typeface.create($名称,Typeface.ITALIC);
    }
    
    public static Typeface 读取(String $文件) {
        return Typeface.createFromFile(文件.取文件对象($文件));
    }

}
