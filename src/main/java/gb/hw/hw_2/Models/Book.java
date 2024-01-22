package gb.hw.hw_2.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
public class Book {
    public static long idcounter = 1L;
    private final long id;
    private final String name;
    private final String author;

    public Book(String name, String author){
        this.id = idcounter++;
        this.name = name;
        this.author=author;
    }
}
