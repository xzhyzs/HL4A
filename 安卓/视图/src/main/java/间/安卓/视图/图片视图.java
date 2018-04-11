package 间.安卓.视图;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;
import 间.安卓.工具.文件;
import 间.安卓.工具.视图;
import 间.安卓.视图.实现.基本布局;
import 间.安卓.视图.实现.基本视图;
import android.view.View;

public  class 图片视图<V extends ImageView> extends 基本视图<V>  {

    public 图片视图(Context $上下文) {
        super($上下文);
    }

    public 图片视图(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }

    @Override
    public View 创建(Context $上下文) {
        return new ImageView($上下文);
    }

    public void 置图片(Object $图片) {
        Bitmap $对象 = 视图.检查图片($图片);
        if ($对象 != null) {
            取视图().setImageBitmap($对象);
        } else if ($图片 instanceof String && 文件.是网络文件((String)$图片)) {
            取视图().setImageURI(Uri.parse((String)$图片));
        } else if ($图片 instanceof Integer) {
            取视图().setImageResource((Integer)$图片);
        }

    }

    public Bitmap 取图片() {
        return ((BitmapDrawable)取视图().getBackground()).getBitmap();
    }

}
