package com.hirehub.service;
import com.hirehub.dao.InterviewsDAO;
import com.hirehub.dao.InterviewsDAOImpl;
import com.hirehub.model.Interviews;
import java.util.List;


public class InterviewsService {
    private InterviewsDAO interviewsDAO;

    public InterviewsService() {
        this.interviewsDAO = new InterviewsDAOImpl();
    }

  
public void createInterviews() {
    interviewsDAO.add(null);
}

public void updateInterviews() {
    interviewsDAO.update(null);
}

public void deleteInterviews(int id) {
    interviewsDAO.delete(null);
}

public void getInterviewById(int id) {
    interviewsDAO.getByID(id);
}

public List<Interviews>getAllInterviews () {
    return interviewsDAO.getAll();
}

}