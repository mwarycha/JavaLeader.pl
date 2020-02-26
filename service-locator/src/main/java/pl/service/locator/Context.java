package pl.service.locator;

import pl.service.locator.service.serviceImpl.ServiceFirstImpl;
import pl.service.locator.service.serviceImpl.ServiceSecondImpl;

public class Context {

   public Object lookup(String jndiName){
    
      if(jndiName.equalsIgnoreCase("ServiceFirstImpl")){
         return new ServiceFirstImpl();
      }
      else if (jndiName.equalsIgnoreCase("ServiceSecondImpl")){
         return new ServiceSecondImpl();
      }
      return null;        
   }
}