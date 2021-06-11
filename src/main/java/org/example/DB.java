package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    final String url = "jdbc:postgresql://localhost:5432/airport";
    final String user = "postgres";
    final String password = "postgres";


    public List<AirPlane> getAllPlans() {
        List<AirPlane> planes = new ArrayList<>();
        String sqlAllPlans = "SELECT * FROM planes";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlAllPlans)) {
            while (resultSet.next()) {

                String model = resultSet.getString("p_model");
                int seats = resultSet.getInt("p_seats");
                int serialNumber = resultSet.getInt("p_serial_number");
                planes.add(new AirPlane(model, serialNumber, seats));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    public List<AirPlane> getPermittedPlanes(Integer id) {
        List<AirPlane> planes = new ArrayList<>();
        String sqlAllPlans = "SELECT * FROM permitted_models WHERE pm_pilot_id=" + id;
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlAllPlans)) {
            while (resultSet.next()) {
                String airplaneModel = resultSet.getString("pm_models");
                planes.add(new AirPlane(airplaneModel));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

    public List<Pilot> getAllPilot() {
        List<Pilot> pilots = new ArrayList<>();
        List<AirPlane> planes = new ArrayList<>();
        String sqlAllPlans = "SELECT * FROM pilots";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlAllPlans)) {
            while (resultSet.next()) {

                String name = resultSet.getString("p_name");
                int pilotId = resultSet.getInt("p_id");
                planes = this.getPermittedPlanes(pilotId);
                pilots.add(new Pilot(name, planes));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return pilots;
    }
}
