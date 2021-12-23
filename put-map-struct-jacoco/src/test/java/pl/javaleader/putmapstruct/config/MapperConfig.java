package pl.javaleader.putmapstruct.config;

import org.mapstruct.factory.Mappers;
import pl.javaleader.putmapstruct.mappers.CartMapper;
import pl.javaleader.putmapstruct.mappers.ItemMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CartMapper cartMapper() {
        return Mappers.getMapper(CartMapper.class);
    }

    @Bean
    public ItemMapper itemMapper() {
        return Mappers.getMapper(ItemMapper.class);
    }
}
