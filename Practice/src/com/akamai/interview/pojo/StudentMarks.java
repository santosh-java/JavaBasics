package com.akamai.interview.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMarks {
	private Map<SubjectType, List<Student>> mapSubjectStudent;

	public StudentMarks() {
		initMap();
	}

	private void initMap() {
		List<Student> englishStudents = new ArrayList<Student>();
		List<Student> historyStudents = new ArrayList<Student>();
		List<Student> mathsStudents = new ArrayList<Student>();
		mapSubjectStudent = new HashMap<>();
		mapSubjectStudent.put(SubjectType.ENGLISH, englishStudents);
		mapSubjectStudent.put(SubjectType.HISTORY, historyStudents);
		mapSubjectStudent.put(SubjectType.MATHEMATICS, mathsStudents);
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>(5);
		Student s1 = new Student(10, "A", 20);
		s1.addSubject(SubjectType.ENGLISH, 6);
		s1.addSubject(SubjectType.HISTORY, 7);
		Student s2 = new Student(11, "B", 21);
		s2.addSubject(SubjectType.ENGLISH, 4);
		s2.addSubject(SubjectType.MATHEMATICS, 8);
		Student s3 = new Student(12, "C", 22);
		s3.addSubject(SubjectType.ENGLISH, 7);
		s3.addSubject(SubjectType.HISTORY, 5);
		s3.addSubject(SubjectType.MATHEMATICS, 9);
		Student s4 = new Student(13, "D", 23);
		s4.addSubject(SubjectType.HISTORY, 8);
		s4.addSubject(SubjectType.MATHEMATICS, 9);
		Student s5 = new Student(14, "E", 24);
		s5.addSubject(SubjectType.ENGLISH, 7);
		s5.addSubject(SubjectType.HISTORY, 7);
		s5.addSubject(SubjectType.MATHEMATICS, 7);

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

		StudentMarks sm = new StudentMarks();
		sm.processInputAndFillMap(students, 6);
		List<Student> englishWith8OrMore = sm.findStudentsWithMarksInSubject(SubjectType.ENGLISH);
		System.out.println("Students having ENGLISH marks " + 6);
		englishWith8OrMore.stream().forEach(System.out::println);
		List<Student> historyWith8OrMore = sm.findStudentsWithMarksInSubject(SubjectType.HISTORY);
		System.out.println("Students having HISTORY marks " + 6);
		historyWith8OrMore.stream().forEach(System.out::println);
		List<Student> mathsWithMore = sm.findStudentsWithMarksInSubject(SubjectType.MATHEMATICS);
		System.out.println("Students having MATHEMATICS marks " + 6);
		mathsWithMore.stream().forEach(System.out::println);
		System.out.println("====================");

		sm.processInputAndFillMap(students, 8);
		englishWith8OrMore = sm.findStudentsWithMarksInSubject(SubjectType.ENGLISH);
		System.out.println("Students having ENGLISH marks " + 8);
		englishWith8OrMore.stream().forEach(System.out::println);
		historyWith8OrMore = sm.findStudentsWithMarksInSubject(SubjectType.HISTORY);
		System.out.println("Students having HISTORY marks " + 8);
		historyWith8OrMore.stream().forEach(System.out::println);
		mathsWithMore = sm.findStudentsWithMarksInSubject(SubjectType.MATHEMATICS);
		System.out.println("Students having MATHEMATICS marks " + 8);
		mathsWithMore.stream().forEach(System.out::println);
		System.out.println("====================");
	}

	public List<Student> findStudentsWithMarksInSubject(SubjectType subject) {
		return mapSubjectStudent.get(subject);
	}

	private void processInputAndFillMap(List<Student> students, int marks) {
		initMap();
		for (Student s : students) {
			addStudentToMap(mapSubjectStudent, marks, s);
		}
	}

	private void addStudentToMap(Map<SubjectType, List<Student>> mapSubjectStudent, int marks, Student s) {
		if (s.getMarksForSubject(SubjectType.ENGLISH) >= marks) {
			mapSubjectStudent.get(SubjectType.ENGLISH).add(s);
		}
		if (s.getMarksForSubject(SubjectType.HISTORY) >= marks) {
			mapSubjectStudent.get(SubjectType.HISTORY).add(s);
		}
		if (s.getMarksForSubject(SubjectType.MATHEMATICS) >= marks) {
			mapSubjectStudent.get(SubjectType.MATHEMATICS).add(s);
		}
	}

	public static boolean isStudentOptedSubject(Student s, SubjectType sub) {
		return s.getMarksForSubject(sub) > -1;
	}

}
