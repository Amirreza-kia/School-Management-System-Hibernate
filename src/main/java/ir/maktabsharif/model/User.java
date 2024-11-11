package ir.maktabsharif.model;

import ir.maktabsharif.model.Embeddable.Address;
import ir.maktabsharif.model.enums.Gender;
import ir.maktabsharif.model.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
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
    @Embedded
    private Address address;
    //-------------------------
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
