/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leecottrell.testjframelecture;

/**
 *
 * @author lee_c
 */
public class Planet {
    private String name;
    private String gravity;
    private String orbit;

    public Planet() {
    }

    public Planet(String name, String gravity, String orbit) {
        this.name = name;
        this.gravity = gravity;
        this.orbit = orbit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    @Override
    public String toString() {
        return "Planet{" + "name=" + name + ", gravity=" + gravity + ", orbit=" + orbit + '}';
    }
    
    
}
