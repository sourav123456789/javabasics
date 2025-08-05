import java.io.*;

public class Files {
    public static void main(String[] args) throws IOException {
        // java file apis
        File dir = new File("files-custom");
        if(!dir.exists()) {
            boolean mkdir = dir.mkdir();
            System.out.println(mkdir);
        }
        String s = "public class TestPowerSystem {\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "    }\n" +
                "}\n";

        File file = new File(dir , "input.txt");
        if(file.createNewFile()) {
            System.out.println("created the file");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write(s);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println("started reading the line!!!");

        String line = reader.readLine();
        while(line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("main method completes");


    }
}
