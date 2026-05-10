package backend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectDAO {

    public static int saveProject(String projectName, int teamSize) {
        int projectId = -1;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO projects (project_name, team_size) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, projectName);
            ps.setInt(2, teamSize);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                projectId = rs.getInt(1);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return projectId;
    }
}
