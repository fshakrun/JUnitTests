package ru.netology;

import java.io.Serializable;

public class GameProgress implements Serializable {

    private int health;
    private int weapons;
    private int level;
    private double distance;

    public GameProgress(int health, int weapons, int level, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.level = level;
        this.distance = distance;
    }

    // Теперь тут есть геттеры
    
    public int getHealth() {
        return health;
    }

    public int getWeapons() {
        return weapons;
    }

    public int getLevel() {
        return level;
    }

    public double getDistance() {
        return distance;
    }
}