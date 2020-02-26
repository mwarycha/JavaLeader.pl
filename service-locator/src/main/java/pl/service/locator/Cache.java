package pl.service.locator;

import pl.service.locator.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

   private List<Service> services;

   public Cache(){
      services = new ArrayList<Service>();
   }

   public Service getService(String serviceName){

      List<Service> servicesFilter = services.stream().filter(
              service -> service.getName().equalsIgnoreCase(serviceName)
      ).collect(Collectors.toList());

      if(servicesFilter.isEmpty()) {
         return null;
      } else {
         return servicesFilter.get(0);
      }
   }

   public void addService(Service newService){

      boolean exists = false;
       
      for (Service service : services) {
         if(service.getName().equalsIgnoreCase(newService.getName())){
            exists = true;
         }
      }
      if(!exists){
         services.add(newService);
      }
   }
}