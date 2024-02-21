package membershipt.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import membershipt.domain.*;
import membershipt.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CanceledUseOfPoints extends AbstractEvent {

    private Long id;
    private Integer usePoint;
    private String userId;
    private String agreementId;
    private Date useDate;
    private String usePointStatus;

    public CanceledUseOfPoints(Point aggregate) {
        super(aggregate);
    }

    public CanceledUseOfPoints() {
        super();
    }
}
//>>> DDD / Domain Event
