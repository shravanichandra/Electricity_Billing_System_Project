package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Connections;
import com.example.demo.service.ConnectionsService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    @Autowired
    private ConnectionsService connectionsService;

    // Create a new Connection
    @PostMapping
    public ResponseEntity<Connections> createConnection(@RequestBody Connections connection) {
        return ResponseEntity.ok(connectionsService.saveConnection(connection));
    }

    // Get all Connections
    @GetMapping
    public ResponseEntity<List<Connections>> getAllConnections() {
        return ResponseEntity.ok(connectionsService.getAllConnections());
    }

    // Get Connection by ID
    @GetMapping("/{id}")
    public ResponseEntity<Connections> getConnectionById(@PathVariable Long id) {
        return ResponseEntity.ok(connectionsService.getConnectionById(id));
    }

    // Update a Connection by ID
    @PutMapping("/{id}")
    public ResponseEntity<Connections> updateConnection(@PathVariable Long id, @RequestBody Connections connectionDetails) {
        return ResponseEntity.ok(connectionsService.updateConnection(id, connectionDetails));
    }

    // Delete a Connection by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConnection(@PathVariable Long id) {
        connectionsService.deleteConnection(id);
        return ResponseEntity.ok("Connection with ID " + id + " deleted successfully.");
    }
}
