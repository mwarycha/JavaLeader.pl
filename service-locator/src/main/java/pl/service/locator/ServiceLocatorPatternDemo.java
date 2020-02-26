package pl.service.locator;

import pl.service.locator.service.Service;

public class ServiceLocatorPatternDemo {
   public static void main(String[] args) {

      Service service = ServiceLocator.getService("ServiceFirstImpl");
      System.out.println(service.getName());
      service = ServiceLocator.getService("ServiceSecondImpl");
      System.out.println(service.getName());
      service = ServiceLocator.getService("ServiceFirstImpl");
      System.out.println(service.getName());
      service = ServiceLocator.getService("ServiceSecondImpl");
      System.out.println(service.getName());
   }
}