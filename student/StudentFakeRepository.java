package buem.pro.shvets_coursework.repository.student;

import buem.pro.shvets_coursework.module.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
            new Student("1", "Shvets", "Yevhenii",
                    "Valeriyovich", "Shevchenko street",
                    "0673390600", now, now),
            new Student("2", "Pavlov", "Petro",
                    "Maksymovych", "Segedskaya street",
                    "0673485732", now, now),
            new Student("3", "Potapova", "Alyona",
                    "Oleksandrivna", "Bocharova street",
                    "0502345824", now, now),
            new Student("4", "Panova", "Hanna",
                    "Olehivna", "Pushkina avenue",
                    "0934121190", now, now),
            new Student("5", "Avanesyan", "Karim",
                    "Hrantovich", "Kamanina street",
                    "0934852340", now, now)));

    public List<Student> findAll() {
        return this.students;
    }

    public Student findByID(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    public Student update(Student student) {
        this.deleteById(student.getId());
        student.setUpdatedAt(LocalDateTime.now());
        this.students.add(student);
        return student;
    }

    public void deleteById(String id) {
        Student student = this.findByID(id);
        this.students.remove(student);
    }

    public Student save(Student student) {
        student.setId(UUID.randomUUID().toString());
        student.setCreatedAt(LocalDateTime.now());
        students.add(student);
        return student;
    }
}


