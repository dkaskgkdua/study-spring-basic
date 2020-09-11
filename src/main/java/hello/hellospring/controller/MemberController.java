package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
