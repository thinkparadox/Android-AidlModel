package com.listenread.luhuanju.aidlproject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by luhuanju on 16/5/28.
 */

public class IbookManagerService extends Service {
    private CopyOnWriteArrayList<Book> books=new CopyOnWriteArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        books.add(new Book(1,"Android"));
        books.add(new Book(2,"IOS"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }




    private Binder mBinder=new IBookManager.Stub(){
        @Override
        public List<Book> getBookLIst() throws RemoteException {
            return books;
        }

        @Override
        public void addBook(Book boog) throws RemoteException {
            books.add(boog);


        }
    };
}
