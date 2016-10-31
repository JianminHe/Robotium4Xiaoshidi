package com.qihoo.jia.test;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

import com.robotium.solo.Solo;

public class Unlock {
	
	private Solo solo;
	private ViewOperate viewOperate;
	private final Instrumentation inst;
	
	public Unlock(Solo solo, ViewOperate viewOperate, Instrumentation inst) {
		this.solo = solo;
		this.viewOperate = viewOperate;
		this.inst = inst;
	}
	
	public void touchLock(String viewID, int ... step ) {
		View v = viewOperate.getViewByID(viewID);
		touchLock(v, step);
		
	}
	
	//滑动解锁中对应的点位
	//****1****2****3****
	//****4****5****6****
	//****7****8****9****
	public void touchLock(View view, int ... step) {
		

		//判断一下， 滑动步数，至少要2步
		if(step.length <2) {
			return;
		}
		
		for(int i=0; i<step.length; i++) {
			//如果滑动步骤里出现不是对应9宫格的点位，直接退出
			if(step[i] < 1 || step[i] > 9) {
				return;
			}
			//把每个移动点位-1，对应X Y的数组；
			step[i] = step[i] -1;
		}

		int[] xyLocation = new int[2];
		view.getLocationOnScreen(xyLocation);
		
		int viewWidth = view.getWidth();
		int viewHeight = view.getHeight();
		
		float[] xPoint = new float[9];
		float[] yPoint = new float[9];
		
		//计算滑动解锁页面中，9个圈的中心位置。
		//****1****2****3****
		//****4****5****6****
		//****7****8****9****
		xPoint[0] = xyLocation[0] + (viewWidth / 6.0f);
		yPoint[0] = xyLocation[1] + (viewHeight / 6.0f);
		
		xPoint[1] = xyLocation[0] + (viewWidth / 2.0f);
		yPoint[1] = xyLocation[1] + (viewHeight / 6.0f);
		
		
		xPoint[2] = xyLocation[0] + (viewWidth * 5.0f / 6.0f);
		yPoint[2] = xyLocation[1] + (viewHeight / 6.0f);
		
		xPoint[3] = xyLocation[0] + (viewWidth / 6.0f);
		yPoint[3] = xyLocation[1] + (viewHeight / 2.0f);
		
		xPoint[4] = xyLocation[0] + (viewWidth / 2.0f);
		yPoint[4] = xyLocation[1] + (viewHeight/ 2.0f);
		
		xPoint[5] = xyLocation[0] + (viewWidth * 5.0f / 6.0f);
		yPoint[5] = xyLocation[1] + (viewHeight / 2.0f);
		
		xPoint[6] = xyLocation[0] + (viewWidth / 6.0f);
		yPoint[6] = xyLocation[1] + (viewHeight * 5.0f / 6.0f);
		
		xPoint[7] = xyLocation[0] + (viewWidth / 2.0f);
		yPoint[7] = xyLocation[1] + (viewHeight * 5.0f / 6.0f);
		
		xPoint[8] = xyLocation[0] + (viewWidth * 5.0f / 6.0f);
		yPoint[8] = xyLocation[1] + (viewHeight * 5.0f / 6.0f);
		
		//要是滑动距离小于2个点，直接退出
		if(step.length <2) {
			return;
		}
		
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis();
		
		float x =  xPoint[step[0]] ;
		float y =  yPoint[step[0]];
		 
		MotionEvent event = MotionEvent.obtain(downTime, eventTime,MotionEvent.ACTION_DOWN, x , y , 0);
		try {
			inst.sendPointerSync(event);
		} catch (SecurityException ignored) {}
		
		solo.sleep(200);
		for (int i = 0; i < step.length -1; ++i) {
			x =  xPoint[step[i+1]] ;
			y =  yPoint[step[i+1]];
			eventTime = SystemClock.uptimeMillis();
			event = MotionEvent.obtain(downTime, eventTime,MotionEvent.ACTION_MOVE, x, y, 0);
			try {
				inst.sendPointerSync(event);
			} catch (SecurityException ignored) {}
			
			solo.sleep(200);
		}
		x = xPoint[step[step.length-1]];
		y = yPoint[step[step.length-1]];
		event = MotionEvent.obtain(downTime, eventTime,MotionEvent.ACTION_UP, x, y , 0);
		try {
			inst.sendPointerSync(event);
		} catch (SecurityException ignored) {}
		
		solo.sleep(200);
	}

}
