package es.upm.miw.apaw.api.entities;

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

    @Override
    public String toString() {
        return "Download{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }
}