package pl.javaleader.jasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import pl.javaleader.jasper.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(path = "/generate-pdf", method = RequestMethod.GET)
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:employees.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("spring.datasource", employeeService.findAll());
        params.put("ReportTitle", "First Jasper Report");
        params.put("Author", "JavaLeader.pl");

        return new ModelAndView(view, params);
    }
}