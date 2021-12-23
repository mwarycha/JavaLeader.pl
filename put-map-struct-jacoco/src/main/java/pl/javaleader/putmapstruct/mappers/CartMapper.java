package pl.javaleader.putmapstruct.mappers;

import org.mapstruct.*;
import pl.javaleader.putmapstruct.dto.Cart;
import pl.javaleader.putmapstruct.model.CartEntity;
import pl.javaleader.putmapstruct.model.ItemEntity;
import pl.javaleader.putmapstruct.repositories.ItemRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = ItemMapper.class, componentModel = "spring")
public abstract class CartMapper {

    @Autowired
    ItemRepository itemRepository;

    @Mapping(source = "itemEntities", target = "items",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Cart cartEntityToDto(CartEntity cartEntity);

    @Mapping(source = "items", target = "itemEntities")
    public abstract CartEntity cartToCartEntity (Cart cart, @MappingTarget CartEntity cartEntity);

    Map<String, Integer> cache = new HashMap<>();

    @BeforeMapping
    public void before(Cart cart, @MappingTarget CartEntity cartEntity) {
        cartEntity.itemEntities.forEach(item ->
        {
            System.out.println(item.getId());
        });

        cart.items.forEach(
            item -> {
                cartEntity.itemEntities.forEach(
                    itemEntityRequest -> {
                        ItemEntity findItemEntityFromRepo = itemRepository.getByCode(item.getCode());
                        Optional.ofNullable(findItemEntityFromRepo).ifPresent(findItemEntity -> {
                            if(itemEntityRequest.getCode().equals(findItemEntity.getCode())) {
                                cache.put(item.getCode(), findItemEntity.getId());
                            }
                        });
                    }
                );

            }
        );
    }

    @AfterMapping
    public void after(Cart cart, @MappingTarget CartEntity cartEntity) {
        cart.items.forEach(
            item -> {
                cartEntity.itemEntities.forEach(
                    itemEntityRequest -> {
                        ItemEntity findItemEntityFromRepo = itemRepository.getByCode(item.getCode());
                        Optional.ofNullable(findItemEntityFromRepo).ifPresent(findItemEntity -> {
                            if(itemEntityRequest.getCode().equals(findItemEntity.getCode())) {
                                itemEntityRequest.setId(cache.get(item.getCode()));
                            }
                        });
                    }
                );

            }
        );
    }
}
