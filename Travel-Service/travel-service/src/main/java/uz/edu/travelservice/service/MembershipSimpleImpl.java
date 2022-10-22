package uz.edu.travelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.travelservice.model.Membership;
import uz.edu.travelservice.repository.MembershipRepository;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 13/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class MembershipSimpleImpl implements MembershipService{
    //
    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public Membership registerMembership(Membership membership) {
        return null;
    }

    @Override
    public Membership findMembership(Long id) {
        return null;
    }

    @Override
    public Membership findMembershipByClubIdAndMemberEmail(Long id, String email) {
        return null;
    }

    @Override
    public List<Membership> findAllMembershipdsOfClub(Long id) {
        return null;
    }

    @Override
    public void modifyMembership(Long id, Membership membership) {

    }

    @Override
    public void removeMembership(Long id) {

    }
}
