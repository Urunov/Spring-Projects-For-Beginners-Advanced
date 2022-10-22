package uz.edu.travelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.edu.travelservice.model.CommunityMember;
import uz.edu.travelservice.model.TravelClub;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 12/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Repository
public interface MemberRepository extends JpaRepository<CommunityMember, Long> {
    CommunityMember findByEmail(String email);
    CommunityMember findByName(String memberName);
}
