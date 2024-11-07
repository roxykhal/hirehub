//information for what operations can be performed on communicationsdab table

package com.hirehub.dao;
import com.hirehub.model.Communications;
import java.util.List;

//complete abstract class
public interface CommunicationsDAO {
    void add(Communications communications);
    void update(Communications communications);
    void delete(Communications communications);

    Communications getByID(int id);

    List<Communications>getAll();


}
