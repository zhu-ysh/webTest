package com.bookmanager.dao;

import java.util.ArrayList;

import com.bookmanager.entity.BookManager;

public interface BookManagerDao extends BaseDao<BookManager>{
	ArrayList<BookManager> selectAll(int per, int page);
	int getCountRow();
}
