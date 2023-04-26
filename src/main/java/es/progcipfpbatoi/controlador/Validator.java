package es.progcipfpbatoi.controlador;

public class Validator {
    public final static String DATE_REGEXP = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
    public final static String PRODUCT_CODE_REGEXP = "[b|e|m|p|]\\d{1,10}";
    public final static String ORDER_CODE_REGEXP = "o\\d{1,10}";
    public final static String DNI_REGEXP = "\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]";
    public final static String POSTAL_CODE_REGEXP = "0[1-9]|[1-4][0-9]|5[0-2][0-9]|0[1-9]\\d{2}|[1-4]\\d{3}|5[0-2]\\d{2}|53[0-5]";
    public final static String PHONE_NUMBER_REGEXP = "(0034|\\+34|34)\\s?[6-7]\\d{8}";
    public final static String INTEGER_REGEXP = "-?[0-9]+";
    public final static String EMAIL_REGEXP = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public static boolean isValidProductCode(String productCode) {
        return productCode.matches(PRODUCT_CODE_REGEXP);
    }

    public static boolean isValidOrderCode(String orderCode) {
        return orderCode.matches(ORDER_CODE_REGEXP);
    }

    public static boolean isValidDNI(String dni) {
        return dni.matches(DNI_REGEXP);
    }

    public static boolean isValidPostalCode(String postalCode) {
        return postalCode.matches(POSTAL_CODE_REGEXP);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEXP);
    }

    public static boolean isValidInteger(String integer, int min, int max) {
        if (!integer.matches(INTEGER_REGEXP)) {
            return false;
        }
        int value = Integer.parseInt(integer);
        return value >= min && value <= max;
    }

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEXP);
    }
}