package com.example.viewhelper;

/**
 * Created by DaikiTakeuchi on 2016/11/23.
 */
public class StringHelper {

    public String substring(String text, int max) {
        if (text != null && text.length() > 0) {
            if (text.length() > max) {
                return text.substring(0, max);
            } else {
                return text;
            }
        } else {
            return "";
        }
    }
}
