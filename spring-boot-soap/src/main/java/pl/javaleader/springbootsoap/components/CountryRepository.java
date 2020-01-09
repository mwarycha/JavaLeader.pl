package pl.javaleader.springbootsoap.components;

import pl.javaleader.Country;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pl.javaleader.Currency;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country poland = new Country();
        poland.setCapital("Warszawa");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(37866107);
        countries.put("Poland", poland);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}