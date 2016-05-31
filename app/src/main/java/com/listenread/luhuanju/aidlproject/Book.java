package com.listenread.luhuanju.aidlproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luhuanju on 16/5/28.
 */

public class Book implements Parcelable {

    private int bookType;
    private String bookName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookType);
        dest.writeString(bookName);


    }

    public int getBookType() {
        return bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public static Creator<Book> getCREATOR() {
        return CREATOR;
    }

    public Book(Parcel parcel) {
        bookType = parcel.readInt();
        bookName = parcel.readString();

    }


    public Book(int bookType, String bookName) {
        this.bookType = bookType;
        this.bookName = bookName;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {


        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
