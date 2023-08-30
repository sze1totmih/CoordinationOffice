package TM.CoordinationOffice.controller;

import TM.CoordinationOffice.model.Coordinator;
import TM.CoordinationOffice.model.PagedList;
import TM.CoordinationOffice.model.QueryStringParameter;
import TM.CoordinationOffice.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", name = "Coordinator API controller")
public class CoordinatorAPIController {
    @Autowired
    CoordinatorService service;

    //localhost:8888/api/coordinator/
    @GetMapping(value = "/coordinator",name = "Get all coordinators")
    public List<Coordinator> getAllCoordinators() {
        return service.getAllCoordinators();
    }

    @PostMapping(value = "/Coordinator/getpaged")
    public PagedList<Coordinator> GetPaged(@RequestBody QueryStringParameter parameters) {
        int currentPage = parameters.getCurrentPage();
        if (currentPage<0) {
            currentPage=0;
        }
        int pageSize = parameters.getPageSize();
        if (pageSize<=0) {
            pageSize=1;
        }

        PagedList<Coordinator> pageCoordinator=service.GetPaged(currentPage,pageSize);
        return pageCoordinator;
    }

    //localhost:8888/api/coordinator/
    @PostMapping(value = "/coordinator", name="Save coordinator")
    public void saveCoordinator(@RequestBody Coordinator coordinator) {
        service.saveOrUpdate(coordinator);
    }

    //localhost:8888/api/coordinator/
    @PutMapping(value="/coordinator",name="Update coordinator")
    public void updateCoordinator(@RequestBody Coordinator coordinator) {
        service.saveOrUpdate(coordinator);
    }

    //localhost:8888/api/coordinator/1
    @DeleteMapping(value = "/coordinator/{coordinatorId}",name="Delete coordinator")
    public void deleteCoordinator(@PathVariable long coordincoordinatorId) {
        service.deleteById(coordincoordinatorId);
    }
}
