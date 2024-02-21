package membershipt.infra;

import membershipt.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AgreementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Agreement>> {

    @Override
    public EntityModel<Agreement> process(EntityModel<Agreement> model) {
        return model;
    }
}
