//information for what operations can be performed on screeningquestions table
package com.hirehub.dao;
import com.hirehub.model.ScreeningQuestions;
import java.util.List;

//complete abstract class
public interface ScreeningQuestionsDAO {
    void add(ScreeningQuestions screeningQuestions );
    void update(ScreeningQuestions screeningQuestions );
    void delete(ScreeningQuestions screeningQuestions );

    ScreeningQuestions getByID(int id);

    List<ScreeningQuestions>getAll();


}
