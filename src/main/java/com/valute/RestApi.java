package com.valute;

import com.valute.request.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestApi {

    @GetMapping("restapi")
    public String getRequest(){
        Request request = new Request();
        return request.requestResponse();
    }

    @GetMapping("restapi2")
    public String restapi2(){
        return "restapi2";
    }


}
