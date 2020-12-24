package com.valute;

import com.valute.request.Request;
import com.valute.request.RequestString;
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

        RequestString requestString = new RequestString();

        String[] pairs = requestString.requestResponse().split(",");

        for (int i=0; i<pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            hashMap.put(keyValue[0], keyValue[1]);
        }

        return hashMap;
    }

    @GetMapping("h")
    public String getRe(){

        RequestString requestString = new RequestString();

        return requestString.requestResponse();
    }

}
