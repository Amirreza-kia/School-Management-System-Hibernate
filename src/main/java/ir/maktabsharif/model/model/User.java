package ir.maktabsharif.model.model;

import ir.maktabsharif.model.Embeddable.Address;
import ir.maktabsharif.model.baseModel.BaseModel;
import ir.maktabsharif.model.enums.Gender;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
@NamedQuery(name = "User.findByUsernameAndPassword",query = "SELECT u FROM User u WHERE userName = ?1 AND password = ?2")
public abstract class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    public String firstname;
    //-------------------------
    @Column(name = "last_name")
    public String lastname;
    //-------------------------
    // unique = true
    @Column(name = "national_code")
    private String nationalCode;

    @Column(unique = true)
    private String userName;

    private String password;
    //-------------------------
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //-------------------------

    //-------------------------
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
