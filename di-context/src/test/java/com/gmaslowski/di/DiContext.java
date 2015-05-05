package com.gmaslowski.di;

import static java.util.Arrays.asList;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiContext {

    private Map<String, Object> beans = new HashMap<>();
    private static Objenesis objenesis = new ObjenesisStd();

    public DiContext(Map<String, Object> beans) {
        this.beans = beans;
    }

    public Object getBean(String className) {
        return beans.get(className);
    }

    public static DiContext start() {
        Map<String, Object> beans = instantiate(getClassesForDi());
        return new DiContext(beans);
    }

    private static Map<String, Object> instantiate(List<String> classes) {
        Map<String, Object> beans = new HashMap<>();

        classes.forEach(classString -> {
            try {
                Class<?> aClass = Class.forName(classString);
                Object constructedBean = constructBean(aClass);
                beans.put(classString, constructedBean);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        beans.forEach((className, bean) -> {
            asList(bean.getClass().getDeclaredFields()).forEach(field -> {
                if (beans.containsKey(field.getType().getName())) {
                    field.setAccessible(true);
                    try {
                        field.set(bean, beans.get(field.getType().getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        return beans;
    }

    private static Object constructBean(Class<?> aClass) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        return objenesis.newInstance(aClass);
    }

    private static List<String> getClassesForDi() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("com.gmaslowski.di.beans.Service");
        classes.add("com.gmaslowski.di.beans.Repository");
        return classes;
    }
}
