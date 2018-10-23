public class Dop_DZ {
    public static void main(String[] args) {
        String[] strings = {
                "rp  cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj",
                "bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup",
                "wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz",
                "ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox",
                "f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf",
                "zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx",
                "ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz",
                "zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv",
                "ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c"
        };

        for (String x : strings) {
            int countVowel = 0;
            for (char symbol : x.toCharArray()) {
                if (symbol == ('a'))
                    countVowel++;
                if (symbol == ('e'))
                    countVowel++;
                if (symbol == ('i'))
                    countVowel++;
                if (symbol == ('o'))
                    countVowel++;
                if (symbol == ('u'))
                    countVowel++;
                if (symbol == ('y'))
                    countVowel++;
            }
            System.out.println(countVowel);
        }
    }
}


