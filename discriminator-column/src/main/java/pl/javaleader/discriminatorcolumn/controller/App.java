package pl.javaleader.discriminatorcolumn.controller;

import pl.javaleader.discriminatorcolumn.model.Laptop;
import pl.javaleader.discriminatorcolumn.model.Monitor;
import pl.javaleader.discriminatorcolumn.repositories.LaptopRepository;
import pl.javaleader.discriminatorcolumn.repositories.MonitorRepository;
import pl.javaleader.discriminatorcolumn.repositories.ProductRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

    private final ProductRepository productRepository;
    private final MonitorRepository monitorRepository;
    private final LaptopRepository laptopRepository;

    public App(ProductRepository productRepository, MonitorRepository monitorRepository, LaptopRepository laptopRepository) {
        this.productRepository = productRepository;
        this.monitorRepository = monitorRepository;
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/saveData")
    public void saveData() {

        Laptop laptop  = new Laptop();
        laptop.setName("laptop");
        laptop.setRamSize(100);

        Monitor monitor = new Monitor();
        monitor.setName("monitor");
        monitor.setX(1000);
        monitor.setY(1000);

        productRepository.save(laptop);
        productRepository.save(monitor);

    }

    @GetMapping("/readData")
    public void readData() {
        productRepository.findAll().forEach(product -> {
            System.out.println(product.getName());
        });

        monitorRepository.findAll().forEach(monitorItem -> {
            System.out.println(monitorItem.getName());
            System.out.println(monitorItem.getX());
            System.out.println(monitorItem.getY());

        });

        laptopRepository.findAll().forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getRamSize());
        });
    }

}
