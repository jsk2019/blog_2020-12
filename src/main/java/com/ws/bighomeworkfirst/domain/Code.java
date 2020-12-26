package com.ws.bighomeworkfirst.domain;

public class Code {

    private String type;

    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Code{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
