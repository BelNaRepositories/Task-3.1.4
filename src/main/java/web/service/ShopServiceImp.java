package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ShopDao;
import web.model.Shop;
import java.util.List;

@Service
@Transactional
public class ShopServiceImp implements ShopService {
    private final ShopDao shopDao;

    @Autowired
    public ShopServiceImp(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shop> getAllShops(Integer pageNo, Integer pageSize, String sortBy) {
        return shopDao.getAllShops(pageNo, pageSize, sortBy);
    }
}