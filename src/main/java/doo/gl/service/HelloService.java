package doo.gl.service;

import com.stormpath.sdk.account.Account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import static doo.gl.controller.HelloController.GROUP;

@Service
public class HelloService {


    @PreAuthorize("hasAuthority('" + GROUP + "')")
    public String sayHello(Account account) {


        return "Hello " + account.getGivenName() + ", you are authorised";
    }

}
