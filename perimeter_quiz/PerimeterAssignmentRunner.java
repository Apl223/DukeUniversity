import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int counter = 0;
        
        for (Point currPt : s.getPoints()) {
            counter = counter + 1;
        }
        return counter;
    }

    public double getAverageLength(Shape s) {
        double totalPerim = 0.0;
        double quotient = 0.0;
        double counter = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            counter = counter + 1;
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        quotient = totalPerim/counter;
        return quotient;
    }

    public double getLargestSide(Shape s) {
        double biggestlength = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist > biggestlength){
                biggestlength = currDist;
            }
            prevPt = currPt;            
        }
        return biggestlength;
    }
    public double getLargestX(Shape s) {
        double biggestX = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) { 
            if(currPt.getX() > biggestX){
                biggestX = currPt.getX();
            }            
        }
        return biggestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double biggestPerm = 0.0;
        double length = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            length = getPerimeter(s);
            if (length > biggestPerm){
                biggestPerm = length;
            }
        }
        return length;
    }
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        File temp = null; // replace this code
        String filename = "";
        double biggestPerm = 0.0;
        double length = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            length = getPerimeter(s);
            if (length > biggestPerm){
                biggestPerm = length;
                filename = f.getName();
            }
        }
        return filename;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numpoints = getNumPoints(s);
        double quotient = getAverageLength(s);
        double biggestside = getLargestSide(s);
        double biggestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + numpoints);
        System.out.println("Average length = " + quotient);
        System.out.println("Largest side = " + biggestside);
        System.out.println("Largest X = " + biggestX);
    }
    
    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double perimmultiplefiles = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter from multiple files = " + perimmultiplefiles);
        String filemultiplefiles = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file name from multiple files = " + filemultiplefiles);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
