package com.qihoo.jia.test;

import android.util.Log;
import android.view.View;

public class ViewInfo {

	public String findId(View v) {

		if (v != null) {

			String temp = v.toString();
			int index = temp.lastIndexOf(":id/");
			if (index > 0) {
				String id = temp.substring(index + 4, temp.length() - 1);
				return id;
			}
		}
		return null;

	}

	public boolean checkIdInView(View v, String Id) {
		String viewId = findId(v);

		if (viewId != null) {
			if (viewId.equals(Id)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
