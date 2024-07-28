package com.example.planetsapp;

public class Planet {

    private String planetName;
    private String moonName;
    private int planetImage;

    public Planet(String planetName, String moonName, int planetImage) {
        this.planetName = planetName;
        this.moonName = moonName;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonName() {
        return moonName;
    }

    public void setMoonName(String moonName) {
        this.moonName = moonName;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
