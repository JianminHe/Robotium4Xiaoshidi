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
	// solo.waitForText("����", 1, 10000);
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
	// assertEquals(true, solo.waitForText("�ʺŲ���Ϊ�գ�����������"));
	// }
	//
	// public void testLogin_ForgetTypePassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("13718644701", "");
	//
	// assertEquals(true, solo.waitForText("���벻��Ϊ��"));
	// }
	//
	// public void testLogin_UserAccountNotExist() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("abcddfssdsdfds@", "lllll");
	//
	// assertEquals(true, solo.waitForText("�ʺŲ�����"));
	//
	// solo.clickOnText("ȷ��");
	// }
	//
	// public void testLogin_IncorrectPassword() throws Exception
	// {
	// login.switchLoginPage();
	//
	// login.login("13718644701", "password");
	//
	// assertEquals(true, solo.waitForText("�������"));
	//
	// solo.clickOnText("ȷ��");
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
	// accountSecurity.checkNeckname("�ֶ�����");
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
	// assertEquals(true, solo.waitForText("�ǳ��޸�ʧ��,�ǳƳ��Ȳ��Ϸ�"));
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
	// assertEquals(true, solo.waitForText("�����ǳ�û�б仯"));
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
	// assertEquals(true, solo.waitForText("�ǳƲ���Ϊ��"));
	//
	// }
	//
	// public void testMore_changeNeckname_success() throws Exception
	// {
	// login.loginAndSwitch2Page("13718644701", "yunfis", 3);
	//
	// moreView.go2AccountAndSecurityPage();
	//
	// accountSecurity.changeNeckname("�ֶ�����Abc");
	//
	// assertEquals(true, solo.waitForText("�ǳƱ���ɹ�"));
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
	// accountSecurity.changeNeckname("�ֶ�����");
	//
	// assertEquals(true, solo.waitForText("�ǳƱ���ɹ�"));
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
	// assertEquals(true, solo.waitForText("�����벻��Ϊ��"));
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
	// assertEquals(true, solo.waitForText("��������������"));
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
	// assertEquals(true, solo.waitForText("�����������벻һ��"));
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
	// assertEquals(true, solo.waitForText("�����볤�ȱ�����ڵ���6"));
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
	// assertEquals(true, solo.waitForText("�����벻��Ϊ��"));
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
	// assertEquals(true, solo.waitForText("�޸�����ɹ�"));
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
	// assertEquals(true, solo.waitForText("�޸�����ɹ�"));
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
	// assertEquals(true, solo.waitForText("��¼�����������������"));
	// }
	//

	public void test_LoadTesting() throws Exception {
		for (int i = 0; i < 2; i++) {

			solo.waitForText("�ҵ�", 2, 20000);
			viewFetcher.clickById("camera_icon");

			solo.waitForText("didi", 2, 10000);

			for (int j = 0; j < 100; j++) {

				TextView tView = (TextView) viewFetcher
						.getChildViewById("player_updata_status");

				if (tView != null) {

					//��������������˵�����سɹ�
					String temp = tView.getText().toString();

					if (temp.length() > 2) {
						
						
						if (temp.substring(0, 2).equals("--") != true) {
							break;
						}
					}
					
					
					

				}
				
				//�������粻�������������
				
				if(solo.waitForText("���粻����", 1, 500))
				{
					viewFetcher.clickById("video_loading_progress");
				}

				solo.sleep(100);
			}
			
			
			vedioView.waitForViewLoading(0);
			
			vedioView.waitForViewLoading(1);
			
			vedioView.waitForViewLoading(2);
			
			vedioView.waitForViewLoading(0);
			//�л�����ģʽ  ���� ���� ��Ƭ
			
			viewFetcher.clickById("btn_back");
		}

		// solo.clickOnText("��ס˵��");
	}
}
