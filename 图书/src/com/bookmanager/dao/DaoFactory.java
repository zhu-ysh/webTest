package com.bookmanager.dao;

import com.bookmanager.dao.impl.BookManagerDaoImpl;

public class DaoFactory {
	private static BookManagerDao bookManagerDao;
	
	public static BookManagerDao getBookManagerDao() {
		if(null == bookManagerDao) {
			bookManagerDao = new BookManagerDaoImpl();
		}
		return bookManagerDao;
	}
}
