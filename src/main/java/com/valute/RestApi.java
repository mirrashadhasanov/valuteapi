package com.valute;

import com.valute.request.Request;
import com.valute.request.RequestJsonAll;
import com.valute.request.RequestString;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class RestApi {

    @GetMapping("hash")
    public String getRequestHash(){
        Request request = new Request();
        return request.requestResponse();
    }

    @GetMapping("hashmap")
    public HashMap getRequestHashMap(){

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

    @GetMapping("string")
    public String getRequestString(){

        RequestString requestString = new RequestString();

        return requestString.requestResponse();
    }

    @GetMapping("json")
    public JSONObject getRequestJson(){

        JSONObject jsonObject = new JSONObject();

        RequestString requestString = new RequestString();

        String[] pairs = requestString.requestResponse().split(",");

        for (int i=0; i<pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            jsonObject.put(keyValue[0], keyValue[1]);
        }

        return jsonObject;
    }

    @GetMapping("jsonall")
    public JSONObject getRequestJsonAll(){

        JSONObject jsonObject = new JSONObject();


        RequestJsonAll requestJsonAll = new RequestJsonAll();

        String[] pairs = requestJsonAll.requestResponse().split(",");

        for (int i=0; i<pairs.length; i++) {

            JSONObject object = new JSONObject();

            String pair = pairs[i];
            String[] keyValue = pair.split(":");

            object.put("name", keyValue[1]);
            object.put("value", keyValue[2]);
            jsonObject.put(keyValue[0], object);
        }

        return jsonObject;
    }

}
