package com.emenu.comito.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    /*
        머스테치 스타터 덕분에  컨트롤러에서 문자열을 반환할 때
        앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.

        앞의 경로 : src/main/resources/templates
        뒤의 파일 확장자 : .mustache
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
