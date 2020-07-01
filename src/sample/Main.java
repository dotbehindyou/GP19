package sample;

import java.sql.*;

public class Main {
    static Connection conn = null;

    public static void main(String[] args) {
        // Beginen Try Catch
        try{
            //Initalisiere den Treiber
            Class.forName("com.mysql.jdbc.Driver");

            //Bau eine Verbindung auf mit dem Connection String
            conn = DriverManager.getConnection("jdbc:mysql://172.16.16.3/GP19_1?user=GP-User&password=1234");

            //Hier wird nacher das Ergebnis (Tabelle) gespeichert.
            ResultSet rs = null;

            // Dieses Objekt führt den SQL code aus
            Statement stmt = conn.createStatement();

            // Führe SQL Code aus
            if (stmt.execute("SELECT Firstname, Lastname, Value FROM Worker \n" +
                    "left join WorkerSalary on Worker.ID = WorkerSalary.WorkerID")) {
                // Setze die Tablle in die lokale Variable
                rs = stmt.getResultSet();
                // Schreibe den Kopfsatz in die Console
                System.out.println("Name \tLastname \tGehalt");
                System.out.println("--------------------------");
                while (rs.next()) {
                    // Gehe jede Zeile einzeln durch
                    String firstname = rs.getString("Firstname"); //Hole die Werte der Spalte
                    String lastname = rs.getString("Lastname");
                    Double money = rs.getDouble("Value");
                    //Gebe die Ergebnisse aus
                    System.out.println(firstname + " \t" + lastname + " \t\t" + money);
                }
            }

        }
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " + ex.getMessage());
        }
        catch (SQLException ex){
            System.out.println("SQLExcpetion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
