package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.model.Item;
import web.service.PaginationServiceItem;
import java.util.List;

@RestController
@RequestMapping("/items")
public class RestPaginationItem {
    @Autowired
    PaginationServiceItem service;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItem(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Item> list = service.getAllItem(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Item>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
