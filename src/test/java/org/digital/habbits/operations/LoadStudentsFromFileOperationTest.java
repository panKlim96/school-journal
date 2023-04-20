package org.digital.habbits.operations;

import org.digital.habbits.operations.add.student.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.digital.habbits.utils.enums.OperationsEnum.LOAD_STUDENTS_FROM_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadStudentsFromFileOperationTest extends BaseTest {
    @BeforeAll
    static void before() {
        // почистить студентов перед запуском
        studentList.clear();
    }

    @Test
    void loadStudentsFromFileTest() throws IOException {
        assertEquals(studentList.size(), 0);
        Scanner scanner = new Scanner(new File("src/test/resources/operations/LoadStudentsFromFileOperation.txt"));
        operationService.findAndExecuteOperation(scanner, LOAD_STUDENTS_FROM_FILE.getOperationName());
        assertEquals(studentList.size(), 1);
    }
}