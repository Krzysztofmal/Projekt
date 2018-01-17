/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorytmy;

/**
 *
 * @author Łukasz
 */
public class Algorytmy {

    public static int AlgorytmKnuthaMorrisaPratta(String wzorzec, String tekst) {
        int m, n, i, j, t;
        int P[] = new int[100];//maksymalna dlugosc wzorca to 100 symboli
        n = tekst.length();
        m = wzorzec.length();

//      obliczenie tablicy P
        P[0] = 0;
        P[1] = 0;
        t = 0;
        for (j = 2; j <= m; j++) {
            while ((t > 0) && (wzorzec.charAt(t) != wzorzec.charAt(j - 1))) {
                t = P[t];
            }
            if (wzorzec.charAt(t) == wzorzec.charAt(j - 1)) {
                t++;
            }
            P[j] = t;
        }
        int z;
        int d = 0;
//      algorytm KMP
        i = 1;
        j = 0;
        while (i <= n - m + 1) {
            j = P[j];
            while ((j < m) && (wzorzec.charAt(j) == tekst.charAt(i + j - 1))) {
                j++;
            }
            if (j == m) {
                System.out.println(i);
                z = i;
                d = i;
            }
            i = i + Math.max(1, j - P[j]);
        }
        return d;
    }

    public static int AlgorytmMiaryOdleglosciLevenshteina(String wzorzec, String tekst) {
        int i, j, m, n, cost;
        int d[][];

        m = wzorzec.length();
        n = tekst.length();

        d = new int[m + 1][n + 1];

        for (i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (j = 1; j <= n; j++) {
            d[0][j] = j;
        }

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (wzorzec.charAt(i - 1) == tekst.charAt(j - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                d[i][j] = Math.min(d[i - 1][j] + 1,
                        Math.min(d[i][j - 1] + 1,
                                d[i - 1][j - 1] + cost));

            }
        }

        return d[m][n];
    }

    public static double porownanieZnakow(String wzorzec, String tekst) {

        double procentPodobienstwa = 0;

        double taSamaLitera = 0;
        double taSamaPozycjaLitery = 0;

        int nTekst = tekst.length();
        int nWzorzec = tekst.length();

        char[] tabWzorzec = wzorzec.replace(" ", "").toLowerCase().toCharArray();
        char[] tabTekst = tekst.replace(" ", "").toLowerCase().toCharArray();

        if (tabWzorzec.length >= tabTekst.length) {
            for (int i = 0; i < tabWzorzec.length; i++) {
                for (int j = 0; j < tabTekst.length; j++) {
                    if (tabWzorzec[i] == tabTekst[j]) {
                        taSamaPozycjaLitery += 1.0;
                        continue;
                    }
                    if (tabTekst[j] == tabWzorzec[i]) {
                        taSamaLitera += 1.0;
                        break;
                    }
                }
                procentPodobienstwa = (((taSamaPozycjaLitery / tabWzorzec.length) * 100) + ((taSamaLitera / tabWzorzec.length) * 100)) / 2;
            }
        } else if (tabWzorzec.length < tabTekst.length) {
            for (int i = 0; i < tabTekst.length; i++) {
                for (int j = 0; j < tabWzorzec.length; j++) {
                    if (tabTekst[i] == tabWzorzec[j]) {
                        taSamaPozycjaLitery += 1.0;
                        continue;
                    }
                    if (tabTekst[i] == tabWzorzec[j]) {
                        taSamaLitera += 1.0;
                        break;
                    }
                }
            }
            procentPodobienstwa = (((taSamaPozycjaLitery / tabTekst.length) * 100) + ((taSamaLitera / tabTekst.length) * 100)) / 2;
        }
        return procentPodobienstwa;
    }

    public static void main(String[] args) {

        String wzorzec = "czlowiek";
        String tekst = "stary czlowiek i morze";
        System.out.print("Indeks poczatkowego wzorca w tekscie: ");
        AlgorytmKnuthaMorrisaPratta(wzorzec, tekst);
        System.out.println("Algorytm MOL: " + AlgorytmMiaryOdleglosciLevenshteina(wzorzec, tekst));

    }

}
