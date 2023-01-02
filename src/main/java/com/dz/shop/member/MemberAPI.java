package com.dz.shop.member;

import com.dz.shop.admin.MemberEnum;
import com.dz.shop.entity.MemberVO;
import com.dz.shop.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/member/*")
public class MemberAPI {
    private static final Logger logger = LoggerFactory.getLogger(MemberAPI.class);
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(
            @RequestBody MemberVO memberVO, HttpSession session,
            HttpServletRequest request
            ){
        System.out.println("MemberAPI.userStatus");

        MemberVO member = memberService.login(memberVO);
        Map<String, Object> map = new HashMap<>();

        if(member == null){
            map.put("status", false);
            return map;
        }

        session.setAttribute("isLogin", true);
        session.setAttribute("sessionUserId", member.getUserId());
        session.setAttribute("sessionName", member.getName());
        System.out.println("member = " + member.getName());
        map.put("status", true);
        map.put("href", request.getContextPath());

        return map;
    }

    @RequestMapping(value = "/dupUidCheck", method = RequestMethod.GET)
    public Map<String, Object> dupUidCheck(HttpServletRequest request, HttpServletResponse response){
        System.out.println("MemberAPI.dupUidCheck");

        String userId = request.getParameter("userId");
        MemberVO member = memberService.dupUidaCheck(userId);

        Map<String, Object> result = new HashMap<>();
        if (member == null) {
            result.put("status", true);
            result.put("message", "해당 아이디는 사용 가능합니다.");
        } else {
            result.put("status", false);
            result.put("message", "해당 아이디는 사용 불가능합니다.");
        }

        return result;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insert(
            @RequestBody MemberVO member,
            HttpServletRequest request
    ){
        System.out.println("MemberAPI.insert");

        member.setUserStatus(MemberEnum.USE.name());
        member.setAdmin(false);
        member.setCreatedate(LocalDateTime.now());
        member.setDelete_yn(false);

        long result = memberService.insert(member);

        System.out.println("member = " + member);
        System.out.println("result = " + result);

        Map<String, Object> resultMap = new HashMap<>();
        if (result < 0) {
            resultMap.put("status", false);
            resultMap.put("message", "회원가입 실패!");
        } else {
            resultMap.put("status", true);
            resultMap.put("message", "회원가입 성공!");
            resultMap.put("url", request.getContextPath()+"/member/loginForm.do");
        }

        return resultMap;
    }
}
