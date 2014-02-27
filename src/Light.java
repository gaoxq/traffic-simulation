package com.org.transport;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Light {

	// 0: 红灯, 1: 绿灯
	// 初始设置l2,l3为绿灯;l1,l4为红灯
	// 初始设置l6,l7为绿灯;l5,l8为红灯

	private int l1 = 0;
	private int l2 = 1;
	private int l5;
	private int l6;
	private int redGap;
	private int greenGap;
	private int delayGap;
	private int gap;
	private int specialGap;

	// 设定定时器
	public Light() {

		// 获取设置参数的窗口的相关参数
		redGap = Integer.parseInt(SettingGui.redText.getText());
		greenGap = Integer.parseInt(SettingGui.greenText.getText());
		delayGap = Integer.parseInt(SettingGui.delayText.getText());
		gap = redGap + greenGap;
		//判断CR2路口初始时刻的红绿灯应该如何设置。
		if (redGap > delayGap) {
			l5 = 1;
			l6 = 0;
			specialGap = delayGap + greenGap;
		} else {
			l5 = 0;
			l6 = 1;
			specialGap = delayGap - redGap;
		}

		setLightTimer();

	}

	public void setLightTimer() {

		Timer t1 = new Timer();
		// 控制CR1,按照题目中的参数需在12秒之后执行,每隔14s执行一次。本程序中可以自己设定。
		// 依照题意中参数: (new light1(), 120 * 1000, 140 * 1000);
		t1.schedule(new light1(), greenGap * 1000, gap * 1000);

		Timer t2 = new Timer();
		// 控制CR1,按照题目中的参数需在14秒之后执行,每隔14s执行一次。本程序中可以自己设定。
		// 依照题意中参数: (new light2(), 140 * 1000, 140 * 1000);
		t2.schedule(new light2(), gap * 1000, gap * 1000);

		Timer t3 = new Timer();
		// 控制CR2,按照题目中的参数需在4秒之后执行,每隔14s执行一次。本程序中可以自己设定。
		// 依照题意中参数: (new light3(), 40 * 1000, 140 * 1000);
		t3.schedule(new light3(), specialGap * 1000, gap * 1000);

		Timer t4 = new Timer();
		// 控制CR2,按照题目中的参数需在6秒之后执行,每隔14s执行一次。本程序中可以自己设定。
		// 依照题意中参数: (new light4(), 60 * 1000, 140 * 1000);
		t4.schedule(new light4(), delayGap * 1000, gap * 1000);
	}
	
	//控制CR1路口
	private class light1 extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (l1 == 0) {
				l1 = 1;
				l2 = 0;
			}
		}
	}
	//控制CR1路口
	private class light2 extends TimerTask {
		@Override
		public void run() {
			if (l1 == 1) {
				l1 = 0;
				l2 = 1;
			}
		}
	}
	//控制CR2路口
	private class light3 extends TimerTask {
		@Override
		public void run() {
			if (l5 == 0) {
				l6 = 0;
				l5 = 1;

			}
		}
	}
	//控制CR2路口
	private class light4 extends TimerTask {
		@Override
		public void run() {
			if (l5 == 1) {
				l6 = 1;
				l5 = 0;
			}
		}
	}

	public int getl1() {
		return l1;
	}

	public int getl2() {
		return l2;
	}

	public int getl5() {
		return l5;
	}

	public int getl6() {
		return l6;
	}

}
