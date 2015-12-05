package com.xch.page.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



public class DB {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	public Connection getConnection(){
		Properties pro = new Properties();
		try {
			pro.load(DB.class.getResourceAsStream("DBconfig.properties"));
			
		} catch (IOException e) {
			System.out.println("加载配置文件失败");
		}
		String url = pro.getProperty("jdbc.url");
		String driver = pro.getProperty("jdbc.driver");
		String username = pro.getProperty("jdbc.username");
		String password = pro.getProperty("jdbc.password");
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("数据库驱动加载失败");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * 执行更新操作
	 * @param sql sql语句
	 * @param params params 执行参数
	 * @return 执行结果
	 * @throws SQLException
	 */
	public boolean updateByPreparedStatement(String sql,List<?> params) throws SQLException{
		boolean flag = false;
		int result = -1;//表示当用户执行添加删除和修改的时候所影响数据库的行数
		pstmt = connection.prepareStatement(sql);
		int index = 1;
		// 填充sql语句中的占位符
		if(params != null && !params.isEmpty()){
			for(int i = 0;i < params.size();i ++)
			pstmt.setObject(index, params.get(i));
		}
		result = pstmt.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
	}
	/**
	 * 查询结果集
	 * @param sql sql语句
	 * @param params 执行参数
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findResult(String sql, List<?> params) throws SQLException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		for(int i = 0;i < params.size();i ++){
			pstmt.setObject(index ++, params.get(i));
		}
		resultSet = pstmt.executeQuery();
		
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		
		while(resultSet.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			for(int i = 0;i < cols_len;i ++){
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if(cols_value != null){
					map.put(cols_name, cols_value);
				}
			}
			list.add(map);
		}
		return list;
	}
	/**
	 * 关闭连接资源
	 */
	public void releaseConn(){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		DB db = new DB();
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
