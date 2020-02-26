package pl.service.locator;

import pl.service.locator.Cache;
import pl.service.locator.Context;
import pl.service.locator.service.Service;

public class ServiceLocator {

   private static Cache cache;

   static {
      cache = new Cache();        
   }

   public static Service getService(String jndiName){
 
      Service service = cache.getService(jndiName);
 
      if(service != null){
         return service;
      }
      Context context = new Context();
      Service service1 = (Service)context.lookup(jndiName);
      cache.addService(service1);
      return service1;
   }
}