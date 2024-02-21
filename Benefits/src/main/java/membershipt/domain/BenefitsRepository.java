package membershipt.domain;

import java.util.Date;
import java.util.List;
import membershipt.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "benefits", path = "benefits")
public interface BenefitsRepository
    extends PagingAndSortingRepository<Benefits, Long> {
    @Query(
        value = "select benefits " +
        "from Benefits benefits " +
        "where(:userId is null or benefits.userId like %:userId%) and (:agreementId is null or benefits.agreementId like %:agreementId%)"
    )
    List<Benefits> findByCheckBenefits(
        String userId,
        String agreementId,
        Pageable pageable
    );
}
