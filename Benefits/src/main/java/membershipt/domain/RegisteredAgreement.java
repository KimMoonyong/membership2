package membershipt.domain;

import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

@Data
@ToString
public class RegisteredAgreement extends AbstractEvent {

    private Long id;
    private String agreementName;
    private String agreementId;
    private Integer agreePoint;
}
