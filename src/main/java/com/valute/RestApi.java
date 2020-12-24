package com.valute;

import com.valute.request.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class RestApi {

    @GetMapping("hashmap")
    public HashMap getRequest(){
        Request request = new Request();
        return request.requestResponse();
    }


}
