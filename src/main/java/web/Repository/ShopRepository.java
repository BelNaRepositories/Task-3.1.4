package web.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.model.Shop;


@Repository
public interface ShopRepository
        extends PagingAndSortingRepository<Shop, Long> {
}

