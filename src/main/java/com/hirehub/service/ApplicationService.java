package com.hirehub.service;
import com.hirehub.dao.ApplicationsDAO;
import com.hirehub.dao.ApplicationsDAOImpl;
import com.hirehub.model.Applications;
import java.util.List;

public class ApplicationService {
    private ApplicationsDAO applicationsDAO;

    public ApplicationService() {
        this.applicationsDAO = new ApplicationsDAOImpl();
    }

public void CreateApplication(Applications applications) {
    applicationsDAO.add(null);

}

public void updateApplication(Applications applications) {
    applicationsDAO.update(applications);
}

public void deleteApplications(int id) {
    applicationsDAO.delete(id);
}

public void getAllApplications(int id) {
    applicationsDAO.getByID(id);
}

public List<Applications> getApplicationByIds() {
    return applicationsDAO.getAll(); 
}

    
}
