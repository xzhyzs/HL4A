package 间.安卓.视图;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import 间.安卓.工具.字体;
import 间.安卓.工具.绘画;
import 间.安卓.工具.视图;
import 间.工具.字符;
import 间.接口.方法;
import 间.接口.调用;

public class 文本视图<V extends TextView> extends 基本视图<V> {

    public 文本视图(Context $上下文) {
        super($上下文);
    }
    
    public 文本视图(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    @Override
    public View 创建(Context $上下文) {
        return new TextView($上下文);
    }
    
    /*
    
    public void 插入图片(final String $文本, final Bitmap $图片) {
        取视图().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {

                }

                @Override
                public void onTextChanged(CharSequence $内容, int p2, int p3, int p4) {
                    if (字符.是否出现($内容.toString(),$文本)) {
                        ImageSpan $替换 = new ImageSpan(取视图().getContext(), $图片);
                        SpannableString $字符 = new SpannableString($文本);
                        $字符.setSpan($替换, 0, $文本.length(), ImageSpan.ALIGN_BASELINE);
                        取视图().append($字符);

                    } else {
                        取视图().setText($内容);
                    }
                }

                @Override
                public void afterTextChanged(Editable $编辑) {

                }
            });
    }
    
    */

    public void 置文本(final String $内容) {
        取视图().setText($内容);
    }

    public void 置HTML文本(String $HTML) {
        取视图().setMovementMethod(ScrollingMovementMethod.getInstance());
        取视图().setText(Html.fromHtml($HTML, new Html.ImageGetter() {
                              @Override
                              public Drawable getDrawable(String $地址) {
                                  Drawable $绘画 = 绘画.图片转绘画($地址);
                                  $绘画.setBounds(0, 0, $绘画.getIntrinsicWidth(), $绘画.getIntrinsicHeight());
                                  return $绘画;
                              }
                          }, null));
    }

    public String 取文本() {
        return 取视图().getText().toString();
    }

    public void 置文本大小(Object $大小) {
        取视图().setTextSize(视图.检查大小($大小));
    }

    public void 置文本颜色(Object $颜色) {
        if ($颜色 instanceof Integer)
            取视图().setTextColor((Integer)$颜色);
        else if ($颜色 instanceof String)
            取视图().setTextColor(视图.检查颜色($颜色));
    }

    public void 置文本字体(String $地址) {
        置文本字体(字体.读取($地址));
    }

    public void 置文本字体(Typeface $字体) {
        取视图().setTypeface($字体);
    }

    public void 置文本重力(String $重力) {
        取视图().setGravity(视图.检查重力($重力));
    }

    public void 置文本显示在同一行() {
        取视图().setSingleLine();
    }

    public void 置文本显示在同一行(Boolean $是否) {
        取视图().setSingleLine($是否 == true);
    }

    public void 置行数(int $行数) {
        取视图().setLines($行数);
    }

    public void 置最小行数(int $行数) {
        取视图().setMinLines($行数);
    }

    public void 置最大行数(int $行数) {
        取视图().setMaxLines($行数);
    }

    public void 置链接可点击() {
        置链接可点击(true);
    }

    public void 置链接可点击(Boolean $是否) {
        取视图().setLinksClickable($是否 == true);
    }

    public void 置链接颜色(Object $颜色) {
        取视图().setLinkTextColor($颜色);
    }

    public void 置文本改变事件(方法 $改变) {
        取视图().addTextChangedListener(new 文本改变($改变));
    }

    public void 置文本改变事件(方法 $改变前, 方法 $已改变, 方法 $改变后) {
        取视图().addTextChangedListener(new 文本改变($改变前, $已改变, $改变后));
    }
    
    public static class 文本改变 implements TextWatcher {

        public 方法 改变前 = null;
        public 方法 已改变 = null;
        public 方法 改变后 = null;

        public 文本改变(方法 $事件) {
            已改变 = $事件;
        }

        public 文本改变(方法 $改变前,方法 $已改变,方法 $改变后) {
            改变前 = $改变前;
            已改变 = $已改变;
            改变后 = $改变后;
        }

        @Override
        public void beforeTextChanged(CharSequence p1,int p2,int p3,int p4) {
            调用.事件(改变前, p1, p2, p3, p4);
        }

        @Override
        public void onTextChanged(CharSequence p1,int p2,int p3,int p4) {
            调用.事件(已改变,p1, p2, p3, p4);
        }

        @Override
        public void afterTextChanged(Editable p1) {
            调用.事件(改变后,p1);
        }

    }
    

}
