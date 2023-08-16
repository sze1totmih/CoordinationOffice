package TM.CoordinationOffice.service.impl;

import TM.CoordinationOffice.model.Coordinator;

import java.util.List;

public interface ICoordinatorService {
    public List<Coordinator> getAllCoordinators();
    public Coordinator getCoordinatorById(int id);
    public int saveOrUpdate(Coordinator coordinator);
    public void deleteById(int id);
    public void update(Coordinator coordinator, int id);
}
