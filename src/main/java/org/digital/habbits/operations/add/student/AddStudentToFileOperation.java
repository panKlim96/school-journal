package org.digital.habbits.operations.add.student;

import org.digital.habbits.Student;
import org.digital.habbits.parsers.JsonParser;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.validateReadingOutput;

public class AddStudentToFileOperation extends AddStudentOperation {
    private String filePath;
    JsonParser jsonParser = JsonParser.getInstance();

    @Override
    protected void readInfo(Scanner scanner) {
        super.readInfo(scanner);
        filePath = validateReadingOutput(data -> data.isEmpty(), consoleReader,
                reader -> reader.readFromConsole(scanner, "enter_file_path", "wrong_file_path"));

    }

    @Override
    protected void addStudent(Student student) {
        jsonParser.writeStudentToFile(student, filePath);
    }
}
