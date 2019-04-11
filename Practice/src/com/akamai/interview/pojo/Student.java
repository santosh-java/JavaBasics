package com.akamai.interview.pojo;

import java.util.HashMap;
import java.util.Map;

public class Student {

	private int id;
	private String name;
	private int age;
	private Map<SubjectType, Integer> subjects;

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.subjects = new HashMap<SubjectType, Integer>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<SubjectType, Integer> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<SubjectType, Integer> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(SubjectType subject) {
		if (subject == null) {
			throw new IllegalArgumentException("Subject passed cannot be null!");
		}
		addSubject(subject, -1);
	}
	
	public void addSubject(SubjectType subject, int marks) {
		if (subject == null) {
			throw new IllegalArgumentException("Subject passed cannot be null!");
		}
		this.subjects.put(subject, marks);
	}
	
	public boolean deleteSubject(SubjectType subject) {
		if (subject == null) {
			throw new IllegalArgumentException("Subject passed cannot be null!");
		}
		boolean result = false;

		if (this.subjects.containsKey(subject)) {
			result = this.subjects.remove(subject) != null;
		} else {
			System.out.println("This student did not opt for " + subject);
		}
		return result;
	}

	public void setMarksForSubject(SubjectType subType, int marks) {
		if (this.subjects.containsKey(subType)) {
			this.subjects.put(subType, marks);
		} else {
			System.out.println("This student did not opt for " + subType);
		}
	}

	public int getMarksForSubject(SubjectType subType) {
		if (this.subjects.containsKey(subType)) {
			return this.subjects.get(subType);
		} else {
			System.out.println("This student did not opt for " + subType);
			return -1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", subjects=" + subjects + "]";
	}
}
