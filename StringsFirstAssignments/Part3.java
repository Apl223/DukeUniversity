
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb){
        int counter = 0;
        boolean twooccur = false;
        String find[] = stringb.split(" ");
        for(int i=0; i < find.length; i++){
            
            if(stringa.equals(find[i])){
                counter++;
                if(counter == 2){
                    twooccur = true;
                }
            }
        }
        return twooccur;
    }
    
    public String lastPart (String stringa, String stringb){
        int counter = 0;
        int startIndex = stringb.indexOf(stringa);
        String result = "";            
        if(startIndex >= 0){
            result = stringb.substring(startIndex + stringa.length());
        }
        return result;
    }

   
    public void testing () {
        boolean twoOcc1 = twoOccurrences("by","by us by me by");
        boolean twoOcc2 = twoOccurrences("me","me too me");
        boolean twoOcc3 = twoOccurrences("22","me too");
        boolean twoOcc4 = twoOccurrences("me","me too");
        String lastPartOcc1 = lastPart("us","by us by me by");
        String lastPartOcc2 = lastPart("too","me too me");
        String lastPartOcc3 = lastPart("22","me too");
        String lastPartOcc4 = lastPart("me","me too");
        System.out.print("Two occurences in twoOcc1: "+ twoOcc1 + "\n");
        System.out.print("Two occurences in twoOcc2: "+ twoOcc2 + "\n");
        System.out.print("Two occurences in twoOcc3: "+ twoOcc3 + "\n");
        System.out.print("Two occurences in twoOcc4: "+ twoOcc4 + "\n");
        System.out.print("Stringb that follows stringa in lastPartOcc1: "+ lastPartOcc1 + "\n");
        System.out.print("Stringb that follows stringa in lastPartOcc2: "+ lastPartOcc2 + "\n");
        System.out.print("Stringb that follows stringa in lastPartOcc3: "+ lastPartOcc3 + "\n");
        System.out.print("Stringb that follows stringa in lastPartOcc4: "+ lastPartOcc4 + "\n");
    }
}
