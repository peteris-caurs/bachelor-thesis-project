package com.peteriscaurs.graphqlserver.graphqlserver.utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordEligabilityCheckerTest {

    @Test
    public void testIsEligableShouldReturnFalse() {
        String a = "aaaaaaaaaaaa"; //12
        String aa = "āāāāā"; // 5
        String b = "bb"; // 2
        String c = "cc"; // 2
        String ch = "čč"; // 2
        String d = "dddd"; // 4
        String e = "eeeeeee"; // 7
        String ee = "ēēē"; // 3
        String f = "ff"; // 2
        String g = "gg"; // 2
        String gj = "ģģ"; // 2
        String h = "hh"; // 2
        String i = "iiiiiiiiii"; // 10
        String ii = "īīī"; // 3
        String j = "jjj"; // 3
        String k = "kkkkk"; // 5
        String kj = "ķķ"; // 2
        String l = "llll"; // 4
        String lj = "ļļ"; // 2
        String m = "mmmmm"; // 5
        String n = "nnnnn"; // 5
        String nj = "ņņ"; // 2
        String o = "oooo"; // 4
        String p = "pppp"; // 4
        String r = "rrrrrr"; // 6
        String s = "sssssssss"; // 9
        String sh = "šš"; // 2
        String t = "ttttttt"; // 7
        String u = "uuuuuu"; // 6
        String uu = "ūū"; // 2
        String v = "vvvv"; // 4
        String z = "zzz"; // 3
        String zh = "žž"; // 2

        assertFalse(WordEligabilityChecker.isEligable(a));
        assertFalse(WordEligabilityChecker.isEligable(aa));
        assertFalse(WordEligabilityChecker.isEligable(b));
        assertFalse(WordEligabilityChecker.isEligable(c));
        assertFalse(WordEligabilityChecker.isEligable(ch));
        assertFalse(WordEligabilityChecker.isEligable(d));
        assertFalse(WordEligabilityChecker.isEligable(e));
        assertFalse(WordEligabilityChecker.isEligable(ee));
        assertFalse(WordEligabilityChecker.isEligable(f));
        assertFalse(WordEligabilityChecker.isEligable(g));
        assertFalse(WordEligabilityChecker.isEligable(gj));
        assertFalse(WordEligabilityChecker.isEligable(h));
        assertFalse(WordEligabilityChecker.isEligable(i));
        assertFalse(WordEligabilityChecker.isEligable(ii));
        assertFalse(WordEligabilityChecker.isEligable(j));
        assertFalse(WordEligabilityChecker.isEligable(k));
        assertFalse(WordEligabilityChecker.isEligable(kj));
        assertFalse(WordEligabilityChecker.isEligable(l));
        assertFalse(WordEligabilityChecker.isEligable(lj));
        assertFalse(WordEligabilityChecker.isEligable(m));
        assertFalse(WordEligabilityChecker.isEligable(n));
        assertFalse(WordEligabilityChecker.isEligable(nj));
        assertFalse(WordEligabilityChecker.isEligable(o));
        assertFalse(WordEligabilityChecker.isEligable(p));
        assertFalse(WordEligabilityChecker.isEligable(r));
        assertFalse(WordEligabilityChecker.isEligable(s));
        assertFalse(WordEligabilityChecker.isEligable(sh));
        assertFalse(WordEligabilityChecker.isEligable(t));
        assertFalse(WordEligabilityChecker.isEligable(u));
        assertFalse(WordEligabilityChecker.isEligable(uu));
        assertFalse(WordEligabilityChecker.isEligable(v));
        assertFalse(WordEligabilityChecker.isEligable(z));
        assertFalse(WordEligabilityChecker.isEligable(zh));
    }

    @Test
    public void testIsEligableShouldReturnTrue() {
        String a = "aaaaaaaaaaa"; //11
        String aa = "āāāā"; // 4
        String b = "b"; // 1
        String c = "c"; // 1
        String ch = "č"; // 1
        String d = "ddd"; // 3
        String e = "eeeeee"; // 6
        String ee = "ēē"; // 2
        String f = "f"; // 1
        String g = "g"; // 1
        String gj = "ģ"; // 1
        String h = "h"; // 1
        String i = "iiiiiiiii"; // 9
        String ii = "īī"; // 2
        String j = "jj"; // 2
        String k = "kkkk"; // 4
        String kj = "ķ"; // 1
        String l = "lll"; // 3
        String lj = "ļ"; // 1
        String m = "mmmm"; // 4
        String n = "nnnn"; // 4
        String nj = "ņ"; // 1
        String o = "ooo"; // 3
        String p = "ppp"; // 3
        String r = "rrrrr"; // 5
        String s = "ssssssss"; // 8
        String sh = "š"; // 1
        String t = "tttttt"; // 6
        String u = "uuuuu"; // 5
        String uu = "ū"; // 1
        String v = "vvv"; // 3
        String z = "zz"; // 2
        String zh = "ž"; // 1

        assertTrue(WordEligabilityChecker.isEligable(a));
        assertTrue(WordEligabilityChecker.isEligable(aa));
        assertTrue(WordEligabilityChecker.isEligable(b));
        assertTrue(WordEligabilityChecker.isEligable(c));
        assertTrue(WordEligabilityChecker.isEligable(ch));
        assertTrue(WordEligabilityChecker.isEligable(d));
        assertTrue(WordEligabilityChecker.isEligable(e));
        assertTrue(WordEligabilityChecker.isEligable(ee));
        assertTrue(WordEligabilityChecker.isEligable(f));
        assertTrue(WordEligabilityChecker.isEligable(g));
        assertTrue(WordEligabilityChecker.isEligable(gj));
        assertTrue(WordEligabilityChecker.isEligable(h));
        assertTrue(WordEligabilityChecker.isEligable(i));
        assertTrue(WordEligabilityChecker.isEligable(ii));
        assertTrue(WordEligabilityChecker.isEligable(j));
        assertTrue(WordEligabilityChecker.isEligable(k));
        assertTrue(WordEligabilityChecker.isEligable(kj));
        assertTrue(WordEligabilityChecker.isEligable(l));
        assertTrue(WordEligabilityChecker.isEligable(lj));
        assertTrue(WordEligabilityChecker.isEligable(m));
        assertTrue(WordEligabilityChecker.isEligable(n));
        assertTrue(WordEligabilityChecker.isEligable(nj));
        assertTrue(WordEligabilityChecker.isEligable(o));
        assertTrue(WordEligabilityChecker.isEligable(p));
        assertTrue(WordEligabilityChecker.isEligable(r));
        assertTrue(WordEligabilityChecker.isEligable(s));
        assertTrue(WordEligabilityChecker.isEligable(sh));
        assertTrue(WordEligabilityChecker.isEligable(t));
        assertTrue(WordEligabilityChecker.isEligable(u));
        assertTrue(WordEligabilityChecker.isEligable(uu));
        assertTrue(WordEligabilityChecker.isEligable(v));
        assertTrue(WordEligabilityChecker.isEligable(z));
        assertTrue(WordEligabilityChecker.isEligable(zh));
    }

}