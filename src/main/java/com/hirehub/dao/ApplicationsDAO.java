//information for what operations can be performed on Applications table

import com.hirehub.model.Applications;
import.java.util.list;

//complete abstract class
public interface ApplicationsDAO {
    void add(Applications applications);
    void update(Applications applications);
    void delete(Applications applications);

    Applications getByID(int id);

    List<Applications>getAll();

}
