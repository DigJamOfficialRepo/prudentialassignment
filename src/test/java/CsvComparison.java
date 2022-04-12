import java.io.*;
import org.junit.Test;

public class CsvComparison {
    @Test
    public void compareCsvFiles() throws FileNotFoundException{
        String srcline= "", targetline = "";
        boolean isSubset = true;
        try {
            File f1 = new File (System.getProperty("user.dir") + "/src/test/resources/Source.csv");
            File f2 = new File(System.getProperty("user.dir") + "/src/test/resources/Target.csv");
            BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(f1)));
            while ((srcline = br.readLine()) != null){
                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
                while ((targetline = br2.readLine()) != null){
                    System.out.println();
                    System.out.println(srcline);
                    System.out.println(targetline);
                    if (srcline.equals(targetline)) {
                        isSubset = true;
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
}