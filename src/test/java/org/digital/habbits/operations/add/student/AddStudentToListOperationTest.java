package org.digital.habbits.operations.add.student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.digital.habbits.utils.enums.OperationsEnum.ADD_STUDENT_TO_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStudentToListOperationTest extends BaseTest {

    @BeforeAll
    static void before() {
        // почистить студентов перед запуском
        studentList.clear();
    }

    @Test
    void addStudentToListTest() throws IOException {
        assertEquals(0, studentList.size());
        Scanner scanner = new Scanner(new File("src/test/resources/operations/AddStudentOperation.txt"));
        operationService.findAndExecuteOperation(scanner, ADD_STUDENT_TO_LIST.getOperationName());
        assertEquals(1, studentList.size());
    }


}