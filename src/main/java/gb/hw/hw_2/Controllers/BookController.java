package gb.hw.hw_2.Controllers;

import gb.hw.hw_2.Models.Book;
import gb.hw.hw_2.Repository.BookRepository;
import gb.hw.hw_2.Services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> getAllBook(){
        return bookService.getAllBook();

    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @PostMapping("/new")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.createBook(book.getName(), book.getAuthor());
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }

}

