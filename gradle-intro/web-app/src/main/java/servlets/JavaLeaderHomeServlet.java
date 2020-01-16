package servlets;

import pl.javaleader.MsgService;
import pl.javaleader.MsgServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "JavaLeaderHomeServlet", urlPatterns = {"home"}, loadOnStartup = 1)
public class JavaLeaderHomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MsgService msgService = new MsgServiceImpl();
        response.getWriter().print(msgService.showMsg());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null) {
            name = "noname";
        }
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response); 
    }
}