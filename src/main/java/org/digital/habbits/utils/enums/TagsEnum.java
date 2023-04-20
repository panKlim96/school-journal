package org.digital.habbits.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TagsEnum {
    STUDENTS("students"),
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    SURNAME("surname"),
    SUBJECTS_MARKS("subjectsMarks"),
    MARK("mark"),
    SUBJECT_NAME("subjectName");

    private String subjectName;
}
