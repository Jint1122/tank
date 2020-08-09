package com.jint.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jint on 2020/8/8.
 */
public class PropertyMgr {
    private static final Properties PROP = new Properties();

    static {
        try {
            PROP.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyMgr() {}

    public static Object get(String key) {
        if (PROP == null) {
            return null;
        }
        return PROP.get(key);
    }

    public static void main(String[] args) {
        System.out.println(get("initTankCount"));
    }
}
