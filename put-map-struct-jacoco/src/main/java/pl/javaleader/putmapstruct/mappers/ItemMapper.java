package pl.javaleader.putmapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import pl.javaleader.putmapstruct.dto.Item;
import pl.javaleader.putmapstruct.model.ItemEntity;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    Item itemEntityToDto(ItemEntity itemEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    ItemEntity itemToItemEntity(Item item);
}
