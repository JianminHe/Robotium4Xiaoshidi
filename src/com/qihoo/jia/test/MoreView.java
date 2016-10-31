package com.qihoo.jia.test;

import junit.framework.Assert;
import android.widget.TextView;

import com.robotium.solo.Solo;

public class MoreView {
	
	private Solo solo;
	private ViewOperate viewOperate;

	
	public MoreView(Solo solo, ViewOperate viewOperate) {
		
		this.solo = solo;
		this.viewOperate = viewOperate;

	}
	
	public void checkUserName(String userName) {
	
		TextView accountName = (TextView) viewOperate.getViewByID("account_name");
		
		Assert.assertEquals(userName, accountName.getText().toString());
	}
	
	public void go2AccountAndSecurityPage() {
		
		solo.clickOnText("帐号与安全");
		
		solo.waitForText("修改密码");
	}



}
