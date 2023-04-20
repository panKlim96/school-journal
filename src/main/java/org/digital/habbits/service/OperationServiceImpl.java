package org.digital.habbits.service;

import org.digital.habbits.operations.GetAllStudentsMarksOperation;
import org.digital.habbits.operations.GetStudentMarksOperation;
import org.digital.habbits.operations.LoadStudentsFromFileOperation;
import org.digital.habbits.operations.Operation;
import org.digital.habbits.operations.RemoveStudentOperation;
import org.digital.habbits.operations.UpdateMarkOperation;
import org.digital.habbits.operations.add.student.AddStudentToFileOperation;
import org.digital.habbits.operations.add.student.AddStudentToListOperation;
import org.digital.habbits.utils.enums.OperationsEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Objects.*;

public class OperationServiceImpl implements OperationService {
    private static OperationServiceImpl instance;

    private static final Map<String, Operation> operationMap;

    static {
        operationMap = new HashMap<>();
        operationMap.put(OperationsEnum.ADD_STUDENT_TO_LIST.getOperationName(), new AddStudentToListOperation());
        operationMap.put(OperationsEnum.ADD_STUDENT_TO_FILE.getOperationName(), new AddStudentToFileOperation());
        operationMap.put(OperationsEnum.GET_ALL_MARKS.getOperationName(), new GetAllStudentsMarksOperation());
        operationMap.put(OperationsEnum.GET_STUDENT_MARKS.getOperationName(), new GetStudentMarksOperation());
        operationMap.put(OperationsEnum.REMOVE_STUDENT.getOperationName(), new RemoveStudentOperation());
        operationMap.put(OperationsEnum.UPDATE_MARK.getOperationName(), new UpdateMarkOperation());
        operationMap.put(OperationsEnum.LOAD_STUDENTS_FROM_FILE.getOperationName(), new LoadStudentsFromFileOperation());
    }

    private OperationServiceImpl() {
    }
    public static OperationServiceImpl getInstance() {
        if (isNull(instance)) {
            return new OperationServiceImpl();
        }

        return instance;
    }

    @Override
    public void findAndExecuteOperation(Scanner scanner, String operationName) {
        operationMap.get(operationName).execute(scanner);
    }
}
