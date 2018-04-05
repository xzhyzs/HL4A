package me.imid.swipebacklayout.lib.app;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
/**
 * @author Yrom
 */
public interface 基本滑动返回界面 {
    /**
     * @return the SwipeBackLayout associated with this activity.
     */
    public abstract SwipeBackLayout 取滑动返回布局();

    public abstract void 置滑动返回(boolean enable);

    /**
     * Scroll out contentView and finish the activity
     */
    public abstract void 滑动结束界面();

}
