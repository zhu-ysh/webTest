package com.bookmanager.dao;

import java.util.ArrayList;

public interface BaseDao<T> {
	boolean save(T t);
	boolean delete(T t);
	boolean update(T t);
	T selectById(int id);
	ArrayList<T> selectAll();
}
