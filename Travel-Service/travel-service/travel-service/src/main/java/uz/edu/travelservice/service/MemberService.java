package uz.edu.travelservice.service;

import uz.edu.travelservice.exception.MemberNotFoundException;
import uz.edu.travelservice.model.CommunityMember;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 13/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
public interface MemberService {

   // Long registerMember(CommunityMember member); // Long --ID , CommunityMember -->
    CommunityMember registerMember(CommunityMember member); // Long --ID , CommunityMember -->
    CommunityMember findMemberById(Long id) throws MemberNotFoundException;
    CommunityMember findByEmail(String email) throws MemberNotFoundException;
    List<CommunityMember> findByName(String name) throws MemberNotFoundException;
    void modifyMember(Long id, CommunityMember communityMember) throws MemberNotFoundException;
    void removeMember(Long id) throws MemberNotFoundException;

    List<CommunityMember> findAllMember();
}
