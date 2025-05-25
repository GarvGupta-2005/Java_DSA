package Strings.Basic;

public class Next_Prev_Char{

    public char nextChar(char c) {
        return (char) ((c - 'a' + 1) % 26 + 'a');
    }

    public char prevChar(char c) {
        return (char) ((c - 'a' - 1 + 26) % 26 + 'a'); // Fixed negative modulo
    }

    //These are the functions used to calculate the next and previous characters in cae if the charcaters are circular
}
