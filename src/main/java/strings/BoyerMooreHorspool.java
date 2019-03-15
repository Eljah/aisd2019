package strings;

import java.util.HashMap;

/**
 * Created by eljah32 on 3/15/2019.
 */
public class BoyerMooreHorspool {

    public static void main(String[] args) {
        System.out.println(getFirstEntry("aabbabbaa", "bbcc"));
        System.out.println(getFirstEntry("cdcdcddcc", "cdcdd"));

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
//        for (Character character: offsetTable.keySet())
//        {
//            if (character>='a'&&character<='z')
//            {
//                System.out.println(character+":"+offsetTable.get(character));
//            }
//        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            System.out.println("1k:"+k);
            System.out.println("1j:"+j);
            System.out.println("1i:"+i);
            while (j >= 0 && source.charAt(k) == template.charAt(j)) {
                k--;
                j--;

                System.out.println("  k:"+k);
                System.out.println("  j:"+j);
                System.out.println("  i:"+i);
                System.out.println();
            }
            System.out.println("2k:"+k);
            System.out.println("2j:"+j);
            System.out.println("2i:"+i);
            System.out.println();
            i += offsetTable.get(source.charAt(i));
            System.out.println("3k:"+k);
            System.out.println("3j:"+j);
            System.out.println("3i:"+i);
            System.out.println();
        }
        if (k >= sourceLen - templateLen) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
