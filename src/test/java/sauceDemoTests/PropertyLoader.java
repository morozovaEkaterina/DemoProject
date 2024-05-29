package sauceDemoTests;

import java.lang.reflect.Field;

public class PropertyLoader {

    public void loadProperties(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass().getSuperclass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Property.class)) {
                Property property = field.getAnnotation(Property.class);
                String value = System.getenv(property.value());
                if (value == null) {
                    value = System.getProperty(property.value());
                }
                if (value != null) {
                    field.setAccessible(true);
                    field.set(object, value);
                }
            }
        }
    }
}
