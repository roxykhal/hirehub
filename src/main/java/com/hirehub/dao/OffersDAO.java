//information for what operations can be performed on offers table

import com.hirehub.model.Offers;
import.java.util.list;

//complete abstract class
public interface OffersDAO {
    void add(Offers offers);
    void update(Offers offers);
    void delete(Offers offers);

    Offers getByID(int id);

    List<Offers>getAll();


}
