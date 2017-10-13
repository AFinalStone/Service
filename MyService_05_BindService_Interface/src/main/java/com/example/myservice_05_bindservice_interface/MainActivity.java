package com.example.myservice_05_bindservice_interface;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    IService myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMethodInService(View view){
        // 绑定服务
        Intent intent = new Intent(this, TestService.class);
        MyConn myConn = new MyConn();
        bindService(intent, myConn, BIND_AUTO_CREATE);
        if(myBinder != null){
            myBinder.callMethodInService();
            //下面的这些方法都不能够再被使用，权限被收缩
//            myBinder.callEatMethodInService();
//            myBinder.callSleepMethodInService();
//            myBinder.callBeatDouDouMethodInService();
        }
    }

    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("===========onServiceConnected===================");
            // 3.在activity中,绑定服务成功时得到服务返回的中间人对象
            myBinder = (IService)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }

    }
}
