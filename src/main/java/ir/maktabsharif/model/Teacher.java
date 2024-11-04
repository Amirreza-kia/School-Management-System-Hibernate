package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher extends BaseModel {

    @Column(name = "first_name")
    private String firstName;
    //-------------------------
    @Column(name = "last_name")
    private String lastName;
    //-------------------------
    @Column(name = "national_code", unique = true)
    private String nationalCode;
    //-------------------------

    //Relation
    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;
}
