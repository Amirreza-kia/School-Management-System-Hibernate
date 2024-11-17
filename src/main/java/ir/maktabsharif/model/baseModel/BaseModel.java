package ir.maktabsharif.model.baseModel;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel<T extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    //-------------------------
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
