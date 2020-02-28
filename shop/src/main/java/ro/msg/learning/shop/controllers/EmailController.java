package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dtos.EmailDTO;
import ro.msg.learning.shop.services.EmailService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
    }
}
