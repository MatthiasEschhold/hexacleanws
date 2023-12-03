package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model;

public class OrderPosition {

    String positionNumber;
    String description;
    double quantity;

    public OrderPosition(String positionNumber, String description, double quantity) {
        this.positionNumber = positionNumber;
        this.description = description;
        this.quantity = quantity;
    }

    public String getPositionNumber() {
        return positionNumber;
    }

    public String getDescription() {
        return description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void changeQuantity(double quantity) {
        this.quantity = quantity;
    }
}
