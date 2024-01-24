package gb.hw.hw_2.Controllers.UI;

import gb.hw.hw_2.Models.Issue;
import gb.hw.hw_2.Models.IssuesBooks;
import gb.hw.hw_2.Services.IssuerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ui")
public class IssuesControllerUI {

    private final IssuerService issuerService;
    public IssuesControllerUI(IssuerService issuerService) {
        this.issuerService = issuerService;
    }
    @GetMapping("/issues")
    public String issuesTable(Model model){
        List<IssuesBooks> issues = issuerService.getIssueBooks();
        model.addAttribute("issues", issues);
        return "issues";
    }
    @GetMapping("/reader/{id}")
    public String issuesReaderTable(@PathVariable long id, Model model){
        List<IssuesBooks> issues = issuerService.getReaderIssue(id);
        model.addAttribute("readerIssues", issues);
        return "readerIssues";
    }
}
