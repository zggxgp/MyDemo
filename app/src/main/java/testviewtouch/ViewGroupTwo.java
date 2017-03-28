package testviewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/3/26.
 */

public class ViewGroupTwo extends RelativeLayout {
    public ViewGroupTwo(Context context) {
        super(context);
    }

    public ViewGroupTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed,l,t,r,b);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("TestEvent", "ViewGroupTwo onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("TestEvent", "ViewGroupTwo dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewGroupTwo onTouchEvent");
        return super.onTouchEvent(event);
    }
}
