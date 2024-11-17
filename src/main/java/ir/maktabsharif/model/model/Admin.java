package ir.maktabsharif.model.model;

import ir.maktabsharif.model.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin extends User {


    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.ADMIN;


}
