package com.qihoo.jia.test;

import junit.framework.Assert;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.robotium.solo.Solo;

public class AccountSecurity {
	
	private Solo solo;
	private ViewOperate viewOperate;
	
	public AccountSecurity(Solo solo, ViewOperate viewOperate)
	{
		this.solo = solo;
		this.viewOperate = viewOperate;
	}
	
	public void checkNeckname(String neckname) {
		
		TextView nameView = (TextView) viewOperate.getViewByID("account_setting_bound_data");
		
		String name = nameView.getText().toString();
		
		Assert.assertEquals(neckname, name);
	}
	
	public void go2NecknameSettingPage() {
		
		viewOperate.clickById("account_setting_bound_data");
		
		solo.waitForText("设置昵称");
	}
	
	//点击”保存“按钮
	public void clickSaveButton() {
		
		viewOperate.clickById("btn_right");
	}
	
	//点击返回上一页面
	public void clickBackButton() {
		viewOperate.clickById("btn_back");
	}
	
	public void clickChangePasswordButton() {
		viewOperate.clickById("account_change_pwd");
	}
	
	public void changeNeckname(String neckname) {
		
		go2NecknameSettingPage();

		viewOperate.clickById("common_edittext_delete");
		
		solo.sleep(100);
		
		solo.enterText(0, neckname);
		
		solo.sleep(100);
		
		viewOperate.clickById("btn_right");
		
	}
	
	public void changePassword(String oldPassword, String newPasswordA, String newPasswordB )
	{
		clickChangePasswordButton();
		
		solo.waitForText("请输入旧密码");
		
		solo.enterText(0, oldPassword);
		
		solo.enterText(1, newPasswordA);
		
		solo.enterText(2, newPasswordB);
		
		viewOperate.clickById("btn_right");
		
	}
	
	public boolean getUnlockButtonStatus() {
		ToggleButton tButton = (ToggleButton) viewOperate.getViewByID("setting_switch");
		
		if(tButton.isChecked())
			return true;
		else 
			return false;
	}
	

	public void setUnlock(String password)
	{

		//不能直接用setting_switch直接找按钮，因为界面上有重复ID控件，先找到父控件，然后再找子控件
		View view1 = viewOperate.getViewByID("lv_pattern_lock");
		
		View view2 = viewOperate.getViewByID(view1, "setting_switch");
		
		solo.clickOnView(view2);
		
	//	solo.waitForText("360账号");
		
		solo.enterText(0, password);
		
		viewOperate.clickById("positive_btn");
		
		
	}
	

}
