package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateTaskStatusServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int taskId = Integer.parseInt(request.getParameter("taskId"));
        String status = request.getParameter("status");

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE tasks SET status = ? WHERE task_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, taskId);

            ps.executeUpdate();
            con.close();

            response.getWriter().print("success");

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
