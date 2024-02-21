package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BenefitsRegistered extends AbstractEvent {

    private Long id;
    private String userId;
    private String agreementId;
    private Integer userPoint;
    private Integer agreePoint;

    public BenefitsRegistered(Benefits aggregate) {
        super(aggregate);
    }

    public BenefitsRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
