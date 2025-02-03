//information for what operations can be performed on candidates table
package com.hirehub.dao;
import com.hirehub.model.Candidates;
import java.util.List;

//complete abstract class
public interface CandidatesDAO {

    void add(Candidates candidates);

    void update(Candidates candidates);

    void delete(int id);

    Candidates getId(int id);

    Candidates getByEmail(String email);

    Candidates getByStatus(String status);

    List<Candidates>getAll();


}
