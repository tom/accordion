package net.tommalone.accordion.internal;

import java.lang.reflect.Field;

public class ReflectiveHelper {

    private ReflectiveHelper() {
        // Not meant to be instantiated
    }

    public static Object getValue(Object o, String fieldName) {
        try {
            Field fieldFromClass = getFieldFromClass(o.getClass(), fieldName);
            fieldFromClass.setAccessible(true);
            return fieldFromClass.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setValue(Object o, String fieldName, Object value) {
        try {
            Field fieldFromClass = getFieldFromClass(o.getClass(), fieldName);
            fieldFromClass.setAccessible(true);
            fieldFromClass.set(o, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Field getFieldFromClass(Class clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if(clazz.getSuperclass() == null) {
                throw new RuntimeException(e);
            } else {
                return getFieldFromClass(clazz.getSuperclass(), fieldName);
            }
        }
    }

}
