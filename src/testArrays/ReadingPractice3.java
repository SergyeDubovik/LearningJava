package testArrays;


public class ReadingPractice3 {
    public static void main(String[] args) {
        Cypher1 cypher1 = new Cypher1(7);
        char[] origin = "testmessage".toCharArray();
        char[] encoded = cypher1.encode(origin);
        assertEquals("alzatlzzhnl", new String(encoded));
        char[] decoded = cypher1.decode(encoded);
        assertEquals(new String(origin), new String(decoded));

        Cypher2 cypher2 = new Cypher2(22);
        encoded = cypher2.encode(origin);
        assertEquals("pioxiiowwka", new String(encoded));
        decoded = cypher2.decode(encoded);
        assertEquals(new String(origin), new String(decoded));

        Cypher3 cypher3 = new Cypher3();
        encoded = cypher3.encode(origin);
        assertEquals("tsmsaegsete", new String(encoded));
        decoded = cypher3.decode(encoded);
        assertEquals(new String(origin), new String(decoded));

        String text2 = "fri0itx.eghi+{fi2=)rsl[]tx[/]}lersl[]tx[eutlnt-/-]}};12ihge.lsrte=itue{se;2ite=itue{0=%(i)+;tnlte<;=(o";
        char[] decode = text2.toCharArray();
        cypher3.decode(decode);
        System.out.println(new String(cypher3.decode(decode)));
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("Not equal " + actual);
        }
    }
}

class Cypher1 {
    private int key;

    public Cypher1(int key) {
        this.key = key;
    }

    public char[] encode(char[] text) {
        return apply(text, key);
    }

    public char[] decode(char[] text) {
        return apply(text, 26 - key);
    }

    private char[] apply(char[] text, int key) {
        char[] result = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            int symbolNumber = text[i] - 'a';
            result[i] = (char) ((symbolNumber + key) % 26 + 'a');
        }
        return result;
    }
}

class Cypher2 {
    private int key;

    public Cypher2(int key) {
        this.key = key;
    }

    public char[] encode(char[] text) {
        return apply(text, key);
    }

    public char[] decode(char[] text) {
        return apply(text, 26 - key);
    }

    private char[] apply(char[] text, int key) {
        char[] result = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            int symbolNumber = text[i] - 'a';
            int shift = i % 2 == 0 ? key : 26 - key;
            result[i] = (char) ((symbolNumber + shift) % 26 + 'a');
        }
        return result;
    }
}

class Cypher3 {

    public char[] encode(char[] text) {
        char[] result = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            if (i % 2 == 0) {
                result[i / 2] = text[i];
            } else {
                result[result.length - i / 2 - 1] = text[i];
            }
        }
        return result;
    }
//    "tsmsaegsete"

    public char[] decode(char[] text) {
        char[] result = new char[text.length];
        for (int i = 0; i < (text.length + 1) / 2; i++) {
            result[i * 2] = text[i];
        }
        for (int i = text.length - 1; i > text.length / 2; i--) {
            result[2 * (text.length - i) - 1] = text[i];
        }
        // fri0itx.eghi+{fi2=)rsl[]tx[/]}lersl[]tx[eutlnt-/-]}};12ihge.lsrte=itue{se;2ite=itue{0=%(i)+;tnlte<;=(o
//        int i = 0;
//        for (i = 0; i < text.length; i++) {
//            if (i % 2 == 0) {
//                result[i] = text[i / 2];
//            } else {
//                result[i] = text[result.length - i / 2 - 1];
//            }
//        }
        return result;
    }
}

/*
    1 разобраться с cypher3 (что он делает)
    2 реализовать дешифрование для него, после этого должен работать запуск метода мейн
    3 расшифровать зашифрованую реализацию этого метода
    4 расшифровать "govvnyxoqyyntylnombizdsxqiyebpsbcdwocckqo" (зашировано шифром цезаря)
 */