package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import membershipt.infra.AbstractEvent;

@Data
public class RegisteredAgreement extends AbstractEvent {

    private Long id;
    private String agreementName;
    private String agreementId;
    private Integer agreePoint;
}
