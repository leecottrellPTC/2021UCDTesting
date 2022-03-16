package com.leecottrell;

public class Physics {
    private double velocity;
    private double v0, v1;
    private double mass;
    private double force;
    private double acceleration;

    
    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void calcForce(){
        //function stub
        force = mass * acceleration;
    }
    public void avgVelocity(){

        acceleration = (v0 + v1)/2.0;
        //velocity =14.99;   //first refactor can be a cheat to ensure test works
    }

    public Physics(){

    }
    public Physics(double velocity, double v0, double v1, double mass, double force) {
        this.velocity = velocity;
        this.v0 = v0;
        this.v1 = v1;
        this.mass = mass;
        this.force = force;
    }
    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    public double getV0() {
        return v0;
    }
    public void setV0(double v0) {
        this.v0 = v0;
    }
    public double getV1() {
        return v1;
    }
    public void setV1(double v1) {
        this.v1 = v1;
    }
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getForce() {
        return force;
    }
    public void setForce(double force) {
        this.force = force;
    }

    
}
