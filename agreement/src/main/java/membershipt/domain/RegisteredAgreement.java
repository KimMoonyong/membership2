package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RegisteredAgreement extends AbstractEvent {

    private Long id;
    private String agreementName;
    private String agreementId;
    private Integer agreePoint;

    public RegisteredAgreement(Agreement aggregate) {
        super(aggregate);
    }

    public RegisteredAgreement() {
        super();
    }
}
//>>> DDD / Domain Event
