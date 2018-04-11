package 间.安卓.视图.实现;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import 间.接口.方法;
import 间.接口.调用;

public abstract class 基本列表视图<V extends AdapterView> extends 基本视图<V> {
    
    public 基本列表视图(Context $上下文) {
        super($上下文);
    }

    public 基本列表视图(基本布局 $布局) {
        this($布局.取上下文());
        加入到($布局);
    }
    
    
    public void 置适配器(BaseAdapter $适配器) {
        取视图().setAdapter($适配器);
    }

    public void 置项目选中事件(方法 $选中,方法 $取消) {
        取视图().setOnItemSelectedListener(new 项目选中($选中,$取消));
    }

    public void 置项目选中事件(方法 $方法) {
        置项目选中事件($方法,null);
    }

    public void 置项目单击事件(方法 $方法) {
        取视图().setOnItemClickListener(new 项目单击($方法));
    }

    public void 置项目长按事件(方法 $方法) {
        取视图().setOnItemLongClickListener(new 项目长按($方法));
    }
    
    public class 项目选中 implements OnItemSelectedListener {

        方法 选中;
        方法 取消;

        public 项目选中(方法 $选中,方法 $没选中) {
            选中 = $选中;
            取消 = $没选中;
        }


        @Override
        public void onItemSelected(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
            调用.事件(选中,$适配器视图,$视图,$键值,$ID);
        }

        @Override
        public void onNothingSelected(AdapterView<?> $适配器视图) {
            调用.事件(取消,$适配器视图);
        }

    }
    
    public class 项目单击 implements OnItemClickListener {

        方法 单击;

        public 项目单击(方法 $方法) {
            单击 = $方法;
        }

        @Override
        public void onItemClick(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
            调用.事件(单击,$适配器视图,$视图,$键值,$ID);
        }

    }
    
    public class 项目长按 implements OnItemLongClickListener {

        方法 长按;

        public 项目长按(方法 $方法) {
            长按 = $方法;
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
            Object $返回值 = 调用.事件(长按,$适配器视图,$视图,$键值,$ID);
            return true;
        }

    }
    
    
}
