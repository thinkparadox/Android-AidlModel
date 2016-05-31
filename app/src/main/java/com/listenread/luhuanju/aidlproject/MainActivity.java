package com.listenread.luhuanju.aidlproject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent=new Intent(this,IbookManagerService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);

    }


    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //绑定成功之后,将BINDER 转换为AIDL  --》调用方法
            IBookManager manager=IBookManager.Stub.asInterface(service);
            try{
                List<Book> books=manager.getBookLIst();
                for(int i=0;i<books.size();i++){
                    Log.d("TAG",":"+books.get(i).getBookType()+books.get(i).getBookName());
                }

            }catch (RemoteException e){

            }



        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
