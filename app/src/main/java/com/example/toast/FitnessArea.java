package com.example.toast;

public class FitnessArea {
    int id ;
    String gymCenterAdress;
    String gymCenterName;

    public FitnessArea() {
    }

    public FitnessArea(String gymCenterAdress, String gymCenterName) {
        this.gymCenterAdress = gymCenterAdress;
        this.gymCenterName = gymCenterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGymCenterAdress() {
        return gymCenterAdress;
    }

    public void setGymCenterAdress(String gymCenterAdress) {
        this.gymCenterAdress = gymCenterAdress;
    }

    public String getGymCenterName() {
        return gymCenterName;
    }

    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }
}
