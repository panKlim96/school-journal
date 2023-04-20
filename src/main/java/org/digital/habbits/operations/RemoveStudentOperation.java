package org.digital.habbits.operations;

import org.digital.habbits.Student;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.FIOCheck;
import static org.digital.habbits.utils.SchoolJournalUtils.FIO_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.digital.habbits.utils.SchoolJournalUtils.validateReadingOutput;

public class RemoveStudentOperation implements Operation<Void> {

    @Override
    public Void execute(Scanner scanner) {
        String studentFIO = validateReadingOutput(data -> !data.matches(FIO_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_fio", "wrong_fio"));

        removeStudentFromList(studentFIO.split(" "));

        return null;
    }

    private void removeStudentFromList(String[] fio) {
        Student studentForRemove = studentList.stream().filter(student -> FIOCheck(student, fio)).findFirst().orElseThrow();
        studentList.remove(studentForRemove);
    }
}
