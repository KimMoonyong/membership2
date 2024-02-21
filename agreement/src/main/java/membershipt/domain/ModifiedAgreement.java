package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ModifiedAgreement extends AbstractEvent {

    private Long id;
    private String agreementName;
    private String agreementId;
    private Integer agreePoint;

    public ModifiedAgreement(Agreement aggregate) {
        super(aggregate);
    }

    public ModifiedAgreement() {
        super();
    }
}
//>>> DDD / Domain Event
