package com.leecottrell;

public class Physics {
    private double velocity;
    private double acceleration;
    private double mass;
    private double v0, v1;
    private double time;

    public double avgVelocity(){
        //some math here

        double avgVelo = (v0 + v1) / 2;

        return avgVelo;
    }

    public double calcForce(){
        //do math here

        return 100;     //a simple cheat to move on, it is not finished
    }
    public Physics(double velocity, double acceleration, double mass, double v0, double v1, double time) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        this.v0 = v0;
        this.v1 = v1;
        this.time = time;
    }

    public Physics() {
    }

    public double getVelocity() {
        return this.velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getMass() {
        return this.mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getV0() {
        return this.v0;
    }

    public void setV0(double v0) {
        this.v0 = v0;
    }

    public double getV1() {
        return this.v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

  

}
