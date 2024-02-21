package membershipt.infra;

import java.util.List;
import membershipt.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "benefitsLists",
    path = "benefitsLists"
)
public interface BenefitsListRepository
    extends PagingAndSortingRepository<BenefitsList, Long> {}
