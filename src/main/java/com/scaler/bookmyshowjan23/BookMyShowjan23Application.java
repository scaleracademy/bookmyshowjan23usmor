package com.scaler.bookmyshowjan23;

import com.scaler.bookmyshowjan23.models.Language;
import com.scaler.bookmyshowjan23.models.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowjan23Application {

    public static void main(String[] args) {
        Movie movie = new Movie();
//        movie.setLanguage(Language.HINDI);
        SpringApplication.run(BookMyShowjan23Application.class, args);
    }

}
