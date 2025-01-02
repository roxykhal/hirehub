package com.hirehub.service;
import com.hirehub.dao.ScreeningQuestionsDAO;
import com.hirehub.dao.ScreeningQuestionsDAOImpl;
import com.hirehub.model.ScreeningQuestions;
import java.util.List;

public class ScreeningQuestionsService {
    private ScreeningQuestionsDAO screeningQuestionsDAO;

    public ScreeningQuestionsService() {
        this.screeningQuestionsDAO = new ScreeningQuestionsDAOImpl();
    }

public void createScreeningQuestions() {
    screeningQuestionsDAO.add(null);
}

public void updateScreeningQuestions() {
    screeningQuestionsDAO.update(null);
}

public void deleteScreeningQuestions(int id) {
    screeningQuestionsDAO.delete(null);
    
}

public void getScreeningQuestionsById(int id) {
    screeningQuestionsDAO.getByID(id);
}

public List<ScreeningQuestions> getAllScreeningQuestions() {
    return screeningQuestionsDAO.getAll();
}

}
