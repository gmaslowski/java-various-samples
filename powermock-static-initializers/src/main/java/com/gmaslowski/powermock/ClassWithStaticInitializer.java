package com.gmaslowski.powermock;

public class ClassWithStaticInitializer {

    public static final String STATIC_INITIALIZER_VALUE = "STATIC_INITIALIZER_VALUE";
    public static final String STATIC_VALUE = "STATIC_VALUE";

    static {
        value = STATIC_INITIALIZER_VALUE;
    }

    public static String value = STATIC_VALUE;

}
