package web.config;

import org.mapstruct.Mapper;


import org.springframework.data.domain.Page;
import web.dto.ItemDto;
import web.dto.ShopDto;
import web.model.Item;
import web.model.Shop;

import java.util.List;

@Mapper(componentModel = "spring"
//        , uses = MapStructMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface MapStructMapper {

    ShopDto shopToShopDto(Shop shop);
    Shop shopDtoToShop(ShopDto shopDto);
    List<ShopDto> allShopsToShopsDto(List<Shop> list);

//    List<ShopDto> getAllShopDto(Integer pageNo, Integer pageSize, String sortBy)
    ItemDto itemToItemDto(Item item);
    Item itemDtoToItem(ItemDto itemDto);
    List<ItemDto> allItemsToItemsDto(List<Item> list);

}