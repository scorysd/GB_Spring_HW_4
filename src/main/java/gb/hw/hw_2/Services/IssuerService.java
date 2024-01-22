package gb.hw.hw_2.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import gb.hw.hw_2.Controllers.IssueRequest;
import gb.hw.hw_2.Models.Issue;
import gb.hw.hw_2.Repository.BookRepository;
import gb.hw.hw_2.Repository.IssueRepository;
import gb.hw.hw_2.Repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

  // спринг это все заинжектит
  private final BookRepository bookRepository;
  private final ReaderRepository readerRepository;
  private final IssueRepository issueRepository;

  public Issue issue(IssueRequest request) {
    if (bookRepository.getBookById(request.getBookId()) == null) {
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerRepository.getReaderById(request.getReaderId()) == null) {
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

    Issue issue = new Issue(request.getBookId(), request.getReaderId());
    issueRepository.save(issue);
    return issue;
  }

  public Issue getIssueById(long id) {
    return issueRepository.getIssueById(id);
  }
}
