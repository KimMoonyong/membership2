package membershipt.domain;

import membershipt.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "agreements",
    path = "agreements"
)
public interface AgreementRepository
    extends PagingAndSortingRepository<Agreement, Long> {}
