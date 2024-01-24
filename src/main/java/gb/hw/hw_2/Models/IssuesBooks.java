package gb.hw.hw_2.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssuesBooks {

    public static long idcounter = 1L;
    private final long id;
    public final String bookName;
    public final String readerName;
    public final LocalDateTime issuesTime;

    public IssuesBooks(String bookName, String readerName, LocalDateTime issuesTime) {

        this.id = idcounter++;
        this.bookName = bookName;
        this.readerName = readerName;
        this.issuesTime = issuesTime;
    }
}

