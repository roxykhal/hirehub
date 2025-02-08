//service layer acts as an intermediary between user input and requests (controller) and DAO layer(data persistance)
package com.hirehub.service;
import com.hirehub.dao.CandidatesDAO;
import com.hirehub.dao.CandidatesDAOimpl;
import com.hirehub.model.Candidates;
import java.util.List;


public class CandidateService {
    private CandidatesDAO candidatesDAO;

    public CandidateService() {
        this.candidatesDAO = new CandidatesDAOimpl();
    }

    public void createCandidate(Candidates candidates) {
        candidatesDAO.add(null);

    }

    public void updateCandidate(Candidates candidates) {
        candidatesDAO.update(candidates);
    }

    public void deleteCandidate (int id) {
        candidatesDAO.delete(id);

    }

    public void getcandidateID (int id) {
        candidatesDAO.getId(id);
    }

    public List<Candidates> getAllCandidates() {
        return candidatesDAO.getAll();
    }


    
}
