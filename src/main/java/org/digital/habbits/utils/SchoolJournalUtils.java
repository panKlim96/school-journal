package org.digital.habbits.utils;

import org.digital.habbits.Student;
import org.digital.habbits.reader.Reader;
import org.digital.habbits.utils.enums.SubjectsEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.function.Function;
import java.util.function.Predicate;

public class SchoolJournalUtils {
    public static List<Student> studentList = new ArrayList<>();
    public static PropertyResourceBundle messagesBundle;

    public static final String FIO_PATTERN = "[a-zA-Z]{2,20}\\s{1}[a-zA-Z]{2,20}\\s{1}[a-zA-Z]{2,20}$";
    public static final String MARKS_PATTERN = "[1-5]\\s[1-5]\\s[1-5]\\s[1-5]";
    public static final String ONE_MARK_PATTERN = "[1-5]{1}$";

    static {
        try {
            messagesBundle = new PropertyResourceBundle(new FileInputStream(new File("src/main/resources/messages.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<SubjectsEnum, Integer> fillSubjectMarkMap(String[] marks) {
        Map<SubjectsEnum, Integer> subjectsMarkMap = new LinkedHashMap<>();
        subjectsMarkMap.put(SubjectsEnum.RUSSIAN, Integer.valueOf(marks[0]));
        subjectsMarkMap.put(SubjectsEnum.MATHEMATICS, Integer.valueOf(marks[1]));
        subjectsMarkMap.put(SubjectsEnum.CHEMISTRY, Integer.valueOf(marks[2]));
        subjectsMarkMap.put(SubjectsEnum.BIOLOGY, Integer.valueOf(marks[3]));

        return subjectsMarkMap;
    }

    public static boolean FIOCheck(Student student, String[] fio) {
        return student.getLastname().equals(fio[0])
                && student.getFirstname().equals(fio[1])
                && student.getSurname().equals(fio[2]);
    }

    public static Student findStudentByFIO(String[] fio) {
        return studentList.stream().filter(student -> FIOCheck(student, fio)).findFirst().orElseThrow();
    }

    public static void printStudent(Student student) {
        System.out.println(student.toString());
    }

    public static String validateReadingOutput(Predicate<String> validationNegativeCondition, Reader reader, Function<Reader, String> function) {
        String inputString = "";
        while (validationNegativeCondition.test(inputString)) {
            inputString = function.apply(reader);
        }

        return inputString;
    }


}
