package gb.hw.hw_2.Repository;

import gb.hw.hw_2.Models.IssuesBooks;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssuesBookRepository {
    public final List<IssuesBooks> issuesBooks;

    public IssuesBookRepository(List<IssuesBooks> issuesBooks) {
        this.issuesBooks = issuesBooks;
    }

    public List<IssuesBooks> getAll() {
        return List.copyOf(issuesBooks);
    }
}
