package gb.hw.hw_2.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Reader {
    public static long idcounter = 1L;
    private final long id;
    private final String name;

    private int booksOnHands;

//    public int getBooksOnHands() {
//        return booksOnHands;
//    }

    public Reader(String name) {
        this.id = idcounter++;
        this.name = name;
        this.booksOnHands = 0;
    }
}
