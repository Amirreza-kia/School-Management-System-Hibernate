package ir.maktabsharif.model.model;

import ir.maktabsharif.model.baseModel.BaseModel;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "courses")
public class Course extends BaseModel {


    @Column(name = "course_title")
    private String title;

    private String unit;
    //relation
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();

}
