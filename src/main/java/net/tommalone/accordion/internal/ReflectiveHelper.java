package net.tommalone.accordion.internal;

import java.lang.reflect.Field;

public class ReflectiveHelper {

    private ReflectiveHelper() {
        // Not meant to be instantiated
    }

    public static Object getValue(Object o, String fieldName) {
        try {
            Field declaredField = o.getClass().getSuperclass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
