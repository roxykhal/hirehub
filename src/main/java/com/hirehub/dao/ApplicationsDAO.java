//information for what operations can be performed on Applications table - crud
package com.hirehub.dao;
import com.hirehub.model.Applications;
import java.util.List;

//complete abstract class
public interface ApplicationsDAO {
    void add(Applications applications);
    void update(Applications applications);
    void delete(int applicationID);

    Applications getByID(int id);

    List<Applications>getAll();

}
