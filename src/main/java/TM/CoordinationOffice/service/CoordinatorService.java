package TM.CoordinationOffice.service;

import TM.CoordinationOffice.model.Coordinator;
import TM.CoordinationOffice.repository.ICoordinatorRepository;
import TM.CoordinationOffice.service.impl.ICoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoordinatorService implements ICoordinatorService {

    @Autowired
    ICoordinatorRepository coordinatorRepository;

    @Override
    public List<Coordinator> getAllCoordinators() {
        List<Coordinator> coordinators = new ArrayList<Coordinator>();
        coordinatorRepository
        return null;
    }

    @Override
    public Coordinator getCoordinatorById(int id) {
        return null;
    }

    @Override
    public int saveOrUpdate(Coordinator coordinator) {
        return 0;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Coordinator coordinator, int id) {

    }
}
