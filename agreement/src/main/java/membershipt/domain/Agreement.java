package membershipt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import membershipt.AgreementApplication;
import membershipt.domain.ModifiedAgreement;
import membershipt.domain.RegisteredAgreement;

@Entity
@Table(name = "Agreement_table")
@Data
//<<< DDD / Aggregate Root
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String agreementName;

    private String agreementId;

    private Integer agreePoint;

    @PostPersist
    public void onPostPersist() {
        RegisteredAgreement registeredAgreement = new RegisteredAgreement(this);
        registeredAgreement.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ModifiedAgreement modifiedAgreement = new ModifiedAgreement(this);
        modifiedAgreement.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static AgreementRepository repository() {
        AgreementRepository agreementRepository = AgreementApplication.applicationContext.getBean(
            AgreementRepository.class
        );
        return agreementRepository;
    }
}
//>>> DDD / Aggregate Root
