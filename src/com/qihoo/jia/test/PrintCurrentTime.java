package com.qihoo.jia.test;

import java.text.SimpleDateFormat;

import android.util.Log;

public class PrintCurrentTime {
	
	public PrintCurrentTime() {
		

	}
	
	public void print() {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String TimeString = time.format(new java.util.Date());
		Log.i("hejian", TimeString);
	}

}
