package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ApprovedToUsePoints extends AbstractEvent {

    private Long id;
    private Integer usePoint;
    private String userId;
    private String agreementId;
    private Date useDate;
    private String usePointStatus;

    public ApprovedToUsePoints(Point aggregate) {
        super(aggregate);
    }

    public ApprovedToUsePoints() {
        super();
    }
}
//>>> DDD / Domain Event
