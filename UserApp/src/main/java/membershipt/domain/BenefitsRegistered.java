package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import membershipt.infra.AbstractEvent;

@Data
public class BenefitsRegistered extends AbstractEvent {

    private Long id;
    private String userId;
    private String agreementId;
    private Integer userPoint;
    private Integer agreePoint;
}
