package com.beehood.student.system;

import java.util.HashMap;

import com.beehood.student.model.Student;

public class StudentSystem {

	private HashMap<Integer, Student> map = new HashMap<>();

	public void add(int id, String name, double marks) {

		map.put(id, new Student(id, name, marks));
		System.out.println("Student added.");
	}

	public boolean exists(int id) {
		return map.containsKey(id);
	}

	public void view() {

		if (map.isEmpty()) {
			System.out.println("No students found.");
			return;
		}

		for (Student s : map.values()) {
			System.out.println(s);
		}
	}

	public void search(int id) {

		Student s = map.get(id);

		if (s != null) {
			System.out.println("Found: " + s);
		} else {
			System.out.println("Student not found.");
		}
	}

	public void update(int id, String name, double marks) {

		Student s = map.get(id);

		if (s == null) {
			System.out.println("Student not found.");
			return;
		}

		s.setName(name);
		s.setMarks(marks);
		System.out.println("Updated successfully.");
	}

	public void delete(int id) {

		if (map.remove(id) != null) {
			System.out.println("Deleted successfully.");
		} else {
			System.out.println("Student not found.");
		}
	}

}