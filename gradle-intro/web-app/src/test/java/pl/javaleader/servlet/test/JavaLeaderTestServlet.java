package pl.javaleader.servlet.test;

import org.mockito.MockitoAnnotations;
import servlets.JavaLeaderHomeServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class JavaLeaderTestServlet {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doGet() throws Exception {

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter);

        new JavaLeaderHomeServlet().doGet(request, response);

        assertEquals("JavaLeader.pl", stringWriter.toString());
    }

    @Test
    public void doPostWithoutName() throws Exception {
        when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);

        new JavaLeaderHomeServlet().doPost(request, response);

        verify(request).setAttribute("user", "noname");
        verify(requestDispatcher).forward(request,response);
    }

    @Test
    public void doPostWithName() throws Exception {
        when(request.getParameter("name")).thenReturn("JavaLeader.pl");
        when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);

        new JavaLeaderHomeServlet().doPost(request, response);

        verify(request).setAttribute("user", "JavaLeader.pl");
        verify(requestDispatcher).forward(request,response);
    }
}