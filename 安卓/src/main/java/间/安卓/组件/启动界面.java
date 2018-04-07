package 间.安卓.组件;

import android.os.Bundle;
import 间.安卓.资源.布局.布局_初始化;
import 间.安卓.工具.线程;
import 间.安卓.工具.设置;
import 间.安卓.工具.文件;
import 间.安卓.工具.应用;
import 间.工具.ZIP;
import 间.安卓.工具.处理;
import 间.安卓.工具.提示;
import 间.安卓.工具.服务;
import hl4a.runtime.ContentManagerService;

public class 启动界面 extends 基本界面 {

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_初始化(this));
        服务.启动(this,ContentManagerService.class);
        new 线程(this, "释放文件").启动();
    }

    public void 释放文件() {
        if (应用.是更新()) {
            文件.删除("#");
            ZIP.解压(应用.取信息().地址, "#");
        }
        while(!服务.已启动(ContentManagerService.class.getName())) {
            线程.暂停(20);
        }
        处理.主线程调用(this, "初始化完成事件");
    }

    public void 初始化完成事件() {}

}
