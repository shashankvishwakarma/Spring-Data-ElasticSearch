package com.example.elasticsearch.jparepository;

import com.example.elasticsearch.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
}
