package kr.co.springbootawswebservicestudy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){

        return "main";
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "post-save";
    }
}
