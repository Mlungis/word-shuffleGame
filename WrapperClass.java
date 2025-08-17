import java.util.ArrayList;
public class WrapperClass
{
    private char letter;
    private boolean shows;
    public WrapperClass(char letter)
    {
        this.letter = letter;
        this.shows = false;
    }
    public void showletter()
    {
        this.shows = true;
    }
    public char getLetter()
    {
        return letter;
    }
    public boolean shows() 
    {
    return this.shows;
    }

    @Override
    public String toString() 
    {
        if(shows == true) 
        {
        return String.valueOf(letter);
       } 
       else
       {
           return "_";
       }
    }
     public static MyArrayList<WrapperClass> loadWord(String word) {
    MyArrayList<WrapperClass> chars = new MyArrayList<>();
    for (int i = 0; i < word.length(); i++) {
        chars.add(i, new WrapperClass(word.charAt(i)));
    }
    return chars;
}

}
