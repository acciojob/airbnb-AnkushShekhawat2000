package com.driver.model;

import java.util.List;

public enum Facility {
    ;

//    GYM,
//    SWIMMING_POOL,
//    BAR,
//    FOOD,
//    PARKING,
//    LAUNDRY;

   private List<Facility> facilities;

    Facility(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
