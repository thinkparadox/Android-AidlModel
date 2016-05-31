// IBookManager.aidl
package com.listenread.luhuanju.aidlproject;
import com.listenread.luhuanju.aidlproject.Book;

interface IBookManager {
 List<Book> getBookLIst();
 void addBook(in Book boog);
}
