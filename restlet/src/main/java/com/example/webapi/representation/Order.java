package com.example.webapi.representation;

public class Order {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String petId;


    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }


    private String quantity;


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    private String shipDate;


    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

}
