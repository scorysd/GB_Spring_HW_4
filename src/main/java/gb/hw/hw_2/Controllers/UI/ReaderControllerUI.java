package gb.hw.hw_2.Controllers.UI;

import gb.hw.hw_2.Models.Reader;
import gb.hw.hw_2.Services.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ui")
public class ReaderControllerUI {
    private final ReaderService readerService;
    private ReaderControllerUI(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers")
    public String tableReader(Model model){
        List<Reader> readers = readerService.getAllReader();
        model.addAttribute("readers", readers);
        return "readers";
    }
//    @GetMapping("/readers/{id}")
//    public String booksReader(Model model){
//        List<Reader> readers = readerService.getAllReader();
//        model.addAttribute("readers", readers);
//        return "readers";
//    }
}
