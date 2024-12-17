package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Connections;

public interface ConnectionsService {
    Connections saveConnection(Connections connection);
    List<Connections> getAllConnections();
    Connections getConnectionById(Long id);
    Connections updateConnection(Long id, Connections connectionDetails);
    void deleteConnection(Long id);
}
