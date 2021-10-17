package calculator;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {

   int addCalledCoutnt;
    public StringCalculator(){
        this.addCalledCoutnt=0;
    }
    public int add(String input)
    {
        if ( input.length() == 0 ) return 0;
        int sum = 0;
        StringBuilder regex = new StringBuilder("\\n,");
        StringBuilder inputrf = new StringBuilder();
        if(input.startsWith("//")){
            regex.append(input,input.indexOf("//")+2,input.indexOf("\n"));
            inputrf.append(input.substring((input.indexOf("\n"))));
        }else {
            inputrf.append(input);
        }
        boolean negFlag = false;
        List<String> negList = new ArrayList<>();
        for ( String s : inputrf.toString().split("["+regex+"]" )){
            if ( !s.isBlank() && Integer.parseInt(s) < 0 ) {
                negFlag = true;
                negList.add(s+" ");
            }
            sum += s.isBlank()? 0:  Integer.parseInt(s);
        }
        if ( negFlag ) throw new IllegalArgumentException("negatives not allowed "+negList);
        return sum;
    }

    public int GetCalledCount(){
        return addCalledCoutnt;
    }

}