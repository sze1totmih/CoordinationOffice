package TM.CoordinationOffice.repository;

import TM.CoordinationOffice.model.Coordinator;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.*;

import java.awt.print.Pageable;

public interface ICoordinatorRepository extends CrudRepository<Coordinator, Long>{
    Page<Coordinator> findAll(Pageable page);
}
