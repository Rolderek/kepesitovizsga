package phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if(output == null || output.isEmpty()){
            throw new IllegalArgumentException("Az egyik bementi paraméter null!");
        }

        if( contacts == null){
            throw new IllegalArgumentException("Az egyik bementi paraméter null!");
        }

        Path path = Path.of(output);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (String name :contacts.keySet()) {
                String pn = contacts.get(name);
                bw.write(name + ": " + pn);
                bw.write("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }

    }
}
