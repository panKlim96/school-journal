package org.digital.habbits.parsers;


import org.digital.habbits.Student;
import org.digital.habbits.utils.enums.SubjectsEnum;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static org.digital.habbits.utils.enums.SubjectsEnum.getEnumBySubjectsName;
import static org.digital.habbits.utils.enums.TagsEnum.FIRSTNAME;
import static org.digital.habbits.utils.enums.TagsEnum.LASTNAME;
import static org.digital.habbits.utils.enums.TagsEnum.MARK;
import static org.digital.habbits.utils.enums.TagsEnum.SUBJECTS_MARKS;
import static org.digital.habbits.utils.enums.TagsEnum.SUBJECT_NAME;
import static org.digital.habbits.utils.enums.TagsEnum.SURNAME;

public class JsonParser implements Parser<Student> {
    private static JsonParser instance;

    public static JsonParser getInstance() {
        if (Objects.isNull(instance)) {
            return new JsonParser();
        }

        return instance;
    }

    private JsonParser() {
    }

    @Override
    public List<Student> parse(String filePath) {
        List<Student> students = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                JSONObject studentObject = (JSONObject) parser.parse(fileScanner.nextLine());
                students.add(parseStudent(studentObject));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public void writeStudentToFile(Student student, String filePath) {
        JSONObject studentJsonObj = convertStudentToJson(student);
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(studentJsonObj.toJSONString());
            fileWriter.append('\n');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private JSONObject convertStudentToJson(Student student) {
        JSONObject studentJsonObj = new JSONObject();
        studentJsonObj.put(LASTNAME.getSubjectName(), student.getLastname());
        studentJsonObj.put(FIRSTNAME.getSubjectName(), student.getFirstname());
        studentJsonObj.put(SURNAME.getSubjectName(), student.getSurname());
        JSONArray subjectsMarksJsonArray = new JSONArray();
        for (Map.Entry<SubjectsEnum, Integer> entry : student.getSubjectMarkMap().entrySet()) {
            JSONObject subjectMarkJson = new JSONObject();
            subjectMarkJson.put(SUBJECT_NAME.getSubjectName(), entry.getKey().getSubjectName());
            subjectMarkJson.put(MARK.getSubjectName(), entry.getValue());
            subjectsMarksJsonArray.add(subjectMarkJson);
        }
        studentJsonObj.put(SUBJECTS_MARKS.getSubjectName(), subjectsMarksJsonArray);
        return studentJsonObj;
    }

    private Student parseStudent(JSONObject studentJson) {
        Student student = new Student().setLastname((String) studentJson.get(LASTNAME.getSubjectName()))
                .setFirstname((String) studentJson.get(FIRSTNAME.getSubjectName()))
                .setSurname((String) studentJson.get(SURNAME.getSubjectName()));
        Map<SubjectsEnum, Integer> subjectMarkMap = new LinkedHashMap<>();
        JSONArray subjectsMarksJsonArray = (JSONArray) studentJson.get(SUBJECTS_MARKS.getSubjectName());
        for (Object subjectMark : subjectsMarksJsonArray) {
            JSONObject subjectMarkJson = (JSONObject) subjectMark;
            long mark = (Long) subjectMarkJson.get(MARK.getSubjectName());
            subjectMarkMap.put(getEnumBySubjectsName((String) subjectMarkJson.get(SUBJECT_NAME.getSubjectName())),
                    (int) mark);
        }

        return student.setSubjectMarkMap(subjectMarkMap);
    }
}
