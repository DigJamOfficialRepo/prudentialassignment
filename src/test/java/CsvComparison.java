import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class CsvComparison {
    @Test
    public void compareCsvFiles() throws FileNotFoundException{
        String srcline= "", targetline = "";
        long srclineCount = 0;
        long targetlineCount = 0;
        boolean isSubset = true;
        try {
            File f1 = new File (System.getProperty("user.dir") + "/src/test/resources/Source.csv");
            File f2 = new File(System.getProperty("user.dir") + "/src/test/resources/Target.csv");
            srclineCount = countLineJava8(f1.getPath() );
            targetlineCount  = countLineJava8(f2.getPath());
            System.out.println("Source file has "+srclineCount+ " records");
            System.out.println("Target file has " + targetlineCount + " records");
            BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(f1)));
            while ((srcline = br.readLine()) != null){
                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
                while ((targetline = br2.readLine()) != null){
                    //System.out.println();
                    //System.out.println(srcline);
                    //System.out.println(targetline);
                    if (srcline.equals(targetline)) {
                        isSubset = true;
                        //srclineCount = srclineCount + 1;
                        break;
                    }
                    isSubset = false;
                }
                if (!isSubset) break;
            }
        }catch(FileNotFoundException e){
                        e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isSubset) System.out.println("source file is a subset of Target file");
        else System.out.println("Source file is not subset of Target file");

    }

    public static long countLineJava8(String fileName) {

        Path path = Paths.get(fileName);

        long lines = 0;
        try {

            // much slower, this task better with sequence access
            //lines = Files.lines(path).parallel().count();

            lines =
                    Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
}

