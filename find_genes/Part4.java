import edu.duke.*;

public class Part4 {
    
    public String urlparse (String URL){
        URLResource ur = new URLResource(URL);
        String printout = "";
        for(String s : ur.lines()) {
            int youtubeIndex = s.toLowerCase().indexOf("youtube.com");
            if (youtubeIndex != -1) {
                int startIndex = s.lastIndexOf("\"", youtubeIndex);
                int lastIndex = s.indexOf("\"", youtubeIndex);
                printout = "Youtube link: " + s.substring(startIndex + 1, lastIndex);
            }
        }
        return printout;
    }
    public void test () {
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        String parse = urlparse(url);
        System.out.print(parse);
    }
}

