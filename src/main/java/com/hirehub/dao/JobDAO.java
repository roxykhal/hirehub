//information for what operations can be performed on job table

import com.hirehub.model.Job;
import.java.util.list;

//complete abstract class
public interface JobDAO {
    void add(Job job);
    void update(Job job);
    void delete(Job job);

    Job getByID(int id);

    List<Job>getAll();


}