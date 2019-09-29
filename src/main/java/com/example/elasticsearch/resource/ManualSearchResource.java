package com.example.elasticsearch.resource;

import com.example.elasticsearch.builder.SearchQueryBuilder;
import com.example.elasticsearch.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @GetMapping(value = "/{text}")
    public List<Users> getAll(@PathVariable final String text) {
        return searchQueryBuilder.getAllUserName(text);
    }
}
