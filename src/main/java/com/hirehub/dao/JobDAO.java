//information for what operations can be performed on job table
package com.hirehub.dao;
import com.hirehub.model.Job;
import java.util.List;

//complete abstract class
public interface JobDAO {
    void add(Job job);
    void update(Job job);
    void delete(int id);

    Job getByID(int id);

    List<Job>getAll();


}