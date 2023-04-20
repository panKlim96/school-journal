package org.digital.habbits.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationsEnum {
    ADD_STUDENT_TO_LIST("add student to list"),
    ADD_STUDENT_TO_FILE("add student to file"),
    REMOVE_STUDENT("remove student"),
    UPDATE_MARK("update mark"),
    GET_ALL_MARKS("get all marks"),
    GET_STUDENT_MARKS("get student marks"),
    LOAD_STUDENTS_FROM_FILE("load students from file"),
    UPLOAD_STUDENTS_TO_FILE("upload students to file");

    private String operationName;
}
