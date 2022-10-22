package uz.edu.travelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.travelservice.model.TravelClub;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface TravelClubRepository extends JpaRepository<TravelClub, Long > {
    TravelClub findByClubName(String name);
}