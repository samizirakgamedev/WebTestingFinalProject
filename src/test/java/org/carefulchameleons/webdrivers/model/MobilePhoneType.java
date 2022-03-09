package org.carefulchameleons.webdrivers.model;

public enum MobilePhoneType {
    IPHONE11(414,896),
    SSGALAXYS21(360,800);

    public final int width;
    public final int height;

    MobilePhoneType(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
