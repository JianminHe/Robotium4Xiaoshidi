package com.qihoo.jia.test;

import android.widget.TextView;

import com.robotium.solo.Solo;

public class VedioView {

	private Solo solo;
	private ViewOperate viewOperate;

	public VedioView(Solo solo, ViewOperate viewOperate) {
		this.solo = solo;
		this.viewOperate = viewOperate;
	}

	// 点击视频模式
	public void switchViewMode(int ID) {

		viewOperate.clickById("quality_btn");

		switch (ID) {

		case 0:
			solo.clickOnText("清晰");
			break;
		case 1:
			solo.clickOnText("流畅");
			break;
		case 2:
			solo.clickOnText("照片");
			break;
		default:
			solo.clickOnText("清晰");
			break;
		}

	}

	// 等待加载视频模式
	public void waitForViewLoading(int id) {

		String viewMode = "清晰模式";

		switch (id) {
		case 0:
			viewMode = "清晰模式";
			break;
		case 1:
			viewMode = "流畅模式";
			break;
		case 2:
			viewMode = "照片模式";
			break;
		}

		viewOperate.waitForTextById("view_mode", viewMode);
		
		if(id == 0 || id == 1) {
			waitForVedioLoading();
		} else {
			solo.sleep(3000);
		}

	}

	public void waitForVedioLoading() {

		for (int j = 0; j < 100; j++) {

			TextView tView = (TextView) viewOperate
					.getViewByID("player_updata_status");

			if (tView != null) {

				// 出现有数据流，说明加载成功
				String temp = tView.getText().toString();

				if (temp.length() > 2) {

					if (temp.substring(0, 2).equals("--") != true) {
						break;
					}
				}
			}
		}

	}

}
