package pl.javaleader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeeClient {

    public static final String serverUrl = "http://emp-api.default.svc.cluster.local:8081/getAllEmployees";

    //public static final String serverUrl = "http://localhost:8081/getAllEmployees";

    public static void main(String[] args) {
        SpringApplication.run(EmployeeClient.class, args);
    }

    public static String requestProcessedData(String url){
        RestTemplate request = new RestTemplate();
        String result = request.getForObject(url, String.class);
        return (result);
    }

    @GetMapping("/employee/{id}")
    public static String getEmployeeById1(@PathVariable("id") int id){
        System.out.println("LOG");
        System.out.println(serverUrl);
        String findEmployee = null;
        try {
            String response       = requestProcessedData(serverUrl);
            JSONObject jsonObject = new JSONObject(response);
            String clearData      = jsonObject.getString("data");

            JSONArray all_employess = new JSONArray(clearData);
            for (int i = 0; i < all_employess.length(); i++) {
                JSONObject emp = new JSONObject(all_employess.getString(i));
                int id_employee = Integer.parseInt(emp.getString("id"));
                if(id_employee == id) {
                   findEmployee = emp.toString();
                }
            }

        } catch (Exception e) {
            System.out.println("[ERROR] : [CUSTOM_LOG] : " + e);
        }

        if(findEmployee == null){
            findEmployee = "No Match Found";
        }
        return findEmployee;
    }
}
