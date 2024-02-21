package membershipt.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import membershipt.PointApplication;
import membershipt.domain.ApprovedToUsePoints;
import membershipt.domain.CanceledUseOfPoints;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer usePoint;

    private String userId;

    private String agreementId;

    private Date useDate;

    private String usePointStatus;

    @PostPersist
    public void onPostPersist() {
        ApprovedToUsePoints approvedToUsePoints = new ApprovedToUsePoints(this);
        approvedToUsePoints.publishAfterCommit();

        CanceledUseOfPoints canceledUseOfPoints = new CanceledUseOfPoints(this);
        canceledUseOfPoints.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }
}
//>>> DDD / Aggregate Root
