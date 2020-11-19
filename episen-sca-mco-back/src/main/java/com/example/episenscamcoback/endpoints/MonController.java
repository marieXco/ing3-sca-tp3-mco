package com.example.episenscamcoback.endpoints;

import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class MonController {

    @PostMapping("/add/order")
    @ResponseBody
    @CrossOrigin("*")
    public void add_order(@RequestBody String order) throws FileNotFoundException {
        System.out.println(order);
        PrintWriter writer = new PrintWriter("./orders.txt");
        writer.println(order);
        writer.close();
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {
            fh = new FileHandler("./logs.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            System.out.println("dans le try du log");
            logger.info(order);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
