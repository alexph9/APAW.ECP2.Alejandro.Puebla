package es.upm.miw.apaw.entities;

import java.time.LocalDateTime;

public class Download {

    private int price;

    private LocalDateTime date;

    public Download(Integer price) {
        this.price = price;
        this.date = LocalDateTime.now();
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
