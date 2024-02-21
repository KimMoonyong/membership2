package membershipt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "PointUseHistory_table")
@Data
public class PointUseHistory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String agreementId;
    private Integer usePoint;
    private Date useDate;
    private String usePointStatus;
}
