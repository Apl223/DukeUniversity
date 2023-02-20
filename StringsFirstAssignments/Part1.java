
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene (String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(startIndex == -1){
            System.out.println("Start index returned -1");
            return result;
        }
        if(stopIndex == -1){
            System.out.println("Stop index returned -1");
            return result;
        }
        result = dna.substring(startIndex,stopIndex+3);
        if(result.length() % 3 == 0){
            System.out.println(result);
        }
        else {
        System.out.println("String was not a multiple of 3.");
        }
        return result;
    }
    
    public void testSimpleGene () {
        String string1 = "GTTAATAAGTT";
        String string2 = "GTATGGTAAAT";
        String string3 = "GAATGGAGGTTA";
        String string4 = "TTAATGTTGTGATAAGTT";
        String string5 = "TTAATGTGTGATAAGTT";
        String noATG = findSimpleGene(string1);
        String noTAA = findSimpleGene(string2);
        String noATGTAA = findSimpleGene(string3);
        String withATGTAAmult3 = findSimpleGene(string4);
        String withATGTAAnotmult3 = findSimpleGene(string5);
    }
}