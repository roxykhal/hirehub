//information for what operations can be performed on communicationsdab table

import com.hirehub.model.Commuications;
import.java.util.list;

//complete abstract class
public interface CommunicationsDAO {
    void add(Communications communications);
    void update(Communications communications);
    void delete(Communications communications);

    Communications getByID(int id);

    List<Communications>getAll();


}
