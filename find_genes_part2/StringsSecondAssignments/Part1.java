public class Part1 {

    public int findStopCodon (String dna, int startIndex, String stopCodon){
     //startIndex = dna.indexOf("ATG");
     // This method returns the index of the first occurrence of stopCodon
     int currIndex = dna.indexOf(stopCodon,startIndex+3);
     // that appears past startIndex and is a multiple of 3 away from startIndex. 
     if(currIndex % 3 == 0){
        return currIndex;
     }
     else {
        currIndex = dna.indexOf(stopCodon,currIndex+1);
     }
     // If there is no such stopCodon, this method returns the length of the 
     // dna strand.
     return dna.length();
    }
    public String findGene (String dna){
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1){
        return "";
    }
    int findgene = findStopCodon(dna,startIndex,"TAA");
    int findgene2 = findStopCodon(dna,startIndex,"TAG");
    int findgene3 = findStopCodon(dna,startIndex,"TGA");
    int minimum = Math.min(findgene,findgene2);
    int minimum2 = Math.min(minimum,findgene3);
    if (minimum2 == dna.length()){
        return "";
    }
    return dna.substring(startIndex, minimum2);
    }
    public void testFindStopCodon () {
         String dna = "AATGCTTCTATAAC";
         String dna2 = "AATCCTTCTATCAC";
         int codon1 = findStopCodon(dna,0,"TAA");
         int codon2 = findStopCodon(dna,0,"TAA");
         System.out.print(codon1 + "\n");
         System.out.print(codon2 + "\n");
    }
    public void testFindGene (){
        String string1 = "GTTAATAAGTT";
        String string2 = "GTATGGTAATGACT";
        String string3 = "GAATGGAGGTTATAACTGTGAAT";
        String string4 = "TTAATGTTGTCATACGTT";
        String findgene = findGene(string1);
        String findgene2 = findGene(string2);
        String findgene3 = findGene(string3);
        String findgene4 = findGene(string4);
        System.out.print(findgene + "\n");
        System.out.print(findgene2 + "\n");
        System.out.print(findgene3 + "\n");
        System.out.print(findgene4 + "\n");
        printAllGenes(string1);
    }
    public void printAllGenes (String dna){
        dna = "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
        while (true) {
            System.out.println("printing genes" + findGene(dna));
            if (findGene(dna).length() == -1) {
                break;
            }
        }
    }
}