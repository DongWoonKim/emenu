package com.emenu.comito.web;

import com.emenu.comito.config.auth.LoginUser;
import com.emenu.comito.config.auth.dto.SessionUser;
import com.emenu.comito.service.posts.PostsService;
import com.emenu.comito.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    /*
        머스테치 스타터 덕분에  컨트롤러에서 문자열을 반환할 때
        앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.

        앞의 경로 : src/main/resources/templates
        뒤의 파일 확장자 : .mustache
     */

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
