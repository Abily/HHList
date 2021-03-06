package com.example.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 
 * @Description 一个视图容器控件
 *              阻止 拦截 ontouch事件传递给其子控件
 * @author lsx
 */
public class InterceptScrollContainer extends LinearLayout {

	public InterceptScrollContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InterceptScrollContainer(Context context) {
		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i("pdwy","ScrollContainer onInterceptTouchEvent");
		return true;
	}
	
}
