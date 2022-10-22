package uz.edu.travelservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.travelservice.exception.MemberNotFoundException;
import uz.edu.travelservice.exception.TravelClubNotFoundException;
import uz.edu.travelservice.model.CommunityMember;
import uz.edu.travelservice.model.TravelClub;
import uz.edu.travelservice.repository.MemberRepository;
import java.util.List;
import java.util.Objects;

import static uz.edu.travelservice.exception.ApiException.*;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 13/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@Service
public class MemberServiceImpl implements MemberService{
    //
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public CommunityMember registerMember(CommunityMember member) {
        // Logic

        return memberRepository.save(member);
    }

    @Override
    public CommunityMember findMemberById(Long id) throws MemberNotFoundException {
        if(memberRepository.findById(id).isEmpty()){
            throw new MemberNotFoundException(MEMBER_WITH_ID_NOT_FOUND);
        } else {
            return memberRepository.findById(id).get();
        }
    }

    @Override
    public CommunityMember findByEmail(String email) throws MemberNotFoundException {
        if(memberRepository.findByEmail(email)==null || memberRepository.findByEmail(email).equals("")){
            throw new MemberNotFoundException(MEMBER_WITH_EMAIL_NOT_FOUND);
        } return memberRepository.findByEmail(email);
    }

    @Override
    public List<CommunityMember> findByName(String name) throws MemberNotFoundException {
        if (memberRepository.findByName(name)==null || memberRepository.findByName(name).equals("")){
            throw new MemberNotFoundException(MEMBER_WITH_NAME_NOT_FOUND);
        } else  {
            List<CommunityMember> members = (List<CommunityMember>) memberRepository.findByName(name);
            return members;
        }
    }

    @Override
    public void modifyMember(Long id, CommunityMember communityMember) throws MemberNotFoundException {
        CommunityMember memberUpdate = memberRepository.findById(id).get();
        //name
        if (Objects.nonNull(memberUpdate.getName()) &&
                !"".equalsIgnoreCase(memberUpdate.getName())) {
            memberUpdate.setName(memberUpdate.getName());
        } else{
            throw new MemberNotFoundException(MEMBER_WITH_NAME_NOT_FOUND);
        }

        //nickname
        if (Objects.nonNull(memberUpdate.getNickName()) &&
                !"".equalsIgnoreCase(memberUpdate.getNickName())) {
            memberUpdate.setNickName(memberUpdate.getNickName());
        } else{
            throw new MemberNotFoundException(MEMBER_WITH_NICKNAME_NOT_FOUND);
        }

        //email
        if (Objects.nonNull(memberUpdate.getEmail()) &&
                !"".equalsIgnoreCase(memberUpdate.getEmail())) {
            memberUpdate.setEmail(memberUpdate.getEmail());
        } else{
            throw new MemberNotFoundException(MEMBER_WITH_EMAIL_NOT_FOUND);
        }

        //age
        if (Objects.nonNull(memberUpdate.getBirthDay()) &&
                !"".equalsIgnoreCase(memberUpdate.getBirthDay())) {
            memberUpdate.setBirthDay(memberUpdate.getBirthDay());
        } else{
            throw new MemberNotFoundException(MEMBER_WITH_BIRTHDAY_NOT_FOUND);
        }

        memberRepository.save(memberUpdate);

    }

    @Override
    public void removeMember(Long id) throws MemberNotFoundException {
        if (id ==0) {
            throw new MemberNotFoundException(MEMBER_WITH_ID_NOT_FOUND);
        }
        memberRepository.deleteById(id);
    }

    @Override
    public List<CommunityMember> findAllMember() {
        return memberRepository.findAll();
    }
}
