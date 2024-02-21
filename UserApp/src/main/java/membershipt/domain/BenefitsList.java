package membershipt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "BenefitsList_table")
@Data
public class BenefitsList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String agreementId;
    private String userPoint;
    private String agreePoint;
    private String agreementName;
}
