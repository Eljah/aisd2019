package strings;

import java.util.HashMap;

/**
 * Created by eljah32 on 3/15/2019.
 */
public class BoyerMooreHorspool {

    public static void main(String[] args) {
        System.out.println(getFirstEntry("aabbabbaa", "bbc"));

    }


    /**
     * Возвращает индекс первого вхождения строки template в строку source, или
     * -1, в случае если вхождение не найдено.
     *
     * @param source   исходная строка, в которой ищется вхождение шаблона.
     * @param template шаблон строки, которая ищется в строке source.
     * @return индекс первого вхождения строки template в строку source, или -1,
     * в случае если вхождение не найдено.
     */
    public static int getFirstEntry(String source, String template) {
        int sourceLen = source.length();
        int templateLen = template.length();
        if (templateLen > sourceLen) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(template.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            while (j >= 0 && source.charAt(k) == template.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(source.charAt(i));
        }
        if (k >= sourceLen - templateLen) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
