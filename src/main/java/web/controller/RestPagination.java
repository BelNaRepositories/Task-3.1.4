package web.controller;


import javafx.scene.control.Pagination;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.model.Item;
import web.model.Shop;
import web.model.User;
import web.service.PaginationService;
import web.service.PaginationServiceItem;
import web.service.PaginationServiceShop;

import java.util.List;

@RestController
    @RequestMapping("/shopsItem")
    public class RestPagination
    {
        @Autowired
        PaginationService service;
        PaginationServiceItem serviceI;

        @GetMapping
        public ResponseEntity<List<User>> getAllEmployees(
                @RequestParam(defaultValue = "0") Integer pageNo,
                @RequestParam(defaultValue = "2") Integer pageSize,
                @RequestParam(defaultValue = "id") String sortBy)
        {
            List<User> list = service.getAllEmployees(pageNo, pageSize, sortBy);

            return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
        }
}

