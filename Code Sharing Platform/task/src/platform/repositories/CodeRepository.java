package platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.models.Code;

import java.util.List;

@Repository
public interface CodeRepository extends JpaRepository<Code, Integer> {
    List<Code> findTop10ByOrderByIdDesc();
}
