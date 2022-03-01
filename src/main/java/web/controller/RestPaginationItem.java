package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.config.MapStructMapper;
import web.dto.ItemDto;
import web.model.Item;
import web.service.PaginationServiceItem;
import web.service.PaginationServiceShop;

import java.util.List;

@RestController
@RequestMapping("/items")
public class RestPaginationItem {
    private final MapStructMapper mapper;
    private final PaginationServiceItem service;

    public RestPaginationItem(MapStructMapper mapper, PaginationServiceItem service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItem(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Item> list = service.getAllItem(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<ItemDto>>(mapper.allItemsToItemsDto(list), new HttpHeaders(), HttpStatus.OK);
    }
}
