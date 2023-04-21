package kz.bitlab.techorda.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBManager;
import kz.bitlab.techorda.db.Tasks;

import java.io.IOException;

@WebServlet(value = "/saveTask")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("task_id"));
        String name = request.getParameter("task_name");
        String description = request.getParameter("task_description");
        String date = request.getParameter("task_date");

        Tasks task = DBManager.getTask(id);
        if(task!=null){
            task.setName(name);
            task.setDeadlineDate(date);
            task.setDescription(description);
            DBManager.updateTask(task);
            response.sendRedirect("/details?task_id="+id);
        }else{
            response.sendRedirect("/");
        }
    }
}
