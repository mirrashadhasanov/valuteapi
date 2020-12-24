package com.valute.request;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Request {

    private final String url = "https://www.cbar.az/currencies/23.12.2025.xml";

    private int responseCode;

    private  String inputLine;

    HashMap valMap = new HashMap<>();

    public String requestResponse(){
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response.toString())));
            NodeList errNodes = doc.getElementsByTagName("ValType");

            if (errNodes.getLength() > 0 ) {
                Element err = (Element)errNodes.item(1);
                NodeList err2Nodes = err.getElementsByTagName("Valute");



                for (int i=0; i < err2Nodes.getLength(); i++){
                    Element err2 = (Element) err2Nodes.item(i);
                    String code = err2.getAttribute("Code");
                    String value = err2.getElementsByTagName("Value").item(0).getTextContent();

                    valMap.put(code, value);
                }
                String content = valMap.toString();
                return content;

            } else {
                valMap.put("cavab", "Hec bir melumat tapilmadi");
                String content = valMap.toString();
                return content;
            }
        } catch (Exception e) {
            valMap.put("error", e);
            String content = valMap.toString();
            return content;
        }
    }
}
