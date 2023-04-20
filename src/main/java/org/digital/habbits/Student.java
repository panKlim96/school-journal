package org.digital.habbits;

import lombok.Data;
import lombok.experimental.Accessors;
import org.digital.habbits.utils.enums.SubjectsEnum;

import java.util.Map;

@Data
@Accessors(chain = true)
public class Student {
    private String firstname;
    private String lastname;
    private String surname;

    private Map<SubjectsEnum, Integer> subjectMarkMap;
}
