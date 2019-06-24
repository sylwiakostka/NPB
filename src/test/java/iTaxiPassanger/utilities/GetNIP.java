package iTaxiPassanger.utilities;

import java.util.Random;

public class GetNIP {
    public static String generateNIP() {

        Random r = new Random();

        int n1 = Math.round(r.nextInt((9 + 1)));
        int n2 = Math.round(r.nextInt((9 + 1)));
        int n3 = Math.round(r.nextInt((9 + 1)));
        int n4 = Math.round(r.nextInt((9 + 1)));
        int n5 = Math.round(r.nextInt((9 + 1)));
        int n6 = Math.round(r.nextInt((9 + 1)));
        int n7 = Math.round(r.nextInt((9 + 1)));
        int n8 = Math.round(r.nextInt((9 + 1)));
        int n9 = Math.round(r.nextInt((9 + 1)));

        int sum = n1 * 6 + n2 * 5 + n3 * 7 + n4 * 2 + n5 * 3 + n6 * 4 + n7 * 5 + n8 * 6 + n9 * 7;

        int control = sum % 11;
        int n10 = (control == 10) ? 0 : control;

        String nip = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) + String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) + String.valueOf(n9) + String.valueOf(n10);

        return nip;
    }
}


