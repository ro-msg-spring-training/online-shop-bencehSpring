package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dtos.EmailDTO;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final MailSender mailSender;
    private final ProductService productService;
    private final UserService userService;

    public void sendEmail(EmailDTO emailDTO) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userService.findByUsername(emailDTO.getUsername()).getEmailAddress());
        mail.setFrom("testjmben@gmail.com");
        mail.setSubject("Good news");
        mail.setText("Product " + productService.getProductById(emailDTO.getProductId()).getProductName() + " is back on stock");
        mailSender.send(mail);
    }
}
