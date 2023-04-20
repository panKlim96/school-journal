package org.digital.habbits.operations;

import org.digital.habbits.Student;
import org.digital.habbits.utils.enums.SubjectsEnum;

import java.util.Arrays;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.FIO_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.ONE_MARK_PATTERN;
import static org.digital.habbits.utils.SchoolJournalUtils.findStudentByFIO;
import static org.digital.habbits.utils.SchoolJournalUtils.validateReadingOutput;


public class UpdateMarkOperation implements Operation<Void> {

    @Override
    public Void execute(Scanner scanner) {
        String studentFIO = validateReadingOutput(data -> !data.matches(FIO_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_fio", "wrong_fio"));

        String newMark = validateReadingOutput(data -> !data.matches(ONE_MARK_PATTERN), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_mark", ""));

        String subjectName = validateReadingOutput(data -> !Arrays
                        .stream(SubjectsEnum.values())
                        .anyMatch(e -> e.getSubjectName().equals(data)),
                consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_mark", ""));
        updateStudentMark(Integer.valueOf(newMark), subjectName, studentFIO.split(" "));

        return null;
    }

    private void updateStudentMark(Integer newMark, String subjectName, String[] fio) {
        Student studentForUpdate = findStudentByFIO(fio);
        studentForUpdate.getSubjectMarkMap()
                .entrySet()
                .stream()
                .filter(e ->
                        e.getKey().getSubjectName().equals(subjectName))
                .forEach(e -> e.setValue(newMark));
    }
}
