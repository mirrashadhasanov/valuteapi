package com.valute.request;

public class Value {

    private String code;

    private String name;

    private String valute;

    public Value() {
    }

    public Value(String code, String name, String valute) {
        this.code = code;
        this.name = name;
        this.valute = valute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValute() {
        return valute;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }
}
