package membershipt.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import membershipt.config.kafka.KafkaProcessor;
import membershipt.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    BenefitsRepository benefitsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApprovedToUsePoints'"
    )
    public void wheneverApprovedToUsePoints_PointDeduction(
        @Payload ApprovedToUsePoints approvedToUsePoints
    ) {
        ApprovedToUsePoints event = approvedToUsePoints;
        System.out.println(
            "\n\n##### listener PointDeduction : " +
            approvedToUsePoints +
            "\n\n"
        );

        // Sample Logic //
        Benefits.pointDeduction(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CanceledUseOfPoints'"
    )
    public void wheneverCanceledUseOfPoints_EarnPoints(
        @Payload CanceledUseOfPoints canceledUseOfPoints
    ) {
        CanceledUseOfPoints event = canceledUseOfPoints;
        System.out.println(
            "\n\n##### listener EarnPoints : " + canceledUseOfPoints + "\n\n"
        );

        // Sample Logic //
        Benefits.earnPoints(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ModifiedAgreement'"
    )
    public void wheneverModifiedAgreement_ModifyBenefits(
        @Payload ModifiedAgreement modifiedAgreement
    ) {
        ModifiedAgreement event = modifiedAgreement;
        System.out.println(
            "\n\n##### listener ModifyBenefits : " + modifiedAgreement + "\n\n"
        );

        // Sample Logic //
        Benefits.modifyBenefits(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RegisteredAgreement'"
    )
    public void wheneverRegisteredAgreement_ModifyBenefits(
        @Payload RegisteredAgreement registeredAgreement
    ) {
        RegisteredAgreement event = registeredAgreement;
        System.out.println(
            "\n\n##### listener ModifyBenefits : " +
            registeredAgreement +
            "\n\n"
        );

        // Sample Logic //
        Benefits.modifyBenefits(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
