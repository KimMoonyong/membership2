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
public class BenefitsListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private BenefitsListRepository benefitsListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBenefitsRegistered_then_CREATE_1(
        @Payload BenefitsRegistered benefitsRegistered
    ) {
        try {
            if (!benefitsRegistered.validate()) return;

            // view 객체 생성
            BenefitsList benefitsList = new BenefitsList();
            // view 객체에 이벤트의 Value 를 set 함
            benefitsList.setUserId(benefitsRegistered.getUserId());
            benefitsList.setUserPoint(
                String.valueOf(benefitsRegistered.getUserPoint())
            );
            // view 레파지 토리에 save
            benefitsListRepository.save(benefitsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegisteredAgreement_then_UPDATE_1(
        @Payload RegisteredAgreement registeredAgreement
    ) {
        try {
            if (!registeredAgreement.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
