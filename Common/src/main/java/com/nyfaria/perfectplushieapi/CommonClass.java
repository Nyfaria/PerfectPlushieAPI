package com.nyfaria.perfectplushieapi;

import com.nyfaria.perfectplushieapi.init.PlushieTags;

// This class is part of the common project meaning it is shared between
public class CommonClass {

    public static void init() {
        PlushieTags.loadClass();
    }

    public static int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}