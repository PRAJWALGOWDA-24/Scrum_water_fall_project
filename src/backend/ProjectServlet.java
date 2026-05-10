package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectServlet extends HttpServlet {

    // GET → load project
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");

        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.prepareStatement(
                "SELECT project_name, team_size FROM project WHERE id = 1"
            ).executeQuery();

            if (rs.next()) {
                resp.getWriter().print(
                    "{ \"projectName\": \"" + rs.getString(1) +
                    "\", \"teamSize\": " + rs.getInt(2) + " }"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // POST → update project
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("projectName");
        String size = req.getParameter("teamSize");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "UPDATE project SET project_name=?, team_size=? WHERE id=1"
            );

            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(size));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
