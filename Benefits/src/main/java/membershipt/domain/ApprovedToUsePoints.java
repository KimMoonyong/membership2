package membershipt.domain;

import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

@Data
@ToString
public class ApprovedToUsePoints extends AbstractEvent {

    private Long id;
    private Integer usePoint;
    private String userId;
    private String agreementId;
    private Date useDate;
    private String usePointStatus;
}
