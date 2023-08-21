package TM.CoordinationOffice.service;

import TM.CoordinationOffice.model.Coordinator;
import TM.CoordinationOffice.repository.ICoordinatorRepository;
import TM.CoordinationOffice.service.impl.ICoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoordinatorService implements ICoordinatorService {

    @Autowired
    ICoordinatorRepository coordinatorRepository;

    @Override
    public List<Coordinator> getAllCoordinators() {
        List<Coordinator> coordinators = new ArrayList<Coordinator>();
        coordinatorRepository.findAll().forEach(coordinator -> coordinators.add(coordinator));
        return coordinators;
    }

    @Override
    public Coordinator getCoordinatorById(long id) {
        Optional<Coordinator> coordinators = coordinatorRepository.findById(id);
        if (coordinators.isPresent())
            return coordinators.get();
        else {
            return null;
        }
    }

    @Override
    public int saveOrUpdate(Coordinator coordinator) {
        coordinatorRepository.save(coordinator);
        return coordinator.getId();
    }

    @Override
    public void deleteById(long id) {
        Optional<Coordinator> coordinators =coordinatorRepository.findById(id);
        if (coordinators.isPresent())
            coordinatorRepository.deleteById(id);
    }

    @Override
    public void update(Coordinator coordinator, long id) {

    }
}
