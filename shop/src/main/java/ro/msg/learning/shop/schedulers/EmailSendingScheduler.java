package ro.msg.learning.shop.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.services.EmailService;

@Configuration
@Component
@EnableScheduling
@RequiredArgsConstructor
public class EmailSendingScheduler {


    private final EmailService emailService;


}
