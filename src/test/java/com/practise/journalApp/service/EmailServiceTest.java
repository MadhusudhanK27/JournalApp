package com.practise.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail() {
        emailService.sendEmail("kmadhusudhanreddy08@gmail.com",
                "You got hired in MFAANG",
                "Congratulations! you mastered GO, Java with Spring Boot and needed cloud skills!! Your package will be 165,000$ USD per year. Please let us know if you have any questions.");

    }
}
