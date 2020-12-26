package com.ws.bighomeworkfirst.domain;

/**
 * 标签实体类
 */
public class Label {

    private Integer label_id;

    private String label_name;

    private String label_description;

    public Integer getLabel_id() {
        return label_id;
    }

    public void setLabel_id(Integer label_id) {
        this.label_id = label_id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLabel_description() {
        return label_description;
    }

    public void setLabel_description(String label_description) {
        this.label_description = label_description;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label_id=" + label_id +
                ", Label_name='" + label_name + '\'' +
                ", label_description='" + label_description + '\'' +
                '}';
    }
}
