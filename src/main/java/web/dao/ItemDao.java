package web.dao;

import web.model.Item;
import java.util.List;

public interface ItemDao {
    List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy);
}
