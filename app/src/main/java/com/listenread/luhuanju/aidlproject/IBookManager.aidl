// IBookManager.aidl
package com.listenread.luhuanju.aidlproject;
import com.listenread.luhuanju.aidlproject.Book;

// Declare any non-default types here with import statements

interface IBookManager {
 List<Book> getBookLIst();
 void addBook(in Book boog);

}
