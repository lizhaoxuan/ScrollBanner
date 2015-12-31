package com.zhaoxuan.demo;

/**
 * Created by lizhaoxuan on 15/12/25.
 */
public class BannerDto {

    private int id;

    private int type;

    private String title;

    private int action;

    private int wheelTime;

    private String bgColor;

    public BannerDto(int action, String bgColor, int id, String title, int type, int wheelTime) {
        this.action = action;
        this.bgColor = bgColor;
        this.id = id;
        this.title = title;
        this.type = type;
        this.wheelTime = wheelTime;
    }

    public int getAction() {
        return action;
    }

    public String getBgColor() {
        return bgColor;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public int getWheelTime() {
        return wheelTime;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setWheelTime(int wheelTime) {
        this.wheelTime = wheelTime;
    }
}
