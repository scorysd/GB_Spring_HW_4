package gb.hw.hw_2.Services;


import gb.hw.hw_2.Models.Issue;
import gb.hw.hw_2.Models.IssuesBooks;
import gb.hw.hw_2.Models.Reader;
import gb.hw.hw_2.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    final ReaderRepository repository;

    public List<Reader> getAllReader() {
        return repository.getAllReader();
    }

    public Reader geReaderById(long id) {
        return repository.getReaderById(id);
    }

    public void createReader(String name) {
        repository.createReader(name);
    }

    public List<Reader> deleteReader(long id) {
        repository.deleteReader(id);
        return repository.getAllReader();
    }



}
