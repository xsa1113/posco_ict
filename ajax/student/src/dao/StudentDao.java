package dao;

import java.util.ArrayList;
import java.util.List;

import dto.StudentDto;

// DAO Data access Object
public class StudentDao {
	
	// singleton 패턴 
	// arraylist를 같이 사용
	private static StudentDao dao = null;
	public List<StudentDto> list = null;
	private StudentDao() {
		list = new ArrayList<StudentDto>();
	}
	
	public static StudentDao getInstance() {
		if(dao == null) {
			dao = new StudentDao();
		}
		return dao;
	}

}
