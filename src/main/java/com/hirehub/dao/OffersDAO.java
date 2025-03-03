//information for what operations can be performed on offers table
package com.hirehub.dao;
import com.hirehub.model.Offers;
import java.util.List;

//complete abstract class
public interface OffersDAO {
    void add(Offers offers);
    void update(Offers offers);
    void delete(int id);

    Offers getByID(int id);

    List<Offers>getAll();


}
