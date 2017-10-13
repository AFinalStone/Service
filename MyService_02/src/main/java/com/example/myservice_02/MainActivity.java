package com.example.myservice_02;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private MediaRecorder r;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void startRecord(View view){
		// 开启服务
		Intent intent = new Intent(this, PhoneStateListenerService.class);
		startService(intent);

//		try {
//			// 1.创建录音机对象
//			r = new MediaRecorder();
//			// 2.设置音频来源
//			r.setAudioSource(MediaRecorder.AudioSource.MIC);
//			// 3.设置音频文件的格式
//			r.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//			// 4.设置音频文件的名称
//			r.setOutputFile(Environment.getExternalStorageDirectory()+"/zz08.3gp");
//			// 5.设置音频文件的编码
//			r.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//			// 6.准备录音机
//			r.prepare();
//			//开始录音
//			r.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}


}
