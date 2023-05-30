package fr.example.demo.bo;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
	
	Person teacher;
	List<Person> students;
	
	public Classroom(){
		students = new ArrayList<Person>();
	}
	
	/**
	 * @return the teacher
	 */
	public Person getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Person teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the students
	 */
	public List<Person> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Person> students) {
		this.students = students;
	}

}
