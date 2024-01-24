package gb.hw.hw_2.Services;

import gb.hw.hw_2.Models.IssuesBooks;
import gb.hw.hw_2.Repository.IssuesBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import gb.hw.hw_2.Controllers.IssueRequest;
import gb.hw.hw_2.Models.Issue;
import gb.hw.hw_2.Repository.BookRepository;
import gb.hw.hw_2.Repository.IssueRepository;
import gb.hw.hw_2.Repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssuerService {

    // спринг это все заинжектит

    @Value("${application.max-allowed-book}")
    int maxBook;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    private final IssuesBookRepository issuesBookRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        } else if (readerRepository.getReaderById(request.getReaderId()).getBooksOnHands() > maxBook - 1) {
            throw new RuntimeException("Превышен лимит книг!");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        readerRepository.setBookOnHands(request.getReaderId());
        return issue;
    }

    public Issue getIssueById(long id) {
        return issueRepository.getIssueById(id);
    }

    public List<IssuesBooks> getIssueBooks() {
        List<Issue> issueList = List.copyOf(issueRepository.getAllIssues());
        List<IssuesBooks> res = new ArrayList<>();
        for (Issue is : issueList) {
            res.add(new IssuesBooks(bookRepository.getNameBook(is.getBookId()),
                    readerRepository.getNameReader(is.getReaderId()),
                    issueRepository.getIssueTime(is.getId())));
        }
        return res;
    }

    public List<IssuesBooks> getReaderIssue(long id) {
        List<Issue> readerIssue = List.copyOf(issueRepository.getAllIssues()).stream()
                .filter(it -> Objects.equals(it.getReaderId(), id)).toList();
        List<IssuesBooks> res = new ArrayList<>();
        for (Issue is : readerIssue) {
            res.add(new IssuesBooks(bookRepository.getNameBook(is.getBookId()),
                    readerRepository.getNameReader(is.getReaderId()),
                    issueRepository.getIssueTime(is.getId())));
        }
        log.info(res.toString());
        return res;

    }

    @EventListener(ContextRefreshedEvent.class)
    public void dataExec() {
        log.info("DATA");
        log.info("max book = {}", maxBook);
    }
}



