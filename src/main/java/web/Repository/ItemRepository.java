package web.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.model.Item;


@Repository
public interface ItemRepository
        extends PagingAndSortingRepository<Item, Long> {
}
