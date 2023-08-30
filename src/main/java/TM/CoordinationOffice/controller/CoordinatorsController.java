package TM.CoordinationOffice.controller;

import TM.CoordinationOffice.model.Coordinator;
import TM.CoordinationOffice.service.CoordinatorService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CoordinatorsController {

    @Autowired
    private CoordinatorService coordinatorService;

    @GetMapping("/coordinator/index")
    public ModelAndView showCoordinatorList()
    {
        List<Coordinator> coordinators = coordinatorService.getAllCoordinators();
        ModelAndView mav=new ModelAndView();
        mav.addObject("coordinators",coordinators);
        mav.setViewName("th/coordinators/index");
        return mav;
    }

    @GetMapping ("/coordinator/signup")
    public ModelAndView showSingUpForm(){
        Coordinator newCoordinator=new Coordinator();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("th/coordinators/add-coordinator");
        mav.addObject("coordinator",newCoordinator);
        return mav;
    }

    @PostMapping("/coordinator/add-coordinator")
    public String addNewCoordinator(@Valid Coordinator coordinator, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "th/coordinator/add-coordinator";
        }
        coordinatorService.saveOrUpdate(coordinator);
        return "redirect:/coordinator/index";
    }

    @GetMapping("/coordinator/delete/{coordinatorId}")
    public String deleteUser (@PathVariable("coordinatorId") long coordinatorId, Model model) {
        coordinatorService.deleteById(coordinatorId);
        return "redirect:/coordinator/index";
    }

    @GetMapping("/coordinator/edit/{coordinatorId}")
    public String showUpdateForm (@PathVariable("coordinatorId") long coordinatorId, Model model){
        Coordinator coordinator = coordinatorService.getCoordinatorById(coordinatorId);
        model.addAttribute("coordinator", coordinator);
        return "th/coordinators/update-coordinator";
    }

    @PostMapping("/coordinator/update/{coordinatorId}")
    public String updateCoordinator(@PathVariable("coordinatorId") Long coordinatorId, @Valid Coordinator coordinator, BindingResult result, Model model) {
        if (result.hasErrors()){
            coordinator.setCoordinatorId(coordinatorId);
            return "th/coordinators/update-coordinator";
        }
        coordinatorService.saveOrUpdate(coordinator);
        return "redirect:/coordinator/index/";
    }
}
