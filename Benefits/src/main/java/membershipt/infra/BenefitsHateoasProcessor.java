package membershipt.infra;

import membershipt.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BenefitsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Benefits>> {

    @Override
    public EntityModel<Benefits> process(EntityModel<Benefits> model) {
        return model;
    }
}
