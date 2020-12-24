package com.valute.request;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestJsonAll {

    private final String url = "https://www.cbar.az/currencies/23.12.2025.xml";

    private int responseCode;

    private  String inputLine;

    StringBuilder str = new StringBuilder();

    private String returnResponse;

    public String requestResponse() {
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

            if (errNodes.getLength() > 0) {
                Element err = (Element) errNodes.item(1);
                NodeList err2Nodes = err.getElementsByTagName("Valute");


                for (int i = 0; i < err2Nodes.getLength(); i++) {
                    Element err2 = (Element) err2Nodes.item(i);
                    String code = err2.getAttribute("Code");
                    String name = err2.getElementsByTagName("Name").item(0).getTextContent();
                    String value = err2.getElementsByTagName("Value").item(0).getTextContent();

                    str.append(code + ":"+name + ":" + value + ",");
                }

            } else {
                str.append("cavab:Hec bir melumat tapilmadi");
            }

        } catch (Exception e) {
            str.append("error:" + e);

        }

        returnResponse = str.toString();
        return returnResponse;
    }
}
