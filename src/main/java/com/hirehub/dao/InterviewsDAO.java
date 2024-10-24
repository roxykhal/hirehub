//information for what operations can be performed on interviews table

import com.hirehub.model.Interviews;
import.java.util.list;

//complete abstract class
public interface CandidatesDAO {
    void add(Interviews interviews);
    void update(Interviews interviews);
    void delete(Interviews interviews);

    Interviews getByID(int id);

    List<Interviews>getAll();


}

