package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TaskDAO {

    // Save new task
    public static void saveTask(int projectId, String taskName, String status, int sprint) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO tasks (project_id, task_name, status, sprint) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, projectId);
            ps.setString(2, taskName);
            ps.setString(3, status);
            ps.setInt(4, sprint);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update task status
    public static void updateTaskStatus(int taskId, String newStatus) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE tasks SET status = ? WHERE task_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newStatus);
            ps.setInt(2, taskId);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
