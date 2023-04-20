package org.digital.habbits.operations;

import java.util.Objects;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.printStudent;
import static org.digital.habbits.utils.SchoolJournalUtils.studentList;

public class GetAllStudentsMarksOperation implements Operation<Void> {
    @Override
    public Void execute(Scanner scanner) {
        if (Objects.nonNull(studentList) && !studentList.isEmpty()) {
            studentList.stream().forEach(student -> printStudent(student));
        } else {
            System.out.println("student list is empty");
        }

        return null;
    }

}
