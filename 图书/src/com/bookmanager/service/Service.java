package com.bookmanager.service;

import java.util.ArrayList;

public interface Service<T> {
	boolean save(T t);
	boolean delete(T t);
	boolean update(T t);
	T selectById(int id);
	ArrayList<T> selectAll();
}
