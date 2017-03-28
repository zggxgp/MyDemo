package com.example.huangzhao.testwegiht;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

/**
 * Created by huangzhao on 2017/3/22.
 */

public class HideTitleLayout extends LinearLayout {

    private boolean allowScroll = true;//是否允许滑动
    private final int mTouchSlop;//滑动阈值，防止过于灵敏

    private float hideDistance;//要隐藏的距离

    private float initialX;//初始X
    private float initialY;//初始Y
    private float lastX;
    private float lastY;

    private Context mContext;


    public HideTitleLayout(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mContext = context;
    }

    public HideTitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mContext = context;
    }

    public HideTitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mContext = context;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        hideDistance = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50,
                mContext.getApplicationContext().getResources().getDisplayMetrics());
        float nowTranslateY = getTranslateY();
        Log.d("translate Y ", nowTranslateY+"");
        if (allowScroll) {
            switch (ev.getAction()){
                case MotionEvent.ACTION_DOWN:
                    Log.d("typehz", "down");
                    initialX = lastX = ev.getX();
                    initialY = lastY = ev.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d("typehz", "up");
                    lastX = ev.getX();
                    lastY = ev.getY();

                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("typehz", "move");

                    float nowX = ev.getX();
                    float nowY = ev.getY();
                    float offsetX = Math.abs(nowX-initialX);
                    float offsetY = Math.abs(nowY-initialY);
                    if(offsetX>mTouchSlop || offsetY>mTouchSlop){//防止滑动过于灵敏
                        float scrollOffset = nowY-lastY;
                        if(offsetY>offsetX){//竖滑状态
                            if(scrollOffset>0){//下拉
                                if(nowTranslateY+scrollOffset>=0){
                                    doTranslateY(0);
                                }else{
                                    doTranslateY(nowTranslateY+scrollOffset);
                                }
                            }else{//上拉
                                if(nowTranslateY>-hideDistance){
                                    if(nowTranslateY+scrollOffset<=-hideDistance){
                                        doTranslateY(-hideDistance);
                                    }else{
                                        doTranslateY(nowTranslateY+scrollOffset);
                                    }
                                }

                            }
                        }
                    }
                    lastY = nowY;
                    break;
            }

        }
        return super.dispatchTouchEvent(ev);
    }


    private void doTranslateY(float offsetY){
        for(int i=0;i<getChildCount();i++){
            View view = getChildAt(i);
            view.setTranslationY(offsetY);
        }
    }

    private float getTranslateY(){
        for(int i=0;i<getChildCount();i++){
            View view = getChildAt(i);
            return  view.getTranslationY();
        }
        return 0;
    }


}
