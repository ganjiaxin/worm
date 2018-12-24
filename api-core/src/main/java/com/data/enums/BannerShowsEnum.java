package com.data.enums;

public enum BannerShowsEnum {
    H5("H5", 1), IOS("IOS", 2), ANDROID("ANDROID", 3);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private BannerShowsEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (BannerShowsEnum c : BannerShowsEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // 普通方法
    public static Integer getIndex(String name) {
        for (BannerShowsEnum c : BannerShowsEnum.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
