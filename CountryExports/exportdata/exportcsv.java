import edu.duke.*;
import org.apache.commons.csv.*;

public class exportcsv {
    
    public String countryInfo(CSVParser parser, String country) {
    for (CSVRecord record : parser) {
        String currentCountry = record.get("Country");
        if (currentCountry.contains(country)) {
            String exports = record.get("Exports");
            String value = record.get("Value (dollars)");
            return currentCountry + ": " + exports + ": " + value;
        }
    }
    return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser) {
            String currentexports = record.get("Exports");
            if (currentexports.contains(exportItem1) && currentexports.contains(exportItem2)) {
                String countries = record.get("Country");
                System.out.println(countries);
            }
        }    
    
    }
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            System.out.print("Value: " + value);
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String info = countryInfo(parser, "Nauru");
        System.out.println(info + "\n");
        listExportersTwoProducts(parser,"cocoa","cocoa");        
    }
    public void bigExporterstest(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();    
        bigExporters(parser, "$999,999,999");
    }
}
