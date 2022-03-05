package web.config;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import web.dto.ItemDto;
import web.dto.ShopDto;
import web.model.Item;
import web.model.Shop;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-01T11:57:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_45 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public ShopDto shopToShopDto(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDto shopDto = new ShopDto();

        shopDto.setId( shop.getId() );
        shopDto.setName( shop.getName() );
        shopDto.setDescription( shop.getDescription() );
        shopDto.setEmail( shop.getEmail() );
        shopDto.setPhone( shop.getPhone() );
        shopDto.setCount( shop.getCount() );

        return shopDto;
    }

    @Override
    public Shop shopDtoToShop(ShopDto shopDto) {
        if ( shopDto == null ) {
            return null;
        }

        Shop shop = new Shop();

        shop.setId( shopDto.getId() );
        shop.setName( shopDto.getName() );
        shop.setEmail( shopDto.getEmail() );
        shop.setPhone( shopDto.getPhone() );
        shop.setDescription( shopDto.getDescription() );
        shop.setCount( shopDto.getCount() );

        return shop;
    }

    @Override
    public List<ShopDto> allShopsToShopsDto(Page<Shop> list) {
        if ( list == null ) {
            return null;
        }

        List<ShopDto> list1 = new ArrayList<ShopDto>( list.size() );
        for ( Shop shop : list ) {
            list1.add( shopToShopDto( shop ) );
        }

        return list1;
    }

    @Override
    public ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        return itemDto;
    }

    @Override
    public Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        return item;
    }

    @Override
    public List<ItemDto> allItemsToItemsDto(List<Item> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDto> list1 = new ArrayList<ItemDto>( list.size() );
        for ( Item item : list ) {
            list1.add( itemToItemDto( item ) );
        }

        return list1;
    }
}
