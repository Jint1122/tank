package com.jint.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jint on 2020/8/8.
 */
public class PropertyMgr {
    static Properties prop = new Properties();

    static {
        try {
            prop.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (prop == null) {
            return null;
        }
        return prop.get(key);
    }

    public static void main(String[] args) {
        System.out.println(get("initTankCount"));
    }
}
