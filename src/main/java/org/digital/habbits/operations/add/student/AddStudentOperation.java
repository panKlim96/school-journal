package org.digital.habbits.operations.add.student;

import org.digital.habbits.Student;
import org.digital.habbits.operations.Operation;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.FIO_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.MARKS_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.fillSubjectMarkMap;
import static org.digital.habbits.utils.SchoolJournalUtils.validateReadingOutput;


public class AddStudentOperation implements Operation<Void> {
    protected String studentFIO;
    protected String marks;

    @Override
    public Void execute(Scanner scanner) {
        readInfo(scanner);
        addStudent(
                createStudent(marks.split(" "), studentFIO.split(" "))
        );

        return null;
    }

    protected void readInfo(Scanner scanner) {
        studentFIO = validateReadingOutput(data -> !data.matches(FIO_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_fio", "wrong_fio"));
        marks = validateReadingOutput(data -> !data.matches(MARKS_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_marks", "wrong_marks"));
    }


    protected Student createStudent(String[] marks, String[] fio) {
        return new Student()
                .setLastname(fio[0])
                .setFirstname(fio[1])
                .setSurname(fio[2])
                .setSubjectMarkMap(fillSubjectMarkMap(marks));
    }

    protected void addStudent(Student student) {

    }

}
