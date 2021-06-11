package org.example;

import java.util.List;

public class Pilot extends Enteties {
    private String name;
    private int age;
    private List<AirPlane> planeList;

    public Pilot(String name, List<AirPlane> planeList) {
        this.name = name;

        this.planeList = planeList;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<AirPlane> getPlaneList() {
        return planeList;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", planeList=" + planeList +
                '}';
    }
}
