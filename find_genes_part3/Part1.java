import edu.duke.*;

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
        String string1 = "GTATGGGTTATAACTGT";
        String string2 = "GTATGGTAATGACT";
        String string3 = "GAATGGAGGTTATAACTGTGAAT";
        String string4 = "TTAATGTTGTCATACGTT";
        String findgene = findGene(string1);
        String findgene2 = findGene(string2);
        String findgene3 = findGene(string3);
        String findgene4 = findGene(string4);
        //System.out.print(findgene + "\n");
        //System.out.print(findgene2 + "\n");
        //System.out.print(findgene3 + "\n");
        //System.out.print(findgene4 + "\n");
        //printAllGenes(string1+ "\n");
        //getAllGenes(string1+ "\n");
        cgRatio(string1 + "\n");
        countCTG(string1 + "\n");
        processGenes(string1);
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
    public StorageResource getAllGenes (String dna){
        // Create an empty StorageResource to store the genes found
        StorageResource geneList = new StorageResource();
        int startIndex = 0;

        while (true) {
            String gene = findGene(dna.substring(startIndex));

            // If no gene is found, break out of the loop
            if (gene.isEmpty()) {
                break;
            }

            // Add the gene to the list
            geneList.add(gene);

            // Update the startIndex to start searching for the next gene
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }
    public double cgRatio(String dna) {
    int countC = 0;
    int countG = 0;

        for (int i = 0; i < dna.length(); i++) {
            char ch = dna.charAt(i);

            if (ch == 'C') {
                countC++;
            } else if (ch == 'G') {
            countG++;
            }
        }
    return (double) (countC + countG) / dna.length();
    }
    
    
    public int countCTG(String dna) {
        int count = 0;
        int index = 0;

        while (true) {
            index = dna.indexOf("CTG", index);
            if (index == -1) {
                break;
            }
            count++;
            index += 3;
        }

        return count;
    }
    
    
    public void processGenes(String dna) {
        StorageResource genes = getAllGenes(dna);
        int countLength = 0;
        int countRatio = 0;
        int longestGene = 0;

    for (String gene : genes.data()) {
        if (gene.length() > 60) {
            System.out.println("Long gene: " + gene);
            countLength++;
        }

        double ratio = cgRatio(gene);
        if (ratio > 0.35) {
            System.out.println("C-G-rich gene: " + gene);
            countRatio++;
        }

        if (gene.length() > longestGene) {
            longestGene = gene.length();
        }
    }

    System.out.println("Number of genes longer than 60 characters: " + countLength);
    System.out.println("Number of genes with a C-G-ratio higher than 0.35: " + countRatio);
    System.out.println("Length of the longest gene: " + longestGene);
    }
}

