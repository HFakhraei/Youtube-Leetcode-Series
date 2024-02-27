import java.util.HashMap;
import java.util.Map;

class _383_RansomNote {
    public static void main(String[] args) {
        boolean result = canConstruct("aa", "aab");
        System.out.println(result);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : magazine.toCharArray()) {
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
            }
        }
        for (char chr : ransomNote.toCharArray()) {
            if (!map.containsKey(chr) || map.get(chr) == 0)
                return false;
            map.put(chr, map.get(chr) - 1);
        }
        return true;
    }
}

