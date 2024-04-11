import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "31qe91f00zhT!31qe91f00zhT!";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, " + "COUNT(*) / COUNT(DISTINCT MONTH(subscription_date))"
                    + "AS average_count " + "FROM purchaselist p " + "WHERE YEAR(subscription_date) = 2018 "
                    + "GROUP BY course_name ");
            while (resultSet.next()) {
                System.out.println("Название курса: " + resultSet.getString("course_name") + ". Среднее количество продаж:  " +
                        resultSet.getObject("average_count") + ".");
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
