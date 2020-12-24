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
    public String getRequest(){
        Request request = new Request();
        return request.requestResponse();
    }

    @GetMapping("hash")
    public HashMap getHashTest(){
        HashMap hashMap = new HashMap();

        hashMap.put("salam0", "Aleykum");
        hashMap.put("salam1", "Aleykum");
        hashMap.put("salam2", "Aleykum");

        return hashMap;
    }

}
