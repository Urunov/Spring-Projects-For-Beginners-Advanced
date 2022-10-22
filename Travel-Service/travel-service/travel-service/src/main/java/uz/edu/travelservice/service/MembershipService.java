package uz.edu.travelservice.service;

import uz.edu.travelservice.model.Membership;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 13/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface MembershipService {

    Membership registerMembership(Membership membership);

    Membership findMembership(Long id);

    //Membership findMembershipByIdAndId(Long id, Long id);
    Membership findMembershipByClubIdAndMemberEmail(Long id, String email);

    List<Membership> findAllMembershipdsOfClub(Long id);
    void modifyMembership(Long id, Membership membership);
    void removeMembership(Long id);
}
