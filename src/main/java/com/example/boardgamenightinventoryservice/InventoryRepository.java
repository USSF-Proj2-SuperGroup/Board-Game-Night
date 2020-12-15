package com.example.boardgamenightinventoryservice;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long>{
}
