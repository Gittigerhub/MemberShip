package com.example.membership.controller;

import com.example.membership.DTO.MemberShipDTO;
import com.example.membership.service.MemberShipService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/user")
public class MemberShipController {

    // 의존성 부여
    private final MemberShipService memberShipService;

    @GetMapping("/signup")
    public String signup(MemberShipDTO memberShipDTO) {

        // MemberShipDTO파라미터는 ~~ 유효성 검사를 하면 다시 보내줄거라서 ~~~


        return "user/signup";
    }

    // 오버로딩 / 위 아래가 이름은 같지만 파라미터가 달라 사용가능

    @PostMapping("/signup")
    public String signup(@Valid MemberShipDTO memberShipDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {

        log.info("컨트롤러로로 들어온 memberShipDTO : " + memberShipDTO);

        // 유효성검사 진행
        if (bindingResult.hasErrors()) {
            log.info("컨트롤러로 유효성 검사로 들어온 memberShipDTO : " + memberShipDTO);
            return "user/signup";
        }

        // 예외처리 진행
        try {
            // 회원가입 완료
            memberShipDTO =
                    memberShipService.saveMember(memberShipDTO);

        }catch (IllegalStateException e) {

            // 회원가입 실패시 에러문 발생
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");
            log.info("동일한 이메일이 있습니다.");

            // 해당 에러메세지를 msg로 view로 넘김
            model.addAttribute("msg", e.getMessage());
            return "user/signup";

        }
        // 일회성으로 데이터 저장하여 넘김, 주소창에 표시되지않고 세션에 저장되고 사용후엔 자동 삭제됨
        redirectAttributes.addFlashAttribute("memberShipDTO", memberShipDTO);
        return "redirect:/user/signup";
    }

    @GetMapping("/login")
    public String login(MemberShipDTO memberShipDTO, Principal principal) {
        // 가입이 아니라 유효성 검사할 필요 없음

        // Principal이란 객체는 로그인이 되었을 때 값을 가지게 됩니다.
        // 현재는 email을 username로 가졌기 때문에 로그인한 email을 가지고 있습니다.
        if (principal != null) {

            log.info("===============================");
            log.info("||" + principal.getName() + "||");
            log.info("||" + principal.getName() + "||");
            log.info("||" + principal.getName() + "||");
            log.info("||" + principal.getName() + "||");
            log.info("||" + principal.getName() + "||");
            log.info("===============================");


//              이런식으러 사용할겁니다.
//            MemberShipt memberShipt =
//                    memberShipService.findByEmail(principal.getName());
//            boardDTO.setMember(memberShipt);

//            로그인이 안되어있어? 로그인하고와 / 리스트로 보내버림
//            return "regirect:/board/list";

//            findByEmail을 만들어서 사용하는 방법
//            MemberShipDTO memberShipDTO =
//                    memberShipService.findByEmail(principal.getName());
        }

        return "user/login";
    }

//    @PostMapping("/login") 이건 시큐리티가 알아서 함




}
