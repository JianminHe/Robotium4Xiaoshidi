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

	// ������ͼ���л�����ҳ��
	// ID = 0 �ҵģ� 1 Χ�ۣ� 2 ��Ϣ�� Ĭ��= ����
	public void switchTab(int id) {
		
		solo.waitForText("����");

		View tmp = viewOperate.getViewByID("main_indicator");

		if (tmp != null) {
			switch (id) {

			case 0:
				viewOperate.clickByText(tmp, "�ҵ�");
				break;

			case 1:
				viewOperate.clickByText(tmp, "Χ��");

				break;

			case 2:
				viewOperate.clickByText(tmp, "��Ϣ");
				break;

			default:
				viewOperate.clickByText(tmp, "����");
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
