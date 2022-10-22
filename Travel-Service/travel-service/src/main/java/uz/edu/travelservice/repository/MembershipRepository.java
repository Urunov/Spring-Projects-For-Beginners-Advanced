package uz.edu.travelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.travelservice.model.Membership;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 12/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
