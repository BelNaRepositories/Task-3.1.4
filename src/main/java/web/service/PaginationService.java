package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import web.Repository.ItemRepository;
import web.Repository.ShopRepository;
import web.Repository.UserRepositoryy;
import web.model.Item;
import web.model.Shop;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationService {
    @Autowired
    UserRepositoryy repository;


    public List<User> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
}