package gb.hw.hw_2.Controllers;

import gb.hw.hw_2.Models.Book;
import gb.hw.hw_2.Models.Reader;
import gb.hw.hw_2.Services.BookService;
import gb.hw.hw_2.Services.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/all")
    public List<Reader> getAllReaders(){
        return readerService.getAllReader();

    }
    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable long id){
        return readerService.geReaderById(id);
    }
    @PostMapping("/new")
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        readerService.createReader(reader.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }
    @DeleteMapping("/{id}")
    public List<Reader> deleteReader(@PathVariable long id){
        return readerService.deleteReader(id);
    }



}
