package com.hirehub.service;
import com.hirehub.dao.CommunicationsDAO;
import com.hirehub.dao.CommunicationsDAOImpl;
import com.hirehub.model.Communications;
import java.util.List;

public class CommunicationService {
    private CommunicationsDAO communicationsDAO;

    public CommunicationService() {
        this.communicationsDAO = new CommunicationsDAOImpl();

    }
    
public void createCommunication() {
    communicationsDAO.add(null);
}

public void updateCommunication() {
    communicationsDAO.update(null);
}

public void deleteCommunication(int id) {
    communicationsDAO.delete(null);
}

public void getCommunicationByIds(int id) {
    communicationsDAO.getByID(id);
}

public List<Communications> getAllCommunications() {
    return communicationsDAO.getAll();
}

}
