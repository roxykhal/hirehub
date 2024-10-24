//information for what operations can be performed on users table

import com.hirehub.model.Users;
import.java.util.list;

//complete abstract class
public interface UsersDAO {
    void add(Users users);
    void update(Users users);
    void delete(Users users);

    Users getByID(int id);

    List<Users>getAll();


}
