
package me.imid.swipebacklayout.lib.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;

public class SwipeBackActivity extends Activity implements 基本滑动返回界面 {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout 取滑动返回布局() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void 置滑动返回(boolean enable) {
        取滑动返回布局().setEnableGesture(enable);
    }

    @Override
    public void 滑动结束界面() {
        Utils.convertActivityToTranslucent(this);
        取滑动返回布局().scrollToFinishActivity();
    }
}
