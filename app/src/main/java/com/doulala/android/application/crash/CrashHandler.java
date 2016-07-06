package com.doulala.android.application.crash;

import java.lang.Thread.UncaughtExceptionHandler;

import com.doulala.android.BuildConfig;
import com.doulala.android.application.DApplication;
import android.content.Context;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类 来接管程序,并记录 发送错误报告.
 */
public class CrashHandler implements UncaughtExceptionHandler {

	public static final String TAG = "CrashHandler";
	/**
	 * 系统默认的UncaughtException处理类
	 */
	private UncaughtExceptionHandler mDefaultHandler;
	/**
	 * 程序的Context对象
	 */
	private DApplication application;


	/**
	 * 保证只有一个CrashHandler实例
	 */
	public CrashHandler() {

	}


	public void init(DApplication application) {
		this.application = application;
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {

		if(BuildConfig.DEBUG)
		ex.printStackTrace();

		//TODO 添加你的逻辑

		android.os.Process.killProcess(android.os.Process.myPid());
	}



}
