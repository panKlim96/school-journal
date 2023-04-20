package org.digital.habbits.operations;

import org.digital.habbits.parsers.JsonParser;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;

public class LoadStudentsFromFileOperation implements Operation<Void> {
    JsonParser jsonParser = JsonParser.getInstance();

    @Override
    public Void execute(Scanner scanner) {
        System.out.println("enter file path");
        String filePath = scanner.nextLine();
        studentList.addAll(jsonParser.parse(filePath));

        return null;
    }

}
