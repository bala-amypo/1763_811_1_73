package com.example.demo.util;

public class HibernateQueryUtil {

    private HibernateQueryUtil() {
    }

    // Check string is not null and not empty
    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Safe integer check
    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}
