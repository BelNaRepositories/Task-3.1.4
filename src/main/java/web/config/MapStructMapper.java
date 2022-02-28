package web.config;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import web.dto.ShopDto;
import web.model.Shop;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring"
//        , uses = MapStructMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface MapStructMapper {

    ShopDto shopToShopDto(Shop shop);
    Shop shopDtoToShop(ShopDto shopDto);
    List<ShopDto> allShopsToShopsDto(List<Shop> list);

//    List<ShopDto> getAllShopDto(Integer pageNo, Integer pageSize, String sortBy)
//    ItemDto itemToItemDto(Item item);
//    Item itemDtoToItem(ItemDto itemDto);


}