package com.example.myservice_02;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneStateListenerService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {

		super.onCreate();

		// 开启监听电话状态的功能
		// 得到系统提供的电话服务
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// 监听电话状态
		// listener 电话状态的监听器
		// events 状态的类别,如电话的呼叫状态
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}

	private class MyListener extends PhoneStateListener {

		private MediaRecorder r;

		/**
		 * 当电话的呼叫状态发生变化后调用这个方法 state 电话的呼叫状态: 铃声响起 ,接通,空闲 incomingNumber
		 * 打进来的电话号码
		 */
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
				case TelephonyManager.CALL_STATE_IDLE: // 空闲状态
					System.out.println("========结束录音=================");
					if(r != null){
						// 结束录音
						r.stop();
						// 释放录音机占用的资源
						r.release();

						r = null;
					}

					break;

				case TelephonyManager.CALL_STATE_RINGING: // 铃声响起状态
					System.out.println("==========准备录音机==============");

					try {
						// 1.创建录音机对象
						r = new MediaRecorder();
						// 2.设置音频来源
						r.setAudioSource(MediaRecorder.AudioSource.MIC);
						// 3.设置音频文件的格式
						r.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
						// 4.设置音频文件的名称
						r.setOutputFile(Environment.getExternalStorageDirectory()+"/zz08.3gp");
						// 5.设置音频文件的编码
						r.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
						// 6.准备录音机
						r.prepare();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case TelephonyManager.CALL_STATE_OFFHOOK: // 接通状态
					System.out.println("==========开始录音==============");
					if(r != null){
						r.start();
					}

					break;


			}
		}

	}
}
