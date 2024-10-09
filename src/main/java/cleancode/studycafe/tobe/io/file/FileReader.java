package cleancode.studycafe.tobe.io.file;

import java.util.List;

public interface FileReader<T> {
    List<T> read();
}