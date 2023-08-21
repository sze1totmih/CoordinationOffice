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
        coordinatorRepository.save(coordinator);
    }

    public PagedList<Coordinator> getAllCoordinators(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging;
        if (sortBy!=null)
            paging = (Pageable) PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        else
            paging = (Pageable) PageRequest.of(pageNo, pageSize);
        Page<Coordinator> pageResult = coordinatorRepository.findAll(paging);
        PagedList<Coordinator> pagedList = new PagedList<Coordinator>();

        if (pageResult.hasContent()) {
            pagedList.setList(pageResult.getContent());
            pagedList.setCurrentPage(paging.getNumberOfPages());
            pagedList.setPageSize(pageSize);
            int numberOfPage=(int) Math.floor(coordinatorRepository.count()/pageSize)+1;
            pagedList.setNumberOfPage(numberOfPage);
            pagedList.setNumberOfItems(coordinatorRepository.count());
        }
        else {
            pagedList.setCurrentPage(paging.getNumberOfPages());
            pagedList.setPageSize(pageSize);
            pagedList.setNumberOfPage(0);
            pagedList.setNumberOfItems(coordinatorRepository.count());
        }
    }
}
