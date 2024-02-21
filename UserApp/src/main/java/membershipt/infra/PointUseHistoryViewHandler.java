package membershipt.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import membershipt.config.kafka.KafkaProcessor;
import membershipt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PointUseHistoryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PointUseHistoryRepository pointUseHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenApprovedToUsePoints_then_CREATE_1(
        @Payload ApprovedToUsePoints approvedToUsePoints
    ) {
        try {
            if (!approvedToUsePoints.validate()) return;

            // view 객체 생성
            PointUseHistory pointUseHistory = new PointUseHistory();
            // view 객체에 이벤트의 Value 를 set 함
            pointUseHistory.setUserId(approvedToUsePoints.getUserId());
            pointUseHistory.setAgreementId(
                approvedToUsePoints.getAgreementId()
            );
            pointUseHistory.setUsePoint(approvedToUsePoints.getUserPoint());
            pointUseHistory.setUseDate(approvedToUsePoints.getUseDate());
            pointUseHistory.setUsePointStatus(
                approvedToUsePoints.getUsePointStatus()
            );
            // view 레파지 토리에 save
            pointUseHistoryRepository.save(pointUseHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceledUseOfPoints_then_CREATE_2(
        @Payload CanceledUseOfPoints canceledUseOfPoints
    ) {
        try {
            if (!canceledUseOfPoints.validate()) return;

            // view 객체 생성
            PointUseHistory pointUseHistory = new PointUseHistory();
            // view 객체에 이벤트의 Value 를 set 함
            pointUseHistory.setUserId(canceledUseOfPoints.getUserId());
            pointUseHistory.setAgreementId(
                canceledUseOfPoints.getAgreementId()
            );
            pointUseHistory.setUsePoint(canceledUseOfPoints.getUsePoint());
            pointUseHistory.setUseDate(canceledUseOfPoints.getUseDate());
            pointUseHistory.setUsePointStatus(
                canceledUseOfPoints.getUsePointStatus()
            );
            // view 레파지 토리에 save
            pointUseHistoryRepository.save(pointUseHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
