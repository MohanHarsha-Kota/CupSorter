import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CupSorter {

    public static void main(String[] args) throws IOException {

        //Number of Cups
        int N = 0;
        //HashMap Collection with color names as keys and redius as values
        HashMap<String, Integer> CupMap = new HashMap<>();

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String Input;
            int count = 0;
            int temp;
            while ((Input = in.readLine()) != null&&!Input.isEmpty()) {
                String [] Dataparts;
                if(count == 0) {
                    N = Integer.parseInt(Input);
                    count = 1;
                } else {
                    Dataparts = Input.split(" ");
                        if(isString(Dataparts[0])) {
                            CupMap.put(Dataparts[0],Integer.parseInt(Dataparts[1]));
                        }
                        else
                        {   temp = Integer.parseInt(Dataparts[0]) / 2;
                            CupMap.put(Dataparts[1],temp);
                        }
                    }

                }
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            //Prints the Cups in Sorted order
            Cuporder(CupMap, N);

        }

    static boolean isString(String str) // Returns true if it is a string only
    {
        String pattern = "\\D+"; //Matches Any Non Digit String
        Pattern pobj = Pattern.compile(pattern);
        Matcher mobj = pobj.matcher(str);
        if(mobj.find())
        {
            return true;
        }else {
            return false;
        }
    }

    static void Cuporder(HashMap<String, Integer> Cmap, int N) { //Prints the cups in order from smallest to largest
        final Set<String> entries = Cmap.keySet();
        int x = Integer.MAX_VALUE;
        String c = " ";
        for(int i =0;i<N;i++) {
            for (String entry : entries) {
                int value = Cmap.get(entry);
                if(x>value) //To find the smallest cup
                {
                    x = value;
                    c = entry;

                }
            }
            entries.remove(c); //Removing the smallest cup from the set to find the next smallest cup
            System.out.println(c+" ");
            x = Integer.MAX_VALUE;
        }
    }
}
