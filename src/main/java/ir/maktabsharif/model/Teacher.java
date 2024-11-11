package ir.maktabsharif.model;

import ir.maktabsharif.model.Embeddable.Address;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Teacher extends User {
    //برای جلو گیری از تکرار کد ها از یک کلاس دیگه استفاده کردیم
    //Relation
    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;
}
