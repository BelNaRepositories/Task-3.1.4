package web.dao;

import web.model.Shop;
import java.util.List;

public interface ShopDao {
    List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy);
}
