package TM.CoordinationOffice.service;

import TM.CoordinationOffice.model.Coordinator;
import TM.CoordinationOffice.model.PagedList;
import TM.CoordinationOffice.repository.ICoordinatorRepository;
import TM.CoordinationOffice.service.impl.ICoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.awt.print.Pageable;
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
    public Coordinator getCoordinatorById(long coordinatorId) {
        Optional<Coordinator> coordinators = coordinatorRepository.findById(coordinatorId);
        if (coordinators.isPresent())
            return coordinators.get();
        else {
            return null;
        }
    }

    @Override
    public long saveOrUpdate(Coordinator coordinator) {
        coordinatorRepository.save(coordinator);
        return coordinator.getCoordinatorId();
    }

    @Override
    public void deleteById(long coordinatorId) {
        Optional<Coordinator> coordinators =coordinatorRepository.findById(coordinatorId);
        if (coordinators.isPresent())
            coordinatorRepository.deleteById(coordinatorId);
    }

    @Override
    public void update(Coordinator coordinator, long coordinatorId) {
        coordinatorRepository.save(coordinator);
    }

    public PagedList<Coordinator> GetPaged(int currentPage, int pageSize) {
        Pageable page = (Pageable) PageRequest.of(currentPage,pageSize);
        Page<Coordinator> pageCoordinator=coordinatorRepository.findAll(page);
        PagedList<Coordinator> pagedList = new PagedList<>();
        if (pageCoordinator.hasContent()) {
            pagedList.setCurrentPage(page.getNumberOfPages());
            pagedList.setPageSize(page.getNumberOfPages());
            pagedList.setNumberOfItems(coordinatorRepository.count());
            int numberOfPage=(int) Math.floor(coordinatorRepository.count()/pageSize)+1;
            pagedList.setNumberOfPage(numberOfPage);
            pagedList.setItems(pageCoordinator.getContent());
            return pagedList;
        } else {
            return null;
        }
    }
}
