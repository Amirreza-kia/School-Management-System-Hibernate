package ir.maktabsharif.model.model;

import ir.maktabsharif.model.baseModel.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam extends BaseModel {


    @Column(name = "exam_title")
    private String examTitle;
    //-------------------------
    private Float score;
    //-------------------------
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exam_time")
    private Date examTime;
    //-------------------------

    //Relation
    @ManyToOne
    @JoinColumn(name = "fk_course")
    private Course course;
    //-------------------------
    @ManyToMany(mappedBy = "exams")
    private List<Student> students = new ArrayList<>();
}
