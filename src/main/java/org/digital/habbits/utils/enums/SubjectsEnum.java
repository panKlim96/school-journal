package org.digital.habbits.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SubjectsEnum {
    RUSSIAN("Russian"),
    MATHEMATICS("Mathematics"),
    CHEMISTRY("Chemistry"),
    BIOLOGY("Biology");

    private String subjectName;

    public static SubjectsEnum getEnumBySubjectsName(String subjectName) {
        return Arrays.stream(values())
                .filter(e -> e.subjectName.equals(subjectName))
                .findFirst().orElseThrow();
    }

}
