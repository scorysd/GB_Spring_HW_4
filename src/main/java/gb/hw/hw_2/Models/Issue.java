package gb.hw.hw_2.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private long idcounter = 1L;
    private final long id;
    private final long bookId;
    private final long readerId;
    private final LocalDateTime timeStamp;

    public Issue(long bookId, long readerId) {
        this.id = idcounter++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timeStamp = LocalDateTime.now();
    }
}
