package doo.gl.controller;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.account.AccountResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import doo.gl.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private Application application;

    @Autowired
    private AccountResolver accountResolver;

    @Autowired
    private HelloService helloService;

    public static final String GROUP = "https://api.stormpath.com/v1/groups/6nZNyehgjJdI1TmRYzL59V";


    @RequestMapping(path = "/")
    public String hello(HttpServletRequest request, Model model) {
        model.addAttribute("status", request.getParameter("status"));
        return "home";
    }


    @RequestMapping("/restricted")
    public String restricted(HttpServletRequest request, Model model) {
        String message = helloService.sayHello(
            accountResolver.getAccount(request)
        );
        model.addAttribute("msg", message);
        return "restricted";
    }

}
