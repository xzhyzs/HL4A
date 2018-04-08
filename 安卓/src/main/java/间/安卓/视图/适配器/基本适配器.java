package 间.安卓.视图.适配器;

import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import 间.收集.*;
import android.view.ViewGroup.MarginLayoutParams;
import 间.工具.错误;

public abstract class 基本适配器<视图 extends View> extends BaseAdapter {

    private 有序列表<对象哈希表> 数据;

    public 基本适配器() {
        数据 = new 有序列表<>();
    }

    @Override
    public int getCount() {
        return 数据.数量();
    }
    
    public int 数量() {
        return getCount();
    }

    @Override
    public Object getItem(int $键值) {
        return $键值;
    }

    @Override
    public long getItemId(int $键值) {
        return $键值;
    }

    @Override
    public 视图 getView(int $键值,视图 $视图,ViewGroup $视图组) {
        if ($视图 == null) {
            $视图 = 创建();
        }
        $视图 = 处理($视图, 数据.读取($键值));
        if ($视图 != null) {
            ViewGroup.LayoutParams $设置 = $视图.getLayoutParams();
            if ($设置 != null) {
                AbsListView.LayoutParams $列表设置 = new AbsListView.LayoutParams($设置);
                $视图.setLayoutParams($列表设置);
            }
            $视图.setTag(数据.读取($键值));
        }
        return $视图;
    }

    public void 清空() {
        数据 = new 有序列表<>();
    }

    public void 发送更新事件() {
        notifyDataSetChanged();
    }

    public void 发送重绘事件() {
        notifyDataSetInvalidated();
    }

    public void 添加(对象哈希表 $参数) {
        数据.添加($参数);
    }

    public void 添加(对象哈希表[] $参数) {
        数据.添加所有($参数);
    }

    public abstract 视图 创建();

    public abstract 视图 处理(视图 $视图,对象哈希表 $参数);



}
