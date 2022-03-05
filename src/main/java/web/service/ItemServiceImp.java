package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.ItemDao;
import web.model.Item;
import java.util.List;

@Service
@Transactional
public class ItemServiceImp implements ItemService {
    private final ItemDao itemDao;

    @Autowired
    public ItemServiceImp(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy) {
        return itemDao.getAllItems(pageNo, pageSize, sortBy);
    }
}