package org.wruthless;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {

    private static final String URL = "jdbc:derby:addressbook";
    private static final String USERNAME = "wruth";
    private static final String PASSWORD = "term";

    private Connection connection;
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    public PersonQueries() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Select all entries.
            selectAllPeople = connection.prepareStatement("SELECT * FROM ADDRESSES");

            // Select entries by last name.
            selectPeopleByLastName = connection.prepareStatement("SELECT * FROM ADDRESSES WHERE LASTNAME = ?");

            // Add new entry.
            insertNewPerson = connection.prepareStatement(
                    "INSERT INTO ADDRESSES" + "(FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER) VALUES (?,?,?,?)"
            );

        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }

    } // end Constructor


    public List<Person> getAllPeople() {

        List<Person> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Person>();

            while (resultSet.next()) {
                results.add(new Person(
                        resultSet.getInt("addressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                assert resultSet != null;
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;

    } // end getAllPeople()


    public List<Person> getPeopleByLastName(String name) {

        List<Person> results = null;
        ResultSet resultSet = null;

        try {
            // Specify last name.
            selectPeopleByLastName.setString(1, name);

            // executeQuery returns ResultSet containing matching queries.
            resultSet = selectPeopleByLastName.executeQuery();

            results = new ArrayList<Person>();

            while (resultSet.next()) {
                results.add(new Person(resultSet.getInt("addressID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                assert resultSet != null;
                resultSet.close();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int addPerson(
            String fname, String lname, String email, String num) {

        int result = 0;

        try {
            insertNewPerson.setString(1, fname);
            insertNewPerson.setString(2, lname);
            insertNewPerson.setString(3, email);
            insertNewPerson.setString(4, num);

            // Insert new entry and return rows updated.
            result = insertNewPerson.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }

        return result;

    }


    public void close() {

        try {
            connection.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


}
