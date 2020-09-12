package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    //DI 방법중 하나인 setter 주입
    // - 단점은 public으로 노출이 됨
    //@Autowired
    //public MemberController(MemberService memberService) {
    //    this.memberService = memberService;
    //}
    //DI 방법중 하나인 필드 주입
    // - 필드에 주입을 경우 최초 생성 후 중간에 변경이 불가능하기 때문에 생성자 주입 권장
    // @Autowired private MemberService memberService;

    //DI 방법중 하나인 생성자 주입(권장) - 의존관계가 동적으로 변경하는 경우는 거의 없음
    //@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
