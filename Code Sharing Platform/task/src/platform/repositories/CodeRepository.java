package platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.models.Code;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
    Optional<Code> findByUuid(String uuid);
    List<Code> findTop10ByTimeRestrictionFalseAndViewsRestrictionFalseOrderByIdDesc();
}
