package gb.hw.hw_2.Controllers.UI;

import gb.hw.hw_2.Models.Book;
import gb.hw.hw_2.Models.IssuesBooks;
import gb.hw.hw_2.Services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/ui")
public class BookControllerUI {
    
    private final BookService bookService;
    private BookControllerUI(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String tableBook(Model model){
        List<Book> books = bookService.getAllBook();
        log.info(books.toString());
        model.addAttribute("books", books);

        return "books";
    }
}
