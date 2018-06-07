package com.smm.model.enums;

public enum ServiceType {
    MIXCLOUD("Mixcloud"),
    MYWORLD("МойМир"),
    OTHER("Прочее"),
    FACEBOOK("Facebook"),
    VK("Вконтакте"),
    INSTAGRAM("Instagram"),
    YOUTUBE_1("YouTube"),
    YOUTUBE_2("Youtube"),
    TWITTER("Twitter"),
    OK("Одноклассники"),
    TG("Telegram"),
    SC("SoundCloud"),
    PERESCOPE("Periscope"),
    REVIEWS("Отзывы"),
    TRAFFIC("Трафик");


    private String value;

    ServiceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean hasService(String newService){
        for (ServiceType value : values()) {
            if(value.getValue().toLowerCase().equals(newService.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
