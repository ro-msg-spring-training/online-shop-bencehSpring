package ro.msg.learning.shop.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeliveryStrategyConfiguration {


    @Value("${strategy}")
    private String strategy;

    @Bean
    public DeliveryStrategyInterface getDeliveryStrategy() {

        if (this.testIfValueIsFromEnum()) {
            StrategyEnum strategyValue = StrategyEnum.valueOf(strategy.toUpperCase());

            if (strategyValue == StrategyEnum.SINGLE_LOCATION) {
                return new SingleLocationStrategy(); //care implementeaza deliverystrategyinterface si are metoda doAlgorithm
            }
        }

        return new MostAbundantStrategy(); //care si ea implementeaza deliverystrategyinterface si are metoda doAlgoritm
    }

    public boolean testIfValueIsFromEnum() {
        for (StrategyEnum strategyEnum : StrategyEnum.values())
            if (strategyEnum.name().equals(strategy.toUpperCase())) {
                return true;
            }
        return false;
    }

}



