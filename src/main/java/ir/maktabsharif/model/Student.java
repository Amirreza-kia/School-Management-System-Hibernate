package ir.maktabsharif.model;


import ir.maktabsharif.model.Embeddable.Address;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@ToString

//اسم کلاس student داخل کوری قرار می گیرد
@NamedQuery(name = "Student.findByFirstname",query = "select s from Student s where firstname = ?1")
//"from Student WHERE firstname = ?1 "
public class Student extends User {

    //Relation
    @ManyToMany
    //با جوین تیبل ها اسم جانکشن تیبل هارا تغییر می دهیم
    @JoinTable(
            name = "j_student_course"
            , joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private List<Course> courses = new ArrayList<>();
    //-------------------------
    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student")
            }
            ,inverseJoinColumns = {@JoinColumn(name = "fk_exam")}
    )
    private List<Exam> exams = new ArrayList<>();





}
