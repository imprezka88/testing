package pl.sda.testing.student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<Integer, Student> studentId2Student = new HashMap<>();

    public void addStudent(Student student) {
        this.studentId2Student.put(student.getId(), student);
    }

    public Student getStudent(int id) {
        return this.studentId2Student.get(id);
    }

    public void deleteStudent(int id) {
        studentId2Student.remove(id);
    }
}
