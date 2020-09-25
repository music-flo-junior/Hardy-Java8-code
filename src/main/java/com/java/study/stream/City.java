package com.java.study.stream;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 09. 25
 */
public class City {
    private String state;
    private String name;
    private int population;

    public City(String state, String name, int population) {
        this.state = state;
        this.name = name;
        this.population = population;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
