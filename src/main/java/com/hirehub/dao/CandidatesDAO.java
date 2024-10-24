//information for what operations can be performed on candidates table

import com.hirehub.model.Candidates;
import.java.util.list;

//complete abstract class
public interface CandidatesDAO {
    void add(Candidates candidates);
    void update(Candidates candidates);
    void delete(Candidates candidates);

    Candidates getByID(int id);

    List<Candidates>getAll();


}
