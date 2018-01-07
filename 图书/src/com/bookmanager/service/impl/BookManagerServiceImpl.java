package com.bookmanager.service.impl;

import java.util.ArrayList;

import com.bookmanager.dao.BookManagerDao;
import com.bookmanager.dao.DaoFactory;
import com.bookmanager.entity.BookManager;
import com.bookmanager.service.BookManagerService;

public class BookManagerServiceImpl implements BookManagerService{
	private BookManagerDao bookManagerDao= DaoFactory.getBookManagerDao();
	@Override
	public boolean save(BookManager t) {
		return bookManagerDao.save(t);
	}

	@Override
	public boolean delete(BookManager t) {
		return bookManagerDao.delete(t);
	}

	@Override
	public boolean update(BookManager t) {
		return bookManagerDao.update(t);
	}

	@Override
	public BookManager selectById(int id) {
		return bookManagerDao.selectById(id);
	}

	@Override
	public ArrayList<BookManager> selectAll() {
		return bookManagerDao.selectAll();
	}

	@Override
	public ArrayList<BookManager> selectAll(int per, int page) {
		return bookManagerDao.selectAll(per, page);
	}

	@Override
	public int getCountRow() {
		return bookManagerDao.getCountRow();
	}

}
