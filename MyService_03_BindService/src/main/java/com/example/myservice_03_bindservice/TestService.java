package com.example.myservice_03_bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TestService extends Service {

	/**
	 * 绑定服务时调用这个方法
	 * intent 绑定服务时传递过来的意图
	 */
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("============onBind=================");
		return null;
	}
	
	
	/**
	 * 解除绑定的服务时调用这个方法
	 * intent 绑定服务时传递过来的意图
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("============onUnbind=================");
		return super.onUnbind(intent);
	}
	
	/**
	 * 在服务对象被创建后,调用这个方法,初始化服务对象
	 */
	@Override
	public void onCreate() {
		System.out.println("============onCreate=================");
		super.onCreate();
	}
	
	/**
	 * 在开启服务后调用这个方法
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("============onStartCommand=================");
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 在服务对象被销毁之前调用这个方法
	 * 在服务对象被销毁之前做扫尾工作,如服务被销毁之前保存数据
	 */
	@Override
	public void onDestroy() {
		System.out.println("============onDestroy=================");
		super.onDestroy();
	}

}
