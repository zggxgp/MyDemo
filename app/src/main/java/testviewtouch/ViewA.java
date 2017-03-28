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

public class ViewA extends View {
    public ViewA(Context context) {
        super(context);
    }

    public ViewA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewA  dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TestEvent", "ViewA  onTouchEvent");
        return super.onTouchEvent(event);
    }
}
