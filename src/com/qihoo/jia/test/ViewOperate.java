package com.qihoo.jia.test;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.robotium.solo.Solo;

public class ViewOperate {

	private Solo solo;
	private ViewInfo viewInfo;

	public ViewOperate(Solo solo) {
		this.solo = solo;
		viewInfo = new ViewInfo();
	}

	public boolean checkIdInView(String className, String id) {
		return checkIdInView(null, className, id);

	}

	public boolean checkIdInView(View view, String className, String id) {

		if (getViewByID(view, className, id) != null) {
			return true;
		}

		return false;

	}

	public View getViewByID(String id) {
		return getViewByID(null, null, id);
	}

	public View getViewByID(String className, String id) {
		return getViewByID(null, className, id);
	}

	public View getViewByID(View view, String id) {
		return getViewByID(view, null, id);
	}

	public View getViewByID(View view, String className, String id) {

		ArrayList<View> viewList = new ArrayList<View>();
		if (view == null) {
			viewList = solo.getViews();
		} else {
			viewList = solo.getViews(view);
		}

		for (int i = 0; i < viewList.size(); i++) {
			View tmpView = viewList.get(i);

			if (className != null) {

				boolean findClass = tmpView.getClass().getSimpleName()
						.toString().equals(className);
				boolean findId = viewInfo.checkIdInView(tmpView, id);

				if (findClass == true && findId == true) {
					return tmpView;
				}

			} else {
				boolean findId = viewInfo.checkIdInView(tmpView, id);

				if (findId == true) {
					return tmpView;
				}
			}
		}

		return null;
	}

	public void clickByID(View view, String id) {
		View v;
		if (view == null) {
			v = getViewByID(id);
		} else {
			v = getViewByID(view, id);
		}
		if (v != null) {

			solo.clickOnView(v);
		} else {
			Log.i("hejian", "error = " + id);
		}
	}

	public void clickById(String id) {
		clickByID(null, id);
	}

	public ArrayList<View> getViewByClassName(View view, String className) {

		ArrayList<View> viewList = new ArrayList<View>();
		ArrayList<View> findViewList = new ArrayList<View>();

		if (view == null) {
			viewList = solo.getViews(view);
		} else {
			viewList = solo.getViews();
		}

		for (int i = 0; i < viewList.size(); i++) {

			if (viewList.get(i).getClass().getSimpleName().toString()
					.equals(className)) {
				findViewList.add(viewList.get(i));
			}
		}

		return findViewList;
	}

	public void clickByText(View view, String text) {

		ArrayList<View> viewList = new ArrayList<View>();

		viewList = getViewByClassName(view, "TextView");

		for (int i = 0; i < viewList.size(); i++) {

			TextView textView = (TextView) viewList.get(i);

			if (textView.getText().toString().equals(text)) {
				solo.clickOnView(viewList.get(i));
				return;
			}
		}

	}

	public void waitForTextById(String id, String text, int duration) {

		for (int i = 0; i < 10 * duration; i++) {

			TextView t = (TextView) getViewByID("TextView", id);

			if (t != null) {

				String temp = t.getText().toString();

				if (temp.equals(text)) {
					return;
				}
			}
			solo.sleep(100);
		}

	}
	
	public void waitForTextById(String id, String text) {
		waitForTextById(id, text, 10);
	}

}
