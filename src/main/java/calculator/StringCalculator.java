package calculator;

class StringCalculator {

    public int add(String input)
    {
        if ( input.length() == 0 ) return 0;
        int sum = 0;
        for ( String s : input.split(",") ){
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}