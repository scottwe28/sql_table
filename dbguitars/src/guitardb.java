
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class guitardb {

    public static void main(String[] args) {
        final String QUERY = "select id, model, type, "
                + "strings from guitars";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/s2emp", "river", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("model") + ", "
                        + rs.getString("type") + ", "
                        + rs.getInt("strings"));
            }
        } catch (SQLException ex) {
            System.out.println("Reetrieve SQLException: " + ex.getMessage());

        }
    }
}
