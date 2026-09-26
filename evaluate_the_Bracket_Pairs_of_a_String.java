import java.util.*;

public class evaluate_the_Bracket_Pairs_of_a_String {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        
        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                insideBracket = true;
                key.setLength(0); 
            } else if (c == ')') {
                insideBracket = false;
                String k = key.toString();
                result.append(map.getOrDefault(k, "?"));
            } else {
                if (insideBracket) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
