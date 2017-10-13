package com.example.myservice_04_bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	/**
	 * 绑定服务时调用这个方法
	 * intent 绑定服务时传递过来的意图
	 */
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("============onBind=================");
		return new MyBinder();
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

	public void methodInService(){
		Toast.makeText(this, "服务中的方法被调用", Toast.LENGTH_SHORT).show();
	}

	public void eat(){
		Toast.makeText(this, "吃饭", Toast.LENGTH_SHORT).show();
	}

	public void sleep(){
		Toast.makeText(this, "睡觉", Toast.LENGTH_SHORT).show();
	}

	public void beatDouDou(){
		Toast.makeText(this, "打豆豆", Toast.LENGTH_SHORT).show();
	}

	/**
	 * 1.在服务的类中写一个中间人的内部类,在这类中写一个方法去调用服务的业务方法;
	 * @author Administrator
	 */
	public class MyBinder extends Binder {

		public void callMethodInService(){
			// 调用服务中的业务方法
			methodInService();
		}

		public void callEatMethodInService(){
			// 调用服务中的业务方法
			eat();
		}
		public void callSleepMethodInService(){
			// 调用服务中的业务方法
			sleep();
		}

		public void callBeatDouDouMethodInService(){
			// 调用服务中的业务方法
			beatDouDou();
		}
	}
}
