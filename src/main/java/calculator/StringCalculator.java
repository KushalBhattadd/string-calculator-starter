package calculator;

class StringCalculator {

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
        for ( String s : inputrf.toString().split("["+regex+"]" )){
            if ( !s.isBlank() && Integer.parseInt(s) < 0 ) throw new IllegalArgumentException("negatives not allowed "+Integer.parseInt(s));
            sum += s.isBlank()? 0:  Integer.parseInt(s);
        }
        return sum;
    }

}