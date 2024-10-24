//information for what operations can be performed on screeningquestions table

import com.hirehub.model.ScreeningQuestions;
import.java.util.list;

//complete abstract class
public interface CandidatesDAO {
    void add(ScreeningQuestions screeningQuestions );
    void update(ScreeningQuestions screeningQuestions );
    void delete(ScreeningQuestions screeningQuestions );

    ScreeningQuestions getByID(int id);

    List<ScreeningQuestions>getAll();


}
