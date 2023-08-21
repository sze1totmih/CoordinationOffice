package TM.CoordinationOffice.repository;

import TM.CoordinationOffice.model.Coordinator;
import org.springframework.data.repository.*;

public interface ICoordinatorRepository extends CrudRepository<Coordinator, Long>{
}
