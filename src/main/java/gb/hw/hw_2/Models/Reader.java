package gb.hw.hw_2.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Reader {
    private long idcounter = 1L;
    private final long id;
    private final String name;

    public Reader(String name) {
        this.id = idcounter++;
        this.name = name;
    }
}
