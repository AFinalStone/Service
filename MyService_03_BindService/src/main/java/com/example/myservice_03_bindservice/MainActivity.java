package com.example.myservice_03_bindservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Intent intent;
    private MyConn conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View v){
        // 开启服务
        intent = new Intent(this, TestService.class);
        startService(intent);
    }

    public void stop(View v){
        // 停止服务
        stopService(intent);
    }

    public void bind(View v){
        // 绑定服务
        Intent intent = new Intent(this, TestService.class);
        conn = new MyConn();
        // service 开启服务使用的意图对象
        // conn 就是activity与服务之间建立的连接,是它们通讯的渠道
        // flags 通常使用BIND_AUTO_CREATE表示在绑定服务时,如果服务对象不存在,会自动的创建服务然后在绑定
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbind(View v){
        // 解除绑定的服务
        // conn 绑定服务时建立的连接
        unbindService(conn);
    }

    /**
     * 自定义连接的实现类.就是activity与服务之间建立的连接,是它们通讯的渠道
     * @author Administrator
     *
     */
    private class MyConn implements ServiceConnection{

        /**
         * 绑定服务成后调用这个方法
         * name 组件的名称
         * service 服务返回的中间人对象
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //这里的代码并不会执行，因为TestService里面的onBind返回NULL
            System.out.println("============成功绑定服务，建立连接=================");
        }

        /**
         * 解除绑定的服务成后调用这个方法
         * name 组件的名称
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            //这里的代码不会执行
            System.out.println("============成功解绑服务，断开连接=================");
        }

    }
}
