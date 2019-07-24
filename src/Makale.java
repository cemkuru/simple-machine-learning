/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cem kuru
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Makale {

    HashMap<String, Kelime> spor = new HashMap<String, Kelime>();
    HashMap<String, Kelime> ekonomi = new HashMap<String, Kelime>();
    HashMap<String, Kelime> test = new HashMap<String, Kelime>();

    public HashMap<String, Kelime> oku2(String yol) throws IOException {

       
        
        String kelime;
        String[] kelime1;
        File folder = new File(yol);
        File[] listOfFiles = folder.listFiles();
        //StringBuffer sb = new StringBuffer();

        BufferedReader reader = null;
 int sayac1=0;
             int sayac2=0;
        for (int i = 0; i < listOfFiles.length; i++) {
            HashMap<String, Kelime> kelimeler = new HashMap<String, Kelime>();

            reader = new BufferedReader(new FileReader(listOfFiles[i]));
            String line = reader.readLine();
            // String str = line.replaceAll("I", "i").replaceAll("[^\\p{Alpha}]"," ");
            while (line != null) {
                // sb.append(line);
                //sb.append("\n");.replaceAll("[\\p{Punct}]", "").toLowerCase();[^\\p{Alpha}]
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    kelime = st.nextToken();
                    // kelime1 = c.kokBulucu().stringKokBul(kelime);
                    //if (kelime1.length != 0) {
                        kelime = kelime.toLowerCase().toString();
                        if (kelime.length() >= 3) {
                            if (!(kelime.equals("bir") || kelime.equals("hem") || kelime.equals("daha") || kelime.equals("yok")
                                    || kelime.equals("hiç") || kelime.equals("ama") || kelime.equals("son")
                                    || kelime.equals("iki") || kelime.equals("ile") || kelime.equals("bile") || kelime.equals("tek")
                                    || kelime.equals("çok") || kelime.equals("iyi") || kelime.equals("gibi")
                                    || kelime.equals("çünkü") || kelime.equals("böyle") || kelime.equals("sen") || kelime.equals("ben")
                                    || kelime.equals("hiç") || kelime.equals("sadece") || kelime.equals("gel") || kelime.equals("var")
                                    || kelime.equals("bak") || kelime.equals("gör") || kelime.equals("şey") || kelime.equals("için")
                                    || kelime.equals("yap") || kelime.equals("ise") || kelime.equals("sonra") || kelime.equals("her")
                                    || kelime.equals("bil") || kelime.equals("henüz"))) {
                                
                                 if (kelime.length()>3) {
                                     
                                    kelime = kelime.substring(0, 3);
                                }
                                //   & (kelime1.length!=0)
                                if ((!kelimeler.containsKey(kelime))) {
                                    //System.out.println(kelime1[0]);
                                    kelimeler.put(kelime, new Kelime(1, kelime));
                                } else {
                                    if (kelime.length() != 0) {
                                        kelimeler.get(kelime).arttir();
                                    }
                                }
                            
                        }
                    }
                }
                line = reader.readLine();
            }
           
            float a = buNe(spor, kelimeler);

            float b = buNe(ekonomi, kelimeler);

            if (a > b) {
                sayac1++;

                System.out.println(i + "   spor makalesi :   "+ sayac1 +"   "+ listOfFiles[i] ); 
                //System.out.println("Spor olasılıgı :"+a+" Ekonomi Olasılıgı : "+ b);

            } else {
                sayac2++;
                System.out.println(i + "  ekonomi makalsi :  "+ sayac2 +"  "+listOfFiles[i]);   
                // System.out.println("Spor olasılıgı :"+a+" Ekonomi Olasılıgı : "+ b);

            }
        }
        return null;



    }

    public HashMap<String, Kelime> oku(String yol) throws IOException {

        //Zemberek c = new Zemberek(new TurkiyeTurkcesi());


        HashMap<String, Kelime> kelimeler = new HashMap<String, Kelime>();

        String kelime;

        String[] kelime1;

        File folder = new File(yol);

        File[] listOfFiles = folder.listFiles();


        //StringBuffer sb = new StringBuffer();

        BufferedReader reader = null;

        for (int i = 0; i < listOfFiles.length; i++) {

            reader = new BufferedReader(new FileReader(listOfFiles[i]));
            String line = reader.readLine();
            // String str = line.replaceAll("I", "i").replaceAll("[^\\p{Alpha}]"," ");
            while (line != null) {
                // sb.append(line);
                //sb.append("\n");.replaceAll("[\\p{Punct}]", "").toLowerCase();[^\\p{Alpha}]
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    kelime = st.nextToken();
                    kelime = kelime.replaceAll("I", "i").replaceAll("[\\d]", "").replaceAll("[\\p{Punct}]", "");
                   // kelime1 = c.kokBulucu().stringKokBul(kelime);
                    //if (kelime1.length != 0) {
                        kelime = kelime.toLowerCase().toString();
                        if (kelime.length() >= 3) {
                            if (!(kelime.equals("bir") || kelime.equals("hem") || kelime.equals("daha") || kelime.equals("yok")
                                    || kelime.equals("hiç") || kelime.equals("ama") || kelime.equals("son")
                                    || kelime.equals("iki") || kelime.equals("ile") || kelime.equals("bile") || kelime.equals("tek")
                                    || kelime.equals("çok") || kelime.equals("iyi") || kelime.equals("gibi")
                                    || kelime.equals("çünkü") || kelime.equals("böyle") || kelime.equals("sen") || kelime.equals("ben")
                                    || kelime.equals("hiç") || kelime.equals("sadece") || kelime.equals("gel") || kelime.equals("var")
                                    || kelime.equals("bak") || kelime.equals("gör") || kelime.equals("şey") || kelime.equals("için")
                                    || kelime.equals("yap") || kelime.equals("ise") || kelime.equals("sonra") || kelime.equals("her")
                                    || kelime.equals("bil") || kelime.equals("henüz"))) {
                                if (kelime.length()>3) {
                                    kelime = kelime.substring(0, 3);
                                }
                                
                                //   & (kelime1.length!=0)
                                if ((!kelimeler.containsKey(kelime))) {
                                    //System.out.println(kelime1[0]);
                                    kelimeler.put(kelime, new Kelime(1, kelime));
                                } else {
                                   
                                        kelimeler.get(kelime).arttir();
                                    
                                }
                            
                        }
                    }
                }
                line = reader.readLine();
            }
        }

        return kelimeler;

    }

    public int toplamAdet(HashMap<String, Kelime> hp) {

        int toplam = 0;

        Kelime a;

        Set<String> set1 = hp.keySet();

        Iterator<String> iterator1 = set1.iterator();

        while (iterator1.hasNext()) {

            toplam += hp.get(iterator1.next()).adet;

        }

        return toplam;

    }

    public void yaz(HashMap<String, Kelime> hp) {

        Set<String> set1 = hp.keySet();


        Iterator<String> iterator1 = set1.iterator();
        String c;

        while (iterator1.hasNext()) {
            c = iterator1.next();
            System.out.println(c + " adet : " + hp.get(c).adet);

        }


    }

   
    public void sporOku(String yol) throws IOException {

        spor = oku(yol);

    }

    public void ekonomiOku(String yol) throws IOException {

        ekonomi = oku(yol);

    }

    public void testOku(String yol) throws IOException {

        test = oku(yol);

    }

    public float buNe(HashMap<String, Kelime> gmakale, HashMap<String, Kelime> gtest) {

        String kelime;

        float ksayi = 0;

        float adet2 = 0;

        float olasilik = 0;

        //Set<String> set1 = spor.keySet();

        Set<String> set2 = gtest.keySet();

        //Iterator<String> iterator1 = set1.iterator();

        Iterator<String> iterator2 = set2.iterator();

        ksayi = toplamAdet(gmakale);

        while (iterator2.hasNext()) {

            kelime = iterator2.next();

            if (gmakale.containsKey(kelime)) {

                adet2 = gmakale.get(kelime).adet;
            }
            
            
            if (adet2 > 0) {
                float sayi = ((adet2) / (ksayi));

                olasilik += Math.log10(sayi);

                 //System.out.println(olasilik);
            } else {
                //ksayi+=ksayi + gmakale.size();
                //float sayi2 = 1 / (ksayi + gmakale.size());
                olasilik += Math.log10(1 / (ksayi+1));

                //System.out.println("sıfır geldi ");
            }

        }

       // System.out.println("-------------------------------------");
        return olasilik;

    }

    public static void main(String[] args) throws IOException {

        Makale n = new Makale();

         n.ekonomiOku("ekon\\");
        n.sporOku("spor\\");
        n.oku2("test\\");
   

    }
}
