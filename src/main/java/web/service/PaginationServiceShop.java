package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Repository.ShopRepository;
import web.config.MapStructMapper;
import web.dto.ShopDto;
import web.model.Shop;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationServiceShop {
    @Autowired
    ShopRepository repositoryShop;


    public List<Shop> getAllShop(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Shop> pagedResult = repositoryShop.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Shop>();
        }
    }

}
