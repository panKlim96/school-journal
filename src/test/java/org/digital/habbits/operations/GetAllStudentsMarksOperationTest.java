package org.digital.habbits.operations;

import org.digital.habbits.operations.add.student.BaseTest;
import org.digital.habbits.utils.enums.SubjectsEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.digital.habbits.utils.SchoolJournalUtils.studentList;
import static org.digital.habbits.utils.enums.OperationsEnum.GET_ALL_MARKS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GetAllStudentsMarksOperationTest extends BaseTest {
    @BeforeAll
    static void before() {
        // почистить студентов перед запуском
        studentList.clear();
        studentList.addAll(jsonParser.parse("src/test/resources/files/students/students.txt"));
    }

    @Test
    void getStudentMarksTest() {
        assertEquals(studentList.size(), 3);
        assertNotEquals(5, studentList.get(0).getSubjectMarkMap().get(SubjectsEnum.RUSSIAN));
        Scanner scanner = new Scanner(System.in);
        operationService.findAndExecuteOperation(scanner, GET_ALL_MARKS.getOperationName());
        // check console output
    }
}