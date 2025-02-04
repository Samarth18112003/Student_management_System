import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the database");

                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter student roll number: ");
                int rollNumber = scanner.nextInt();

                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO students (name, roll_number) VALUES (?, ?)")) {
                    preparedStatement.setString(1, name);
                    preparedStatement.setInt(2, rollNumber);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Student details inserted successfully!");
                    } else {
                        System.out.println("Failed to insert student details.");
                    }
                }

                connection.close();
                System.out.println("Connection closed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
