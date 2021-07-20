package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void init(){
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    @DisplayName("Valid phone number")
    void itShouldValidatePhoneNumberWhenValid() {
        //given
        String phoneNo = "+112233445566";

        //when
        boolean isValid = phoneNumberValidator.test(phoneNo);

        //then
        assertTrue(isValid);

    }
    @Test
    @DisplayName("Invalid phone start")
    void itShouldValidatePhoneNumberWhenStartIsInvalid() {
        //given
        String phoneNo = "+992233445566";

        //when
        boolean isValid = phoneNumberValidator.test(phoneNo);

        //then
        assertFalse(isValid);

    }

    @Test
    @DisplayName("Invalid phone length")
    void itShouldValidatePhoneNumberWhenLengthIsInvalid() {
        //given
        String phoneNo = "+11223344556600";

        //when
        boolean isValid = phoneNumberValidator.test(phoneNo);

        //then
        assertFalse(isValid);

    }

    @ParameterizedTest
    @DisplayName("Test PhoneNums with CSV Source")
    @CsvFileSource(resources = "/phoneNumbers.csv")
    void itShouldValidateAllCsvPhoneNumbers(String input, boolean expected) {
        // moved given to resources

        //when
        boolean isValid = phoneNumberValidator.test(input);

        //then
        assertEquals(isValid, expected);

    }
}
