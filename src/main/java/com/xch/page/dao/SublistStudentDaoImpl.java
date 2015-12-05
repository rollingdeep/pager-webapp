package com.xch.page.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xch.page.Constant;
import com.xch.page.model.Pager;
import com.xch.page.model.Student;
import com.xch.page.util.DB;

public class SublistStudentDaoImpl implements StudentDao {

	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		List<Student> allStudentList = getAllStudent(searchModel);
		//Pager(int pageNum,int pageSize, List<T> source)
		Pager<Student> pager = new Pager<Student>(pageNum,pageSize,allStudentList);
		return pager;
	}
	/**
	 * 模仿获取所有参数
	 * @return 查询结果
	 */
	private List<Student> getAllStudent(Student searchModel){
		List<Student> result = new ArrayList<Student>();
		List<Object> paramList = new ArrayList<Object>();
		
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder("select * from t_student where 1=1");
		
		if(stuName != null && !stuName.equals("")){
			sql.append(" and stu_name like ?");
			paramList.add("%"+stuName+"%");
		}
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE)
		{
			sql.append(" and gender = ?");
			paramList.add(gender);
		}
		DB db = new DB();
		db.getConnection();
		try {
			List<Map<String,Object>> mapList = db.findResult(sql.toString(), paramList);
			if(mapList != null){
				for(Map<String,Object> map : mapList){
					result.add(new Student(map));
				}
			}
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
