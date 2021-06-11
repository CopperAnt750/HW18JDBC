package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    static final String url = "jdbc:postgresql://localhost:5432/airport";
    static final String user = "postgres";
    static final String password = "postgres";

    public static void main(String[] args) {

        DB db = new DB();
        List<Pilot> pilots = new ArrayList<>();
        pilots = db.getAllPilot();
        List<AirPlane> planes = new ArrayList<>();
        planes = db.getAllPlans();

        int boingNumber = (int) planes.stream().filter(x -> x.getModel().equals("BOING 747")).count();
        int airbusNumber = (int) planes.stream().filter(x -> x.getModel().equals("AIRBUS A320")).count();





    }
}
