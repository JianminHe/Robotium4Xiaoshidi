package com.qihoo.jia.test;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;

import com.robotium.solo.*;

public class MainView {

	private Solo solo;
	private ViewOperate viewOperate;

	public MainView(Solo solo, ViewOperate viewOperate) {
		this.solo = solo;
		this.viewOperate = viewOperate;

	}

	// 在主视图，切换功能页面
	// ID = 0 我的， 1 围观， 2 消息， 默认= 更多
	public void switchTab(int id) {
		
		solo.waitForText("更多");

		View tmp = viewOperate.getViewByID("main_indicator");

		if (tmp != null) {
			switch (id) {

			case 0:
				viewOperate.clickByText(tmp, "我的");
				break;

			case 1:
				viewOperate.clickByText(tmp, "围观");

				break;

			case 2:
				viewOperate.clickByText(tmp, "消息");
				break;

			default:
				viewOperate.clickByText(tmp, "更多");
				break;

			}

		}

	}

	public void clickLogout() {
		viewOperate.clickById("btn_showDialog");

		solo.sleep(500);

		viewOperate.clickById("layout_positive_btn");

	}

	public boolean assertInMainView() {

		View tmp = viewOperate.getViewByID("main_indicator");
		if (tmp == null)
			return false;
		else
			return true;
	}
}
