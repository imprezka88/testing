package pl.sda.testing.student;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class StudentRepositoryTest {
    private StudentRepository repository;
    private int studentId1 = 0;
    private Student student1 = new Student(studentId1);

    @Before
    public void setUp() throws Exception {
        repository = new StudentRepository();
    }

    @Test
    public void whenAddingStudent_shouldReturnTheSameStudent() throws Exception {
        //given

        repository.addStudent(student1);

        //when
        Student retrievedStudent = repository.getStudent(studentId1);

        //then
        Assertions.assertThat(retrievedStudent).isEqualTo(student1);
    }

    @Test
    public void whenAddingTwoStudents_shouldReturnThemById() throws Exception {
        //given
        int id2 = 1;
        Student student2 = new Student(id2);

        repository.addStudent(student1);
        repository.addStudent(student2);

        //when
        Student retrievedStudent1 = repository.getStudent(studentId1);
        Student retrievedStudent2 = repository.getStudent(id2);

        //then
        Assertions.assertThat(retrievedStudent1).isEqualTo(student1);
        Assertions.assertThat(retrievedStudent2).isEqualTo(student2);
    }

    @Test
    public void givenStudentIdRepository_whenDeletingStudent_shouldStudentBeDeleted() throws Exception {
        //given
        repository.addStudent(student1);

        //when
        repository.deleteStudent(studentId1);

        //then
        Assertions.assertThat(repository.getStudent(studentId1)).isNull();

    }
}
