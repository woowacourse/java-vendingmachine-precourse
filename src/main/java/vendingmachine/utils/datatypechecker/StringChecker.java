package vendingmachine.utils.datatypechecker;

import java.util.ArrayList;
import java.util.List;

public class StringChecker {

    public static List<String> parseStringBySeparator(String input, char separator){
        int parseBeginIndex = 0 , parseEndIndex =0;
        List<String> parsedStrings = new ArrayList<>();

        while((parseEndIndex = input.indexOf(separator, parseBeginIndex)) != -1 ){
            parsedStrings.add(input.substring(parseBeginIndex, parseEndIndex));
            parseBeginIndex = parseEndIndex +1;
        }

        if(parseBeginIndex < input.length()){
            parsedStrings.add(input.substring(parseBeginIndex)); //마지막 문자열 삽입
        }

        return parsedStrings;
    }

    public static void checkStringLength(String name, String contentType) throws IllegalArgumentException{

        if(name.length() == 0){
            throw new IllegalArgumentException("[ERROR]: " + contentType + "은 빈칸이 될수 없습니다.");
        }

    }
}
