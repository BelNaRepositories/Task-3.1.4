package web.service;

import web.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> getAllItems(Integer pageNo, Integer pageSize, String sortBy);
}