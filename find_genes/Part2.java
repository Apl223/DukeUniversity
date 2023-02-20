public class Part2 {
    
    public String findSimpleGene (String dna, String startCodon, String stopCodon){
        String result = "";
        dna = dna.toUpperCase();
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
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
        String noATG = findSimpleGene(string1,"ATG","TAA");
        String noTAA = findSimpleGene(string2,"ATG","TAA");
        String noATGTAA = findSimpleGene(string3,"ATG","TAA");
        String withATGTAAmult3 = findSimpleGene(string4,"ATG","TAA");
        String withATGTAAnotmult3 = findSimpleGene(string5,"ATG","TAA");
    }
}