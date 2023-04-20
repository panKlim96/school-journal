package org.digital.habbits.operations;

import org.digital.habbits.operations.add.student.BaseTest;
import org.digital.habbits.utils.enums.OperationsEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveStudentOperationTest extends BaseTest {
    @BeforeAll
    static void before() {
        // почистить студентов перед запуском
        studentList.clear();
        studentList.addAll(jsonParser.parse("src/test/resources/files/students/student.txt"));
    }

    @Test
    void removeStudentFromFileTest() throws IOException {
        assertEquals(studentList.size(), 1);
        Scanner scanner = new Scanner(new File("src/test/resources/operations/RemoveStudentOperation.txt"));
        operationService.findAndExecuteOperation(scanner, OperationsEnum.REMOVE_STUDENT.getOperationName());
        assertEquals(studentList.size(), 0);
    }
}