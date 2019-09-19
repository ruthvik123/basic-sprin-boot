package com.example.springData.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springData.POJO.student;

@Repository
public class studentJdbcDAO {

	public class StudentRowMapper implements RowMapper{

		@Override
		public student mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			student stud = new student();
			stud.setid(rs.getInt("id"));
			stud.setName(rs.getString("name"));
			return stud;
		}
		
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<student> findAllStudents() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
		// jdbcTemplate.query() returns a list
	}

	public student findById(int id) {

		return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] { id },
				new BeanPropertyRowMapper<student>(student.class)
				);
		// jdbcTemplate.queryForObject() returns a single object
	}
	
	public void AddStud(student Stud) {

		jdbcTemplate.update("insert into student (id, name) values (?, ?)",new Object[] {Stud.getid(),Stud.getName() });
		
	}
	
	

		
	}
	


