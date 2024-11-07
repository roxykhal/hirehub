//information for what operations can be performed on candidates table

package com.hirehub.dao;
import com.hirehub.model.Candidates;
import java.util.List;

//complete abstract class
public interface CandidatesDAO {
    void add(Candidates candidates);
    void update(Candidates candidates);
    void delete(Candidates candidates);

    Candidates getByID(int id);

    List<Candidates>getAll();


}
