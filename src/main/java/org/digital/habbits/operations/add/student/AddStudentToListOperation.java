package org.digital.habbits.operations.add.student;

import org.digital.habbits.Student;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;

public class AddStudentToListOperation extends AddStudentOperation {

    @Override
    protected void addStudent(Student student) {
        studentList.add(student);
    }
}
