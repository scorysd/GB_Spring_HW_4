package gb.hw.hw_2.Services;

import gb.hw.hw_2.Models.Book;
import gb.hw.hw_2.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.getAllBooks();
    }
    public Book getBookById(long id){
        return bookRepository.getBookById(id);
    }
    public void createBook(String name, String author){
        bookRepository.createBook(name, author);
    }
    public List<Book> deleteBook(long id){
        bookRepository.deleteBook(id);
        return bookRepository.getAllBooks();
    }
}
