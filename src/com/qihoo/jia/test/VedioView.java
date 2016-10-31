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

	// �����Ƶģʽ
	public void switchViewMode(int ID) {

		viewOperate.clickById("quality_btn");

		switch (ID) {

		case 0:
			solo.clickOnText("����");
			break;
		case 1:
			solo.clickOnText("����");
			break;
		case 2:
			solo.clickOnText("��Ƭ");
			break;
		default:
			solo.clickOnText("����");
			break;
		}

	}

	// �ȴ�������Ƶģʽ
	public void waitForViewLoading(int id) {

		String viewMode = "����ģʽ";

		switch (id) {
		case 0:
			viewMode = "����ģʽ";
			break;
		case 1:
			viewMode = "����ģʽ";
			break;
		case 2:
			viewMode = "��Ƭģʽ";
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

				// ��������������˵�����سɹ�
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
