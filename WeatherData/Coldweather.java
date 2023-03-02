import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Coldweather {
   
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestRecord = null;
        for (CSVRecord currentRecord : parser) {
            double currentTemp = Double.parseDouble(currentRecord.get("Temperature"));
            if (currentTemp == -9999) {
                continue; // ignore bogus temperature values
            }
            if (coldestRecord == null || currentTemp < Double.parseDouble(coldestRecord.get("Temperature"))) {
                coldestRecord = currentRecord;
            }
        }
        return coldestRecord;
    }
    public String fileWithColdestTemperature() {
    DirectoryResource dirResource = new DirectoryResource();
    CSVRecord coldestRecord = null;
    String coldestFileName = "";
        for (File file : dirResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            CSVRecord currentRecord = coldestHourInFile(fileResource.getCSVParser());
            if (coldestRecord == null || Double.parseDouble(currentRecord.get("Temperature")) < Double.parseDouble(coldestRecord.get("Temperature"))) {
                coldestRecord = currentRecord;
                coldestFileName = file.getName();
            }
        }
        return coldestFileName;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestRecord = null;
        for (CSVRecord record : parser) {
            String humidityStr = record.get("Humidity");
            if (!humidityStr.equals("N/A")) {
                double humidity = Double.parseDouble(humidityStr);
                if (lowestRecord == null || humidity < Double.parseDouble(lowestRecord.get("Humidity"))) {
                    lowestRecord = record;
                }
            }
        }
        return lowestRecord;
    }
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestRecord = null;
        DirectoryResource directoryResource = new DirectoryResource();
        for (File file : directoryResource.selectedFiles()) {
            FileResource fileResource = new FileResource(file);
            CSVRecord currentRecord = lowestHumidityInFile(fileResource.getCSVParser());
            if (lowestRecord == null || Double.parseDouble(currentRecord.get("Humidity")) < Double.parseDouble(lowestRecord.get("Humidity"))) {
                lowestRecord = currentRecord;
            }
        }
        return lowestRecord;
    }
    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord record : parser) {
            double currentTemp = Double.parseDouble(record.get("TemperatureF"));
            if (currentTemp != -9999) {
                totalTemp += currentTemp;
                count++;
            }
        }
        return totalTemp / count;
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord record : parser) {
            int currentHumidity = Integer.parseInt(record.get("Humidity"));
            if (currentHumidity >= value) {
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                if (currentTemp != -9999) {
                    totalTemp += currentTemp;
                    count++;
                }
            }
        }
        return totalTemp / count;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fileResource = new FileResource();
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord lowestRecord = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + lowestRecord.get("Humidity") + " at " + lowestRecord.get("DateUTC"));
    }
    public void testFileWithColdestTemperature() {
        String coldestFileName = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestFileName);
        FileResource fileResource = new FileResource(coldestFileName);
        CSVRecord coldestRecord = coldestHourInFile(fileResource.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldestRecord.get("Temperature"));
        System.out.println("All the temperatures on the coldest day were:");
        CSVParser parser = fileResource.getCSVParser();
        for (CSVRecord record : parser) {
            System.out.println(record.get("DateUTC") + " " + record.get("TimeEST") + " " + record.get("Temperature"));
        }
    }
    public void testAverageTemperatureInFile() {
        FileResource fileResource = new FileResource();
        CSVParser parser = fileResource.getCSVParser();
        double averageTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + averageTemp);
    }
    public void testLowestHumidityInManyFiles() {
        CSVRecord lowestRecord = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestRecord.get("Humidity") + " at " + lowestRecord.get("DateUTC"));
    }
    public void testColdestHourInFile() {
        FileResource fileResource = new FileResource();
        CSVParser parser = fileResource.getCSVParser();
        CSVRecord coldestRecord = coldestHourInFile(parser);
        System.out.println("Coldest temperature was " + coldestRecord.get("Temperature") + " at " + coldestRecord.get("TimeEST"));
    }
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fileResource = new FileResource();
        CSVParser parser = fileResource.getCSVParser();
        int value = 80;
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser, value);
        System.out.println("Average temperature with humidity greater than or equal to " + value + " is " + averageTemp);
    }
}
