package web.config;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import web.dto.ShopDto;
import web.model.Shop;
import web.model.Shop.ShopBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-28T12:49:09+0300",
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

        return shopDto;
    }

    @Override
    public Shop shopDtoToShop(ShopDto shopDto) {
        if ( shopDto == null ) {
            return null;
        }

        ShopBuilder shop = Shop.builder();

        return shop.build();
    }

    @Override
    public List<ShopDto> allShopsToShopsDto(List<Shop> list) {
        if ( list == null ) {
            return null;
        }

        List<ShopDto> list1 = new ArrayList<ShopDto>( list.size() );
        for ( Shop shop : list ) {
            list1.add( shopToShopDto( shop ) );
        }

        return list1;
    }
}
