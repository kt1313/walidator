package pl.javastart.validator;


class PasswordValidator {
    public static String validation(String password) {
        int validator = 0;
        String invalidPassword = "";
        if (hasPassword5Letters(password.toString())) {
            validator++;
            invalidPassword += "* - Hasło ma mniej niż 5 znaków \n";
        }
        if (consistsSmallLetter(password.toString())) {
            validator++;
            invalidPassword += "* - Hasło nie zawiera małych liter \n";
        }
        ;
        if (consistsCapitalLetter(password.toString())) {
            validator++;
            invalidPassword += "* - Hasło nie zawiera dużych liter \n";
        }
        ;
        if (consistsDigit(password.toString())) {
            validator++;
            invalidPassword += "* - Hasło nie zawiera cyfr \n";
        }
        ;
        return invalidPassword;
    }

    private static boolean hasPassword5Letters(String password) {
        return (password.length() > 4);
    }

    private static boolean consistsSmallLetter(String password) {
        boolean result = false;
        char passwordChar;
        for (int i = 0; i < password.length(); i++) {
            passwordChar = password.charAt(i);
            if (Character.isLowerCase(passwordChar)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean consistsCapitalLetter(String password) {
        boolean result = false;
        char passwordChar;
        for (int i = 0; i < password.length(); i++) {
            passwordChar = password.charAt(i);
            if (Character.isUpperCase(passwordChar)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean consistsDigit(String password) {
        boolean result = false;
        char passwordChar;
        for (int i = 0; i < password.length(); i++) {
            passwordChar = password.charAt(i);
            if (Character.isDigit(passwordChar)) {
                result = true;
                break;
            }
        }
        return result;
    }


}
