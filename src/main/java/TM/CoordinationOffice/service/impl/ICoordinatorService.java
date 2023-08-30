package TM.CoordinationOffice.service.impl;

import TM.CoordinationOffice.model.Coordinator;

import java.util.List;

public interface ICoordinatorService {
    public List<Coordinator> getAllCoordinators();
    public Coordinator getCoordinatorById(long coordinatorId);
    public long saveOrUpdate(Coordinator coordinator);
    public void deleteById(long coordinatorId);
    public void update(Coordinator coordinator, long coordinatorId);
}
