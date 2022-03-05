package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.config.MapStructMapper;
import web.dto.ShopDto;
import web.model.Item;
import web.model.Shop;
import web.service.PaginationServiceShop;
import web.service.ShopService;

import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class RestPaginationShop {
    private final MapStructMapper mapper;
    private final ShopService service;

    public RestPaginationShop(MapStructMapper mapper, ShopService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShopDto>> getAllShop(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "6") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Shop> list = service.getAllShops(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<ShopDto>>(mapper.allShopsToShopsDto(list), new HttpHeaders(), HttpStatus.OK);
    }
}