package gb.hw.hw_2.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import gb.hw.hw_2.Models.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new gb.hw.hw_2.Models.Reader("Roman"),
        new gb.hw.hw_2.Models.Reader("Pavel"),
        new gb.hw.hw_2.Models.Reader("Petr"),
        new gb.hw.hw_2.Models.Reader("Maria")
        ));
    }

    public Reader getReaderById(long id) {
        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Reader> getAllReader() {
        return List.copyOf(readers);
    }

    public void createReader(String name) {
        readers.add(new Reader(name));
    }

    public List<Reader> deleteReader(long id) {
        Reader exist = getReaderById(id);
        if (exist == null) {
            System.out.println("Do not exist reader!");
        } else {
            readers.remove(exist);
        }
        return readers;
    }

    public void setBookOnHands(long id) {
        Reader exist = getReaderById(id);
        if (exist == null) {
            System.out.println("Do not exist reader!");
        } else {
            exist.setBooksOnHands(exist.getBooksOnHands() + 1);
        }
    }
    public String getNameReader(long id){
        return getReaderById(id).getName();
    }
}
