package thanhnv.utils;

import thanhnv.constants.EntityCharacter;

import java.util.ArrayList;
import java.util.List;


public class StringUtil {
    public static boolean isNameCharacter(char c){
        return Character.isLetterOrDigit(c) || c == EntityCharacter.UNDERSCORE.getCharacter()
                || c == EntityCharacter.HYPHEN.getCharacter() || c == EntityCharacter.PERIOD.getCharacter();
    }

    public static boolean isStartCharacter(char c){
        return Character.isLetter(c) || c == EntityCharacter.COLON.getCharacter() || c == EntityCharacter.UNDERSCORE.getCharacter();
    }

    public static List<String> getMateResultHotList(){
        List<String> mateResult2 = new ArrayList<>();
        mateResult2.add("cotton");
        mateResult2.add("lyocell");
        mateResult2.add("rayon");
        mateResult2.add("linen");
        return mateResult2;
    }

    public static List<String> getMateResultColdList(){
        List<String> mateResult1 = new ArrayList<>();
        mateResult1.add("polyester");
        mateResult1.add("nylon");
        mateResult1.add("wool");
        mateResult1.add("acrylic");
        mateResult1.add("cashmere");
        mateResult1.add("down");
        return mateResult1;
    }
}
