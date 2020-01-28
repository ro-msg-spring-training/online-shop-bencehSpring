package ro.msg.learning.shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTO.StockDTO;
import ro.msg.learning.shop.Services.StockService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/stocks")
public class StockController {

    private final StockService stockService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockDTO newProduct(@RequestBody StockDTO stockDTO) {

        return stockService
                .createStock(stockDTO.getProductID(), stockDTO.getQuantity(), stockDTO.getLocationID());
    }

}
