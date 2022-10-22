package uz.edu.travelservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.edu.travelservice.exception.MemberNotFoundException;
import uz.edu.travelservice.model.CommunityMember;
import uz.edu.travelservice.service.MemberService;

import java.util.List;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 15/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
@RestController
@RequestMapping("/api/v1")
public class CommunityMemberController {

    @Autowired
    private MemberService memberService;
    private final Logger LOG = LoggerFactory.getLogger(CommunityMemberController.class);

    @PostMapping("/store/member")
    public CommunityMember getCommunityMember(@RequestBody CommunityMember communityMember){
        return memberService.registerMember(communityMember);
    }

    @GetMapping("/all/member")
    public List<CommunityMember> memberList() {
        return memberService.findAllMember();
    }

    @DeleteMapping("/member/{id}")
    public String deleteMemberById(@PathVariable("id") Long memberId) throws MemberNotFoundException {

        memberService.removeMember(memberId);
        LOG.warn("Inside the delte of Member: {}", memberId);
        return "Deleted . Successfully..";
    }

    @PutMapping("/update/member/{id}")
    public void updateMemberValue(@PathVariable Long id, @RequestBody CommunityMember member) throws MemberNotFoundException {
        LOG.info("Inside the updated Member of Controller : ");
        memberService.modifyMember(id, member);
    }

}
