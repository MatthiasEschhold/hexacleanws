package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api.resource;

import java.util.List;

public class VehicleMasterDataResource {
    private List<EquipmentResource> equipmentList;

    public List<EquipmentResource> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResource> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
