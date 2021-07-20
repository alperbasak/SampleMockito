package utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNo) {
        return phoneNo.startsWith("+11") && phoneNo.length() == 13;
    }
}
