package testviewtouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/3/26.
 */

public class ViewB extends View {
    public ViewB(Context context) {
        super(context);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewB  dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewB  onTouchEvent");
        return super.onTouchEvent(event);
    }
}
