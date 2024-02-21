package membershipt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import membershipt.BenefitsApplication;
import membershipt.domain.BenefitsRegistered;

@Entity
@Table(name = "Benefits_table")
@Data
//<<< DDD / Aggregate Root
public class Benefits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String agreementId;

    private Integer userPoint;

    private Integer agreePoint;

    @PostPersist
    public void onPostPersist() {
        BenefitsRegistered benefitsRegistered = new BenefitsRegistered(this);
        benefitsRegistered.publishAfterCommit();
    }

    public static BenefitsRepository repository() {
        BenefitsRepository benefitsRepository = BenefitsApplication.applicationContext.getBean(
            BenefitsRepository.class
        );
        return benefitsRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pointDeduction(ApprovedToUsePoints approvedToUsePoints) {
        //implement business logic here:

        /** Example 1:  new item 
        Benefits benefits = new Benefits();
        repository().save(benefits);

        */

        /** Example 2:  finding and process
        
        repository().findById(approvedToUsePoints.get???()).ifPresent(benefits->{
            
            benefits // do something
            repository().save(benefits);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void earnPoints(CanceledUseOfPoints canceledUseOfPoints) {
        //implement business logic here:

        /** Example 1:  new item 
        Benefits benefits = new Benefits();
        repository().save(benefits);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceledUseOfPoints.get???()).ifPresent(benefits->{
            
            benefits // do something
            repository().save(benefits);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void modifyBenefits(ModifiedAgreement modifiedAgreement) {
        //implement business logic here:

        /** Example 1:  new item 
        Benefits benefits = new Benefits();
        repository().save(benefits);

        */

        /** Example 2:  finding and process
        
        repository().findById(modifiedAgreement.get???()).ifPresent(benefits->{
            
            benefits // do something
            repository().save(benefits);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void modifyBenefits(RegisteredAgreement registeredAgreement) {
        //implement business logic here:

        /** Example 1:  new item 
        Benefits benefits = new Benefits();
        repository().save(benefits);

        */

        /** Example 2:  finding and process
        
        repository().findById(registeredAgreement.get???()).ifPresent(benefits->{
            
            benefits // do something
            repository().save(benefits);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
