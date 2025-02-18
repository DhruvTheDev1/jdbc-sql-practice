import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
  public static void main(String[] args) {

    try {
      Connection connection = DriverManager.getConnection(
         // url, username, password
      );

      // ***inserting single records - executes inside mySQL database***
      // *single executeUpdate statements*

      // Statement s = connection.createStatement();
      // s.executeUpdate("INSERT INTO usernames(firstname, lastname) VALUES('Sam',
      // 'Smith')");

      // Statement testQuery = connection.createStatement();
      // testQuery.executeUpdate("INSERT INTO usernames(firstname, lastname)
      // VALUES('Tom', 'Smith')");

      // *Prepared Statements*

      // String query = "INSERT INTO usernames(firstname, lastname) VALUES(?, ?);";

      // // 1st query
      // PreparedStatement ps = connection.prepareStatement(query);
      // ps.setString(1, "Crew");
      // ps.setString(2, "Higgins");

      // ps.addBatch(); // queues up the queries - does not execute it

      // // 2nd query
      // ps.setString(1, "Ada");
      // ps.setString(2, "Lowe");

      // ps.addBatch();
      // ps.executeBatch();

      // ***updating queries***
      // String updateQuery = "UPDATE USERNAMEs SET firstname = ? WHERE idusernames = ?";
      // PreparedStatement psUpdate = connection.prepareStatement(updateQuery);

      // psUpdate.setString(1, "Mike"); // first name
      // // id 5 - Ada Lowe
      // psUpdate.setInt(2, 5); // -> Mike Lowe

      // int x = psUpdate.executeUpdate();
      // System.out.println("Rows affected " + x);

      // *** Searching for a user ***
      // String searchQuery = "SELECT * FROM usernames WHERE lastname = ?";
      // PreparedStatement pSearch = connection.prepareStatement(searchQuery);

      // pSearch.setString(1, "Smith");
      // ResultSet results = pSearch.executeQuery();

      // if (!results.next()) {
      //   System.out.println("No lastnames with Smith");
      // } else {
      //   do {
      //     System.out.println("Id: " + results.getInt("idusernames") );
      //     System.out.println("First Name: " + results.getString("firstname"));
      //     System.out.println("Last Name: " + results.getString("lastname"));
      //     System.out.println("--------------------------");
      //   } while (results.next());
      // }

      // *** Deleting a user ***
      // String deleteQuery = "DELETE FROM usernames WHERE idusernames = ?";
      // PreparedStatement pDelete = connection.prepareStatement(deleteQuery);

      // pDelete.setInt(1, 5);

      // pDelete.executeUpdate();



      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM USERNAMES");

      while (resultSet.next()) {
        System.out.println(resultSet.getInt("idusernames"));
        System.out.println(resultSet.getString("firstname"));
        System.out.println(resultSet.getString("lastname"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
