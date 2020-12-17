package com.example.boardgamenightinventoryservice;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Inventory")
@org.hibernate.annotations.Immutable
public class Inventory implements Serializable {
    @Id
    @Column(name="Inventory_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryID;

    public Long getInventoryID(){
        return this.inventoryID;
    }
    public void setInventoryID(Long id){
        this.inventoryID = id;
    }
}
