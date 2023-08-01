package com.automationexcercise.testdata;

import com.automationexcercise.entities.User;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;

public class SingInData {
    @DataProvider(name = "sign-in-data")
    public static Object[][] signInData() {
        return new Object[][]{
                {
                        new User("Juan",
                                "Moncada",
                                LocalDate.of(1988, 05, 07),
                                "juanesteban.moncada+" + String.valueOf(System.currentTimeMillis()) + "@gmail.com",
                                "test", "test",
                                "United States",
                                "Illinois",
                                "Chicago",
                                "1111",
                                "3003000000")
                }
        };
    }
}
