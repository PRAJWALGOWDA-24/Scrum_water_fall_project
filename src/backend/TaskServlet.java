package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;   // servlet is for tomcat 9 and jakarta is for tomcat 10
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TaskServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        int projectId = Integer.parseInt(request.getParameter("projectId"));

        out.print("[");
        boolean first = true;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM tasks WHERE project_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, projectId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (!first) out.print(",");
                first = false;

                out.print("{");
                out.print("\"taskId\":" + rs.getInt("task_id") + ",");
                out.print("\"taskName\":\"" + rs.getString("task_name") + "\",");
                out.print("\"status\":\"" + rs.getString("status") + "\",");
                out.print("\"sprint\":" + rs.getInt("sprint"));
                out.print("}");
            }

            out.print("]");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
