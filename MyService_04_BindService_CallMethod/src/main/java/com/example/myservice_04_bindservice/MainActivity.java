package com.example.myservice_04_bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TestService.MyBinder myBinder;
    MyConn myConn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMethodInService(View view){
        //四大组件都必须让系统来启动,否则就没有上下文的特性,就相当于一个普通的类对象,那么methodInService方法中的
        //this就是空的，所以这里会报空指针异常
        TestService testService = new TestService();
        testService.methodInService();
    }

    public void callMethodInServiceByBinder(View view){

        // 绑定服务
        Intent intent = new Intent(this, TestService.class);
        myConn = new MyConn();
        bindService(intent, myConn, BIND_AUTO_CREATE);
        if(myBinder != null){
            myBinder.callMethodInService();
            myBinder.callEatMethodInService();
            myBinder.callSleepMethodInService();
            myBinder.callBeatDouDouMethodInService();
        }
    }

    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("===========onServiceConnected===================");
            // 3.在activity中,绑定服务成功时得到服务返回的中间人对象
            myBinder = (TestService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }

    }
}
