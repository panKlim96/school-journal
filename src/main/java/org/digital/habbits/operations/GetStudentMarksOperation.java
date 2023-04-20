package org.digital.habbits.operations;

import org.digital.habbits.Student;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.FIO_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.findStudentByFIO;
import static org.digital.habbits.utils.SchoolJournalUtils.printStudent;
import static org.digital.habbits.utils.SchoolJournalUtils.validateReadingOutput;

public class GetStudentMarksOperation implements Operation<Void> {
    @Override
    public Void execute(Scanner scanner) {
        String studentFIO = validateReadingOutput(data -> !data.matches(FIO_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_fio", "wrong_fio"));

        Student student = findStudentByFIO(studentFIO.split(" "));
        printStudent(student);
        return null;
    }


}
