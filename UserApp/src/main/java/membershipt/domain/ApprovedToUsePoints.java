package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import membershipt.infra.AbstractEvent;

@Data
public class ApprovedToUsePoints extends AbstractEvent {

    private Long id;
    private Integer usePoint;
    private String userId;
    private String agreementId;
    private Date useDate;
    private String usePointStatus;
}
