import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesTest {
    public static void main(String[] args) throws IOException {
//        File file=new File("zhujian.txt");
//        file.createNewFile();
        Files.copy(Paths.get("D:\\xml\\ReturnDemo.xml"),Paths.get("C:\\ReturnDemo.xml"));
    }
}
