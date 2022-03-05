package web.service;

import web.model.Shop;
import java.util.List;

public interface ShopService {
    List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy);
}
