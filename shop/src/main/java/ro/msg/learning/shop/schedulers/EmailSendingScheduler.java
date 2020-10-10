package ro.msg.learning.shop.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.EmailDTO;
import ro.msg.learning.shop.dtos.StockDTO;
import ro.msg.learning.shop.services.EmailService;
import ro.msg.learning.shop.services.StockService;
import ro.msg.learning.shop.services.UserService;

import java.util.List;

@Configuration
@Component
@EnableScheduling
@RequiredArgsConstructor
public class EmailSendingScheduler {

    private final EmailService emailService;
    private final UserService userService;
    private final StockService stockService;
    private List<StockDTO> stockList;


    public EmailDTO getEmailDTOData() {
        return EmailDTO.builder()
                .productId(6)
                .username("user")
                .build();
    }

//    @Scheduled(cron = "* * * */1 * *")
//    public void sendEmail() {
//        EmailDTO emailDTO = getEmailDTOData();
//        if (userService.findUserByUsername(emailDTO.getUsername()).getEmailAddress() != null) {
//            stockList = stockService.getAllStocks();
//
//            for (StockDTO stockDTO : stockList) {
//                if (stockDTO.getProductID().equals(emailDTO.getProductId()) && stockDTO.getQuantity() > 0) {
//                    emailService.sendEmail(emailDTO);
//                    return;
//                }
//            }
//        }
//    }
}
