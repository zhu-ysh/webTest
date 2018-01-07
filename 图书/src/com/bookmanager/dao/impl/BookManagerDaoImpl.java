package com.bookmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookmanager.dao.BookManagerDao;
import com.bookmanager.entity.BookManager;
import com.bookmanager.tool.DBUtil;

public class BookManagerDaoImpl implements BookManagerDao{
	private Connection conn = DBUtil.getConnection();

	@Override
	public boolean save(BookManager t) {
		String sql = "insert into book_manager(book_id,book_name,book_writer) values(book_manager_seq.nextval,?,?)";
		PreparedStatement ps= null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getBookName());
			ps.setString(2, t.getBookWriter());
			int row = ps.executeUpdate();
			if(1 == row) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean delete(BookManager t) {
		String sql = "update book_manager set book_status = 1 where book_status=0 and book_id=?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getBookId());
			int row = ps.executeUpdate();
			if(1 == row) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean update(BookManager t) {
		return false;
	}

	@Override
	public BookManager selectById(int id) {
		return null;
	}

	@Override
	public ArrayList<BookManager> selectAll() {
		String sql = "select * from book_manager where book_status =0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookManager> bms = new ArrayList<BookManager>();
		
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookManager bookManager = new BookManager(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getTimestamp(5)
						);
				bms.add(bookManager);
			}
			return bms;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<BookManager> selectAll(int per, int page) {
		String sql = "select * from   \r\n" + 
				"(  \r\n" + 
				"select t.*, rownum r  \r\n" + 
				"from (select * from book_manager where book_status = 0 order by book_id) t   \r\n" + 
				")  \r\n" + 
				"where r between ? and ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookManager> bms = new ArrayList<BookManager>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page*per-(per-1));
			ps.setInt(2, page*per);
			rs = ps.executeQuery();
			while(rs.next()) {
				BookManager bookManager = new BookManager(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getTimestamp(5)
						);
				bms.add(bookManager);
			}
			return bms;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public int getCountRow() {
		String sql = "select count(*) from book_manager where book_status=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
}
