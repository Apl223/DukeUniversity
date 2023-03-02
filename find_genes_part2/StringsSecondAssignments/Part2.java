
public class Part2 {
    int howMany(String stringa, String stringb){
        int count = 0;
        int firstOccur = stringb.indexOf(stringa);
        if (firstOccur > -1) {
            count = count+1;
               
        while (stringb.indexOf(stringa, firstOccur) != -1 && firstOccur != -1) {
            count = count +1;
            firstOccur = stringb.indexOf(stringa, firstOccur+stringa.length());
        }
        count = count -1;
        }
        else {
            count=0;
        }
        return count;
    }
    public void testing () {
        int howmany1 = howMany("GAA","ATGAACGAATTGAATC");
        int howmany2 = howMany("ATG","AAATGACTATGCGTGAA");
        System.out.print(howmany1 +"\n");
        System.out.print(howmany2 +"\n");
    }
}
