package com.qihoo.jia.test;

import junit.framework.Assert;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.*;

public class Login {

	private Solo solo;
	private ViewFetcher viewFetcher;
	private MainView mainView;
	private ViewOperate viewOperate;

	public Login(Solo solo, ViewFetcher viewFetcher, MainView mainView,
			ViewOperate viewOperate) {

		this.solo = solo;
		this.viewFetcher = viewFetcher;
		this.mainView = mainView;
		this.viewOperate = viewOperate;
	}

	public void switchLoginPage() {


		for (int i = 0; i < 100; i++) {

			if (solo.waitForText("µÇÂ¼", 2, 100)) {
				return;
			}
			

			if (solo.waitForText("¸ü¶à", 1, 100)) {
				mainView.switchTab(3);

				solo.sleep(100);

				mainView.clickLogout();

				break;
			}

		}
		solo.waitForText("µÇÂ¼", 1, 3000);

	}

	public void login(String userName, String password) {
		solo.enterText(0, userName);
		solo.enterText(1, password);

		viewOperate.clickById("login_btn");

	}

	public void showPasswordButtonCheck() {

		TextView t = (TextView) viewOperate.getViewByID("text_password");

		Assert.assertEquals("ÏÔÊ¾ÃÜÂë", t.getText().toString());

		viewOperate.clickById("text_password");

		solo.sleep(1000);

		Assert.assertEquals("Òþ²ØÃÜÂë", t.getText().toString());

	}

	public void expressReg(String userName, String password) {

	}

	public void forgetPassword() {
		viewOperate.clickById("forget_password_btn");

		solo.sleep(1000);

	}

	public void loginAndSwitch2Page(String userName, String password, int page) {

		switchLoginPage();

		login(userName, password);

		solo.waitForText("ÎÒµÄ");

		mainView.switchTab(page);
	}

}
