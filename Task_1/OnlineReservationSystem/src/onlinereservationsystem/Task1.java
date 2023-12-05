
package onlinereservationsystem;
import java.sql.*;
import java.util.Scanner;
import java.util.Random;

public class Task1 {

    private static final int min = 1000;
    private static final int max = 9999;

    public static class user {
        private String username;
        private String password;

        Scanner sc = new Scanner(System.in);

        public user() {
        }

        public String getUsername() {
            System.out.println("Enter Username : ");
            username = sc.nextLine();
            return username;
        }

        public String getPassword() {
            System.out.println("Enter Password : ");
            password = sc.nextLine();
            return password;
        }
    }

    public static class PnrRecord {
        private int pnrNumber;
        private String passengerName;
        private String trainNumber;
        private String classType;
        private String journeyDate;
        private String from;
        private String to;

        Scanner sc = new Scanner(System.in);

        public int getpnrNumber() {
            Random random = new Random();
            pnrNumber = random.nextInt(max) + min;
            return pnrNumber;
        }

        public String getPassengerName() {
            System.out.println("Enter the passenger name : ");
            passengerName = sc.nextLine();
            return passengerName;
        }

        public String gettrainNumber() {
            System.out.println("Enter the train number : ");
            trainNumber = sc.nextLine();
            return trainNumber;
        }

        public String getclassType() {
            System.out.println("Enter the class type : ");
            classType = sc.nextLine();
            return classType;
        }

        public String getjourneyDate() {
            System.out.println("Enter the Journey date as 'YYYY-MM-DD' format");
            journeyDate = sc.nextLine();
            return journeyDate;
        }

        public String getfrom() {
            System.out.println("Enter the starting place : ");
            from = sc.nextLine();
            return from;
        }

        public String getto() {
            System.out.println("Enter the destination place :  ");
            to = sc.nextLine();
            return to;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            user u1 = new user();
            String username = u1.getUsername();
            String password = u1.getPassword();
            String url = "jdbc:mysql://localhost:3306/railway_reservation";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    System.out.println("User Connection Granted.\n");

                    // Create the 'reservations' table if not exists
                    String createTableQuery = "CREATE TABLE IF NOT EXISTS reservations (" +
                            "pnr_number INT PRIMARY KEY," +
                            "passenger_name VARCHAR(255)," +
                            "train_number VARCHAR(255)," +
                            "class_type VARCHAR(255)," +
                            "journey_date DATE," +
                            "from_location VARCHAR(255)," +
                            "to_location VARCHAR(255)" +
                            ")";
                    try (Statement statement = connection.createStatement()) {
                        statement.executeUpdate(createTableQuery);
                    }

                    while (true) {
                        System.out.println("Enter the choice : ");
                        System.out.println("1. Insert Record.\n");
                        System.out.println("2. Delete Record.\n");
                        System.out.println("3. Show All Records.\n");
                        System.out.println("4. Exit.\n");
                        int choice = sc.nextInt();

                        if (choice == 1) {
                            PnrRecord p1 = new PnrRecord();
                            int pnr_number = p1.getpnrNumber();
                            String passengerName = p1.getPassengerName();
                            String trainNumber = p1.gettrainNumber();
                            String classType = p1.getclassType();
                            String journeyDate = p1.getjourneyDate();
                            String from = p1.getfrom();
                            String to = p1.getto();

                            String insertQuery = "INSERT INTO reservations VALUES (?, ?, ?, ?, ?, ?, ?)";

                            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                                preparedStatement.setInt(1, pnr_number);
                                preparedStatement.setString(2, passengerName);
                                preparedStatement.setString(3, trainNumber);
                                preparedStatement.setString(4, classType);
                                preparedStatement.setDate(5, java.sql.Date.valueOf(journeyDate));
                                preparedStatement.setString(6, from);
                                preparedStatement.setString(7, to);

                                int rowsAffected = preparedStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    System.out.println("Record added successfully.");
                                } else {
                                    System.out.println("No records were added.");
                                }
                            } catch (SQLException e) {
                                System.err.println("SQLException: " + e.getMessage());
                            }
                        } else if (choice == 2) {
                            System.out.println("Enter the PNR number to delete the record : ");
                            int pnrNumber = sc.nextInt();
                            String deleteQuery = "DELETE FROM reservations WHERE pnr_number = ?";
                            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                                preparedStatement.setInt(1, pnrNumber);
                                int rowsAffected = preparedStatement.executeUpdate();

                                if (rowsAffected > 0) {
                                    System.out.println("Record deleted successfully.");
                                } else {
                                    System.out.println("No records were deleted.");
                                }
                            } catch (SQLException e) {
                                System.err.println("SQLException: " + e.getMessage());
                            }
                        } else if (choice == 3) {
                            String showQuery = "SELECT * FROM reservations";
                            try (PreparedStatement preparedStatement = connection.prepareStatement(showQuery);
                                    ResultSet resultSet = preparedStatement.executeQuery()) {
                                System.out.println("\nAll records printing.\n");
                                while (resultSet.next()) {
                                    int pnrNumber = resultSet.getInt("pnr_number");
                                    String passengerName = resultSet.getString("passenger_name");
                                    String trainNumber = resultSet.getString("train_number");
                                    String classType = resultSet.getString("class_type");
                                    String journeyDate = resultSet.getString("journey_date");
                                    String fromLocation = resultSet.getString("from_location");
                                    String toLocation = resultSet.getString("to_location");

                                    System.out.println("PNR Number: " + pnrNumber);
                                    System.out.println("Passenger Name: " + passengerName);
                                    System.out.println("Train Number: " + trainNumber);
                                    System.out.println("Class Type: " + classType);
                                    System.out.println("Journey Date: " + journeyDate);
                                    System.out.println("From Location: " + fromLocation);
                                    System.out.println("To Location: " + toLocation);
                                    System.out.println("--------------");
                                }
                            } catch (SQLException e) {
                                System.err.println("SQLException: " + e.getMessage());
                            }
                        } else if (choice == 4) {
                            System.out.println("Exiting the program.\n");
                            break;
                        } else {
                            System.out.println("Invalid Choice Entered.\n");
                        }
                    }
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Error loading JDBC driver: " + e.getMessage());
            }
        }
    }
}

