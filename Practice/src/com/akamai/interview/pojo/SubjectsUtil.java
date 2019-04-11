package com.akamai.interview.pojo;

import java.util.Set;

public class SubjectsUtil {
	private static SubjectsUtil INSTANCE = new SubjectsUtil();

	private SubjectsUtil() {

	}

	public void setMarksForSubject(Set<Subject> subjects, int marksForSubject, SubjectType subType) {
		subjects.stream().filter((s) -> s.getName().equals(subType)).forEach((s) -> s.setMarks(marksForSubject));
	}

	public static SubjectsUtil getInstance() {
		return INSTANCE;
	}
}
