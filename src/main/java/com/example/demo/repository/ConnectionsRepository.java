package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Connections;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, Long> {
    // Custom queries can be added here if needed
}
