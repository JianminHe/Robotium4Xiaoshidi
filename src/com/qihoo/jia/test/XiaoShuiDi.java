package com.qihoo.jia.test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import junit.framework.TestCase;

public class XiaoShuiDi extends ActivityInstrumentationTestCase2 {

	private Solo solo;
	private ViewFetcher viewFetcher;
	private Login login;
	private MainView mainView;
	private ViewOperate viewOperate;
	private MoreView moreView;
	private AccountSecurity accountSecurity;
	private Unlock unlock;
	private VedioView vedioView;
	

	private static final String TARGET_PACKAGE_ID = "com.qihoo.jia";
	private static String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.kindroid.d3.ui.SplashActivity";

	// private static String LAUNCHER_ACTIVITY_FULL_CLASSNAME =
	// "com.kindroid.d3.ui.LandingPageActivity";

	@SuppressWarnings({ "unchecked", "deprecation" })
	public XiaoShuiDi() throws Exception {
		super(TARGET_PACKAGE_ID, Class
				.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME));
	}

	public void setUp() throws Exception {
		this.solo = new Solo(this.getInstrumentation(), this.getActivity());
		this.viewFetcher = new ViewFetcher(solo, this.getInstrumentation());
		this.viewOperate = new ViewOperate(solo);
		this.mainView = new MainView(solo, viewOperate);
		this.login = new Login(solo, viewFetcher, mainView, viewOperate);
		this.moreView = new MoreView(solo, viewOperate);
		this.accountSecurity = new AccountSecurity(solo, viewOperate);
		this.unlock = new Unlock(solo, viewOperate, this.getInstrumentation());
		this.vedioView = new VedioView(solo, viewOperate);

	}

	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	// public void testLogin_Success() throws Exception
	// {
	//
	//
	// login.switchLoginPage();
	//
	//
	// login.login("13718644701", "yunfis");
	//
	// solo.waitForText("更多", 1, 10000);
	//
	// assertEquals(true, mainView.assertInMainView());
	//
	// }
	//
	//
	// public void testLogin_ForgetTypeUserName() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("", "abcdefg");
	//
	// assertEquals(true, solo.waitForText("帐号不能为空，请重新输入"));
	// }
	//
	// public void testLogin_ForgetTypePassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("13718644701", "");
	//
	// assertEquals(true, solo.waitForText("密码不能为空"));
	// }
	//
	// public void testLogin_UserAccountNotExist() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("abcddfssdsdfds@", "lllll");
	//
	// assertEquals(true, solo.waitForText("帐号不存在"));
	//
	// solo.clickOnText("确定");
	// }
	//
	// public void testLogin_IncorrectPassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("13718644701", "password");
	//
	// assertEquals(true, solo.waitForText("密码错误"));
	//
	// solo.clickOnText("确定");
	//
	// solo.sleep(1000);
	// }
	//
	// public void testLogin_ShowPassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.showPasswordButtonCheck();
	//
	// }
	//
	// public void testLogin_ForgetPassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.forgetPassword();
	// }
	//
	// public void testMore_CheckUserName() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.checkUserName("13718644701");
	// }
	//
	// public void testMore_checkNeckname() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// solo.sleep(2000);
	//
	// accountSecurity.checkNeckname("乐逗她爹");
	//
	// }
	//
	// public void testMore_changeNeckname_LessWord() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	//
	// accountSecurity.changeNeckname("a");
	//
	// assertEquals(true, solo.waitForText("昵称修改失败,昵称长度不合法"));
	//
	//
	// }
	//
	// public void testMore_changeNeckname_EmptyName() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.go2NecknameSettingPage();
	//
	// accountSecurity.clickSaveButton();
	//
	// assertEquals(true, solo.waitForText("您的昵称没有变化"));
	//
	// }
	//
	// public void testMore_changeNeckname_empty() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changeNeckname("");
	//
	// assertEquals(true, solo.waitForText("昵称不能为空"));
	//
	// }
	//
	// public void testMore_changeNeckname_success() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changeNeckname("乐逗她爹Abc");
	//
	// assertEquals(true, solo.waitForText("昵称保存成功"));
	// }
	//
	//
	// public void testMore_changeNeckname_success_changeNameBack() throws
	// Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changeNeckname("乐逗她爹");
	//
	// assertEquals(true, solo.waitForText("昵称保存成功"));
	// }
	//
	// public void testMore_changePassword_noOldPassword() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("", "abcdefg", "abcdefg");
	//
	// assertEquals(true, solo.waitForText("旧密码不能为空"));
	//
	// }
	//
	// public void testMore_changePassword_OldPasswordIncorrect() throws
	// Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("ddd", "abcdefg", "abcdefg");
	//
	// assertEquals(true, solo.waitForText("旧密码输入有误"));
	// }
	//
	// public void testMore_changePassword_newPasswrdDifferent() throws
	// Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("yunfis", "abcdefga", "abcdefg");
	//
	// assertEquals(true, solo.waitForText("两次密码输入不一致"));
	// }
	//
	//
	// public void testMore_changePassword_newPasswrdless() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("yunfis", "a", "a");
	//
	// assertEquals(true, solo.waitForText("新密码长度必须大于等于6"));
	// }
	//
	// public void testMore_changePassword_newPasswrdOneDidNotInput() throws
	// Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("yunfis", "", "a");
	//
	// assertEquals(true, solo.waitForText("新密码不能为空"));
	// }
	//
	// public void testMore_changePassword_newPasswrdSaveSuccess() throws
	// Exception
	// {
	// login.loginAndSwitch2Page("he_jm@163.com", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("yunfis", "yunfis1", "yunfis1");
	//
	// assertEquals(true, solo.waitForText("修改密码成功"));
	// }
	//
	// public void testMore_changePassword_newPasswrdSaveSuccess_changeBack()
	// throws Exception
	// {
	// login.loginAndSwitch2Page("he_jm@163.com", "yunfis1", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changePassword("yunfis1", "yunfis", "yunfis");
	//
	// assertEquals(true, solo.waitForText("修改密码成功"));
	// }
	//
	// public void testMore_setUnlock() throws Exception
	// {
	// login.loginAndSwitch2Page("he_jm@163.com", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.setUnlock("yunfis000");
	//
	// assertEquals(true, solo.waitForText("登录密码错误，请重新输入"));
	// }
	//

	public void test_LoadTesting() throws Exception {
		for (int i = 0; i < 2; i++) {

			solo.waitForText("我的", 2, 20000);
			viewFetcher.clickById("camera_icon");

			solo.waitForText("didi", 2, 10000);

			for (int j = 0; j < 100; j++) {

				TextView tView = (TextView) viewFetcher
						.getChildViewById("player_updata_status");

				if (tView != null) {

					//出现有数据流，说明加载成功
					String temp = tView.getText().toString();

					if (temp.length() > 2) {
						
						
						if (temp.substring(0, 2).equals("--") != true) {
							break;
						}
					}
					
					
					

				}
				
				//出现网络不给力，点击重试
				
				if(solo.waitForText("网络不给力", 1, 500))
				{
					viewFetcher.clickById("video_loading_progress");
				}

				solo.sleep(100);
			}
			
			
			vedioView.waitForViewLoading(0);
			
			vedioView.waitForViewLoading(1);
			
			vedioView.waitForViewLoading(2);
			
			vedioView.waitForViewLoading(0);
			//切换三种模式  清晰 流畅 照片
			
			viewFetcher.clickById("btn_back");
		}

		// solo.clickOnText("按住说话");
	}
}
