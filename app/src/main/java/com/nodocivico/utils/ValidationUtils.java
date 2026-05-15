package com.nodocivico.utils;

import android.util.Patterns;

/**
 * ValidationUtils - Clase de utilería para validaciones
 * Proporciona métodos estáticos para validar datos de entrada
 */
public class ValidationUtils {

    /**
     * Valida que un campo no esté vacío
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Valida formato de email
     */
    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Valida longitud mínima
     */
    public static boolean hasMinLength(String value, int minLength) {
        if (isEmpty(value)) {
            return false;
        }
        return value.length() >= minLength;
    }

    /**
     * Valida que la contraseña cumpla con requisitos mínimos
     * Mínimo 6 caracteres
     */
    public static boolean isValidPassword(String password) {
        return hasMinLength(password, 6);
    }

    /**
     * Valida que un teléfono tenga formato válido
     */
    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) {
            return false;
        }
        return Patterns.PHONE.matcher(phone).matches();
    }
}