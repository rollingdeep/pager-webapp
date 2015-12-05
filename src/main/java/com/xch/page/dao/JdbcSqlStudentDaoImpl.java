package com.xch.page.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xch.page.Constant;
import com.xch.page.model.Pager;
import com.xch.page.model.Student;
import com.xch.page.util.DB;
/**
 * 使用mysql数据库limit关键字实现分页
 * @author Paul
 *
 */
public class JdbcSqlStudentDaoImpl implements StudentDao {

	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = null;
		List<Object> paramList = new ArrayList<Object>();
		
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder("select * from t_student where 1=1");
		
		StringBuilder countSql = new StringBuilder("select count(*) as totalRecord from t_student where 1=1");
		
		
		if(stuName != null && !stuName.equals("")){
			sql.append(" and stu_name like ?");
			countSql.append(" and stu_name like ?");
			paramList.add("%"+stuName+"%");
		}
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE)
		{
			sql.append(" and gender = ?");
			countSql.append(" and gender = ?");
			paramList.add(gender);
		}
		//使用limit关键字，实现分页
		int fromIndex = pageSize * (pageNum - 1);
		sql.append(" limit "+fromIndex+","+pageSize);
		
		
		
		List<Student> studentList = new ArrayList<Student>();
		DB db = new DB();
		db.getConnection();
		try {
			//查询总记录条数
			List<Map<String,Object>> countResult = db.findResult(countSql.toString(), paramList);
			int totalRecord = ((Number)countResult.get(0).get("totalRecord")).intValue();
			
			List<Map<String,Object>> studentResult = db.findResult(sql.toString(), paramList);
			if(studentResult != null){
				for(Map<String,Object> map : studentResult){
					studentList.add(new Student(map));
				}
			}
			
			//总页数
			int totalPage = totalRecord/pageSize;
			if(totalRecord % pageSize != 0){
				totalPage += 1;
			}
			int currentPage;
			if(totalPage < pageNum){
				currentPage = totalPage;
			}else{
				currentPage = pageNum;
			}
			
			result = new Pager<Student>(pageSize, currentPage, totalRecord, totalPage, studentList);
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常",e);
		}finally{
			if(db != null){
				db.releaseConn();
			}
		}
		
		
		return result;
	}

}
