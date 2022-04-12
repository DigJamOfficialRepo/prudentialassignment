
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.List;

public class XmlComparison {
        @Test
        public void compareXmIFiles(){
    String sourceXML ="", targetXML = "", temp ="";
 try {
     File f1 = new File(System.getProperty("user.dir") + "/src/test/resources/SourceXML.xml");
     File f2 = new File(System.getProperty("user.dir") + "/src/test/resources/TargetXML.xml");
     BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
     BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
     while ((temp = br.readLine()) != null) {
         sourceXML += temp;
     }
     while ((temp = br2.readLine()) != null) {
         targetXML += temp;
     }
     System.out.println("source XML: " + sourceXML);
     System.out.println("Target XML: " + targetXML);
 }
catch(IOException e) {
        e.printStackTrace();
        }
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);
        try {

            DetailedDiff diff = new DetailedDiff(XMLUnit.compareXML(sourceXML, targetXML));
            List<Difference> Diffs = diff.getAllDifferences();
            for (int i = 0; i < Diffs.size(); i++) {
                System.out.println(Diffs.get(0).getControlNodeDetail().getNode().getNodeName() + " :: " + Diffs.get(0).getTestNodeDetail().getNode().getNodeName() + " : : " + Diffs.get(0).getDescription());
            }
            Assert.assertTrue("differences Found in Source and Target xm1 files", diff.getAllDifferences().size() == 0);
        }catch (Exception e){
                    e.printStackTrace();
                }
        }
}

