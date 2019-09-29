package com.example.elasticsearch.load;

import com.example.elasticsearch.jparepository.UserJpaRepository;
import com.example.elasticsearch.model.Users;
import com.example.elasticsearch.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @PostConstruct
    @Transactional
    public void loadAll() {

        operations.putMapping(Users.class);
        System.out.println("Loading Data");
        List<Users> data = getData();
        userJpaRepository.save(data); //saves to H2 DB

        List<Users> usersList = userJpaRepository.findAll(); //Get from H2 DB
        usersRepository.save(usersList); //loads into Elastic
        System.out.printf("Loading Completed");

    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users("Ajay", 123L, "Accounting", 12000L));
        userses.add(new Users("Techie", 1230L, "Accounting", 12000L));
        userses.add(new Users("Jaga", 1234L, "Finance", 22000L));
        userses.add(new Users("Shiva", 124L, "Tech", 21000L));
        userses.add(new Users("Karthick", 14L, "Tech", 21000L));
        userses.add(new Users("Bhuvanesh", 4L, "Accounting", 21000L));
        userses.add(new Users("Kumaran", 1L, "Tech", 22000L));
        userses.add(new Users("Thiru", 1235L, "Accounting", 12000L));
        return userses;
    }
}
