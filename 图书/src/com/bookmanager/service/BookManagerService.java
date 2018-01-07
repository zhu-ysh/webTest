package com.bookmanager.service;

import java.util.ArrayList;

import com.bookmanager.entity.BookManager;

public interface BookManagerService extends Service<BookManager>{
	ArrayList<BookManager> selectAll(int per, int page);
	int getCountRow();
}
