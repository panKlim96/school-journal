package org.digital.habbits.operations;

import org.digital.habbits.operations.add.student.BaseTest;
import org.digital.habbits.utils.enums.SubjectsEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.digital.habbits.utils.enums.OperationsEnum.UPDATE_MARK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UpdateMarkOperationTest extends BaseTest {
    @BeforeAll
    static void before() throws FileNotFoundException {
        // почистить студентов перед запуском
        studentList.clear();
        studentList.addAll(jsonParser.parse("src/test/resources/files/students/student.txt"));
    }

    @Test
    void updateMarkTest() throws IOException {
        assertEquals(studentList.size(), 1);
        assertNotEquals(5, studentList.get(0).getSubjectMarkMap().get(SubjectsEnum.RUSSIAN));
        Scanner scanner = new Scanner(new File("src/test/resources/operations/UpdateMarkOperation.txt"));
        operationService.findAndExecuteOperation(scanner, UPDATE_MARK.getOperationName());
        assertEquals(5, studentList.get(0).getSubjectMarkMap().get(SubjectsEnum.RUSSIAN));
    }
}