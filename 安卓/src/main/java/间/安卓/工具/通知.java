package 间.安卓.工具;

import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationBuilderWithActions;
import android.app.Notification;
import android.widget.RemoteViews.RemoteView;
import android.widget.RemoteViews;
import android.view.View;
import android.view.ViewGroup;
import 间.安卓.视图.实现.布局实现;
import 间.工具.时间;

public class 通知  {
    
    private static NotificationManager 管理 = (NotificationManager)环境.取应用().getSystemService(Context.NOTIFICATION_SERVICE);
    private Notification 通知;
    
    public 通知() {
        通知 = new Notification();
    }
    
    public void 置内容(View $视图) {
        通知.contentView = new 远程视图($视图);
    }
    
    private int 哈希码 = hashCode();
    
    public void 发送() {
        管理.notify(哈希码,通知);
    }
    
    public void 取消() {
        管理.cancel(哈希码);
    }
    
    public class 远程视图 extends RemoteViews {
        
        private View 视图;
        
        public 远程视图(View $视图) {
            super(应用.取信息().包名,android.R.layout.activity_list_item);
            视图 = $视图;
        }

        @Override
        public View apply(Context $上下文,ViewGroup $父视图) {
            布局实现.加入子视图($父视图,视图);
            return 视图;
        }
        
    }
    
}
