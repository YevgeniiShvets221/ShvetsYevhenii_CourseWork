package buem.pro.shvets_coursework.repository.studyPlan;

import buem.pro.shvets_coursework.module.StudyPlan;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudyPlanFakeRepository {
    private LocalDateTime now = LocalDateTime.now();

    private List<StudyPlan> studyPlans = new ArrayList<>(
            Arrays.asList(
            new StudyPlan("1","3","1","75",now,now),
            new StudyPlan("2","2","2","62",now,now),
            new StudyPlan("3","4","3","78",now,now),
            new StudyPlan("4","5","4","91",now,now),
            new StudyPlan("5","1","5","95",now,now)));

    public List<StudyPlan> findAll() {
        return this.studyPlans;
    }

    public StudyPlan findByID(String id) {
        return studyPlans.stream().filter(studyPlan -> studyPlan.getId().equals(id)).findFirst().orElse(null);
    }

    public StudyPlan update(StudyPlan studyPlan) {
        this.deleteById(studyPlan.getId());
        studyPlan.setUpdatedAt(LocalDateTime.now());
        this.studyPlans.add(studyPlan);
        return studyPlan;
    }

    public void deleteById(String id) {
        StudyPlan studyPlan = this.findByID(id);
        this.studyPlans.remove(studyPlan);
    }

    public StudyPlan save(StudyPlan studyPlan) {
        studyPlan.setId(UUID.randomUUID().toString());
        studyPlan.setCreatedAt(LocalDateTime.now());
        studyPlans.add(studyPlan);
        return studyPlan;
    }
}
