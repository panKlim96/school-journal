package org.digital.habbits.operations.add.student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.digital.habbits.utils.enums.OperationsEnum.ADD_STUDENT_TO_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStudentToFileOperationTest extends BaseTest {

    @BeforeAll
    static void before() throws FileNotFoundException {
        // почистить файл перед запуском
        PrintWriter printWriter = new PrintWriter(new File("src/test/resources/files/loadDataToFile.txt"));
        printWriter.println("");
    }

    @Test
    void addStudentToFileTest() throws IOException {
        Scanner scanner = new Scanner(new File("src/test/resources/operations/AddStudentOperation.txt"));
        operationService.findAndExecuteOperation(scanner, ADD_STUDENT_TO_FILE.getOperationName());

        Scanner result = new Scanner(new File("src/test/resources/files/loadDataToFile.txt"));
        Scanner expectedResult = new Scanner(new File("src/test/resources/files/loadDataToFile_expected.txt"));
        assertEquals(expectedResult.nextLine(), result.nextLine());
    }
}