package 间.安卓.视图.实现;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import 间.安卓.工具.处理;
import 间.安卓.工具.布局;
import 间.安卓.工具.绘画;
import 间.安卓.工具.视图;
import 间.工具.反射;
import 间.接口.方法;
import 间.安卓.工具.设备;
import android.view.View.OnClickListener;
import 间.接口.调用;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.content.Context;

public abstract class 基本视图 <V extends View> {

    public 基本视图(Context $上下文) {
        此 = (V)创建($上下文);
        取视图().setTag(0,this);
    }
    
    public 基本视图(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    public abstract View 创建(Context $上下文);
    private V 此;

    public V 取视图() {
        return 此;
    }
    
    public Context 取上下文() {
        return 取视图().getContext();
    }

    public void 置阴影(Object $阴影) {
        if (设备.取SDK() > 21)
            取视图().setTranslationZ(视图.检查大小($阴影));
    }

    public void 置布局重力(String $重力) {
        ViewGroup.LayoutParams $设置 = 取设置();
        反射.置变量($设置, "gravity", 视图.检查重力($重力));
        置设置($设置);
    }

    public void 置布局权重(float $权重) {
        ViewGroup.LayoutParams $设置 = 取设置();
        反射.置变量($设置, "weight", $权重);
        置设置($设置);
    }

    // AddView

    public void 加入到(基本布局 $布局) {
        $布局.加入子视图(this);
    }

    //setContentView

    public void 打开(Activity $界面) {
        布局.打开($界面, 取视图());
    }

    // Tag

    public void 置标签(Object $标签) {
        取视图().setTag($标签);
    }

    public Object 取标签() {
        return 取视图().getTag();
    }

    // Width/Height
    public void 置单击事件(final 方法 $事件) {
        取视图().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View $视图) {
                    调用.事件($事件, $视图);
                }
            });
    }

    public void 置长按事件(final 方法 $事件) {
        取视图().setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View $视图) {
                    return new Boolean(true).equals(调用.事件($事件, $视图)) ? true : false;
                }
            });
    }

    public void 置触摸事件(final 方法 $事件) {
        取视图().setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View $视图, MotionEvent $移动) {
                    return new Boolean(true).equals(调用.事件($事件, $视图, $移动)) ? true : false;

                }
            });
    }


    public void 置宽度(final Object $宽度) {
        处理.主线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    置宽度实现($宽度);
                    return null;
                }
            });
    }

    public void 置高度(final Object $高度) {
        处理.主线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    置高度实现($高度);
                    return null;
                }
            });
    }


    public void 置宽度实现(Object $宽度) {
        ViewGroup.LayoutParams $设置 = 取设置();
        $设置.width = 视图.检查大小($宽度).intValue();
        置设置($设置);
    }

    public void 置高度实现(Object $高度) {
        ViewGroup.LayoutParams $设置 = 取设置();
        $设置.height = 视图.检查大小($高度).intValue();
        置设置($设置);
    }
    public void 置边距(Object $全局) {
        置边距($全局, $全局, $全局, $全局);
    }

    public void 置上边距(Object $边距) {
        置边距($边距, null, null, null);
    }

    public void 置下边距(Object $边距) {
        置边距(null, $边距, null, null);
    }

    public void 置左边距(Object $边距) {
        置边距(null, null, $边距, null);
    }

    public void 置右边距(Object $边距) {
        置边距(null, null, null, $边距);
    }

    public void 置上下边距(Object $边距) {
        置边距($边距, $边距, null, null);
    }

    public void 置左右边距(Object $边距) {
        置边距(null, null, $边距, $边距);
    }

    public void 置边距实现(Object $上, Object $下, Object $左, Object $右) {
        ViewGroup.MarginLayoutParams $设置 = 取边距设置();
        int $上边距 = $设置.topMargin;
        int $下边距 = $设置.bottomMargin;
        int $左边距 = $设置.leftMargin;
        int $右边距 = $设置.rightMargin;
        $上边距 = (($上 = 视图.检查大小($上)) == null) ? $上边距 : (int) $上;
        $下边距 = (($下 = 视图.检查大小($下)) == null) ? $下边距 : (int) $下;
        $左边距 = (($左 = 视图.检查大小($左)) == null) ? $左边距 : (int) $左;
        $右边距 = (($右 = 视图.检查大小($左)) == null) ? $右边距 : (int) $右;
        $设置.setMargins($左边距, $上边距, $右边距, $下边距);
        置设置($设置);
    }

    public void 置边距(final Object $上, final Object $下, final Object $左, final Object $右) {
        处理.主线程(new 方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    置边距实现($上, $下, $左, $右);
                    return null;
                }
            });
    }

    // Visible

    public void 置状态(String $状态) {
        int $状态i = 0;
        switch ($状态) {
            case "占位":case "invisible":case "4":
                $状态i = 4;break;
            case "隐藏":case "gone":case "8":
                $状态i = 8;break;
        }
        取视图().setVisibility($状态i);
    }

    public void 显示() {
        置状态("显示");
    }

    public void 占位() {
        置状态("占位");
    }

    public void 隐藏() {
        置状态("隐藏");
    }

    public String 取状态() {
        int $状态 = 取视图().getVisibility();
        switch ($状态) {
            case 0:return "显示";
            case 4:return "占位";
            case 8:return "隐藏";
        }
        return "未知";
    }

    // Background

    public void 置背景(Object $背景) {
        if ($背景 instanceof Drawable)
            取视图().setBackground((Drawable)$背景);
        else if ($背景 instanceof Integer)
            置背景颜色((Integer)$背景);
        else if ($背景 instanceof String)
            switch ((String)$背景) {
                case "透明":case "through":置背景(绘画.透明());break;
                case "白色":case "white":置背景(绘画.白色());break;
                case "黑色":case "black":置背景(绘画.黑色());break;
                case "主题":置背景(绘画.主题());break;
                default:置背景颜色((String)$背景);
            }
    }


    // BackgroundColor

    public void 置背景颜色(Object $颜色) {
        if (取视图() instanceof CompoundButton) {
            Drawable $背景 = ((CompoundButton)取视图()).getButtonDrawable();
            if ($背景 != null) {
                视图.绘画着色($背景);
                return;
            }
        } else if (取视图() instanceof Button) {
            视图.绘画着色(取视图().getBackground());
            return;
        }
        取视图().setBackgroundColor(视图.检查颜色($颜色));
    }

    public void 置填充(Object $全局) {
        置填充($全局, $全局, $全局, $全局);
    }

    public void 置上填充(Object $填充) {
        置填充($填充, null, null, null);
    }

    public void 置下填充(Object $填充) {
        置填充(null, $填充, null, null);
    }

    public void 置左填充(Object $填充) {
        置填充(null, null, $填充, null);
    }

    public void 置右填充(Object $填充) {
        置填充(null, null, null, $填充);
    }

    public void 置上下填充(Object $填充) {
        置填充($填充, $填充, null, null);
    }

    public void 置左右填充(Object $填充) {
        置填充(null, null, $填充, $填充);
    }


    public void 置填充(Object $上, Object $下, Object $左, Object $右) {

        Integer $上填充 = (($上 = 视图.检查大小($上)) == null) ? 取视图().getPaddingTop() : (Integer) $上;
        Integer $下填充 = (($下 = 视图.检查大小($下)) == null) ? 取视图().getPaddingBottom() : (Integer) $下;
        Integer $左填充 = (($左 = 视图.检查大小($左)) == null) ? 取视图().getPaddingLeft() : (Integer) $左;
        Integer $右填充 = (($右 = 视图.检查大小($右)) == null) ? 取视图().getPaddingRight() : (Integer) $右;
        取视图().setPadding($左填充, $上填充, $右填充, $下填充);

    }

    public void 初始化控件() {
        if (取视图().getLayoutParams() == null)
            取视图().setLayoutParams(new LayoutParams(-2, -2));
    }

    public MarginLayoutParams 取边距设置() {
        LayoutParams $设置 = 取设置();
        if ($设置 instanceof MarginLayoutParams) {
            return (MarginLayoutParams)$设置;
        } else {
            return new MarginLayoutParams($设置);
        }
    }

    public LayoutParams 取设置() {
        return 取视图().getLayoutParams();
    }

    public void 置设置(LayoutParams $设置) {
        if ($设置 != null) {
            取视图().setLayoutParams($设置);
            取视图().requestLayout();
        }
    }

}
