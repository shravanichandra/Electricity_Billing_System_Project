package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Connections;
import com.example.demo.repository.ConnectionsRepository;
import com.example.demo.service.ConnectionsService;

@Service
public class ConnectionsServiceImpl implements ConnectionsService {

    @Autowired
    private ConnectionsRepository connectionsRepository;

    // Save a new Connection
    @Override
    public Connections saveConnection(Connections connection) {
        return connectionsRepository.save(connection);
    }

    // Get all Connections
    @Override
    public List<Connections> getAllConnections() {
        return connectionsRepository.findAll();
    }

    // Get a Connection by ID
    @Override
    public Connections getConnectionById(Long id) {
        return connectionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Connection not found with ID: " + id));
    }

    // Update an existing Connection
    @Override
    public Connections updateConnection(Long id, Connections connectionDetails) {
        Connections existingConnection = connectionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Connection not found with ID: " + id));

        existingConnection.setConnName(connectionDetails.getConnName());
        existingConnection.setConnDesc(connectionDetails.getConnDesc());
        existingConnection.setConnDate(connectionDetails.getConnDate());
        existingConnection.setConnType(connectionDetails.getConnType());

        return connectionsRepository.save(existingConnection);
    }

    // Delete a Connection by ID
    @Override
    public void deleteConnection(Long id) {
        if (!connectionsRepository.existsById(id)) {
            throw new RuntimeException("Connection not found with ID: " + id);
        }
        connectionsRepository.deleteById(id);
    }
}
