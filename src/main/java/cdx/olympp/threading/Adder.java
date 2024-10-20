package cdx.olympp.threading;

import java.io.IOException;

public class Adder implements Runnable {

    String pathFile;

    public Adder(String pathFile) {
        this.pathFile = pathFile;
    }

    public void doAdd() throws IOException {

    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
