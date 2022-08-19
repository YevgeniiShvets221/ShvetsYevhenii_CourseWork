package buem.pro.shvets_coursework.repository.subjects;

import buem.pro.shvets_coursework.module.Subjects;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class SubjectsFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Subjects> subjects = new ArrayList<>(
            Arrays.asList(
            new Subjects( "1","WEB-design",
                    "60","45","30",now,now),
            new Subjects( "2","Artificial Intelligence",
                    "75","50","35",now,now),
            new Subjects( "3","Numerical methods",
                    "45","30","15",now,now),
            new Subjects( "4","Modern Databases",
                    "45","45","30",now,now),
            new Subjects( "5","Theory of algorithms",
                    "40","20","20",now,now)));
    public List<Subjects> findAll() {

        return this.subjects;
    }

    public Subjects findByID(String id) {
        return subjects.stream().filter(subjects -> subjects.getId().equals(id)).findFirst().orElse(null);
    }

    public Subjects update(Subjects subjects) {
        this.deleteById(subjects.getId());
        subjects.setUpdatedAt(LocalDateTime.now());
        this.subjects.add((Subjects) subjects);
        return (Subjects) subjects;
    }

    public void deleteById(String id) {
        Subjects subjects = this.findByID(id);
        this.subjects.remove(subjects);
    }

    public Subjects save(Subjects subjects) {
        subjects.setId(UUID.randomUUID().toString());
        subjects.setCreatedAt(LocalDateTime.now());
        subjects.add(subjects);
        return subjects;
    }
}

