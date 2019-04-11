package com.akamai.interview.pojo;

public class Subject {
	private SubjectType name;
	private int marks;

	public Subject(SubjectType name) {
		this.name = name;
	}

	public Subject(SubjectType name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public SubjectType getName() {
		return name;
	}

	public void setName(SubjectType name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Subject other = (Subject) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
