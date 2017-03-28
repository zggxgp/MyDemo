package testviewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/3/26.
 */

public class ViewGroupOne extends RelativeLayout {
    public ViewGroupOne(Context context) {
        super(context);
    }

    public ViewGroupOne(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed,l,t,r,b);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("TestEvent", "ViewGroupOne  onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("TestEvent", "ViewGroupOne  dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewGroupOne  onTouchEvent");
        return super.onTouchEvent(event);
    }
}
