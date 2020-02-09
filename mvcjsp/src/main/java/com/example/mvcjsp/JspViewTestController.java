package com.example.mvcjsp;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class JspViewTestController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/test") // localhost/test
    public String joinData(@ModelAttribute("member") Member abc, String id) {
        if (StringUtils.isEmpty(id))
            id = "dummyId";
        if (StringUtils.isEmpty(abc.getEmail()))
            abc.setEmail("test@example.com");
        if (StringUtils.isEmpty(abc.getId()))
            abc.setId(UUID.randomUUID().toString());
        if (StringUtils.isEmpty(abc.getName()))
            abc.setName("테스터");
        if (StringUtils.isEmpty(abc.getPw()))
            abc.setPw("testpwd");
        return "board/join";       // 실제 호출될 /WEB-INF/jsp/test/viewtest2.jsp
    }
}
