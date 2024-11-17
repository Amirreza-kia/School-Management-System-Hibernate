package ir.maktabsharif.model.model;

import ir.maktabsharif.model.Embeddable.Address;
import ir.maktabsharif.model.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teacher extends User {



    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.TEACHER;
    //برای جلو گیری از تکرار کد ها از یک کلاس دیگه استفاده کردیم
    //Relation
    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @ElementCollection
    private List<Address> address = new ArrayList<>();
}
