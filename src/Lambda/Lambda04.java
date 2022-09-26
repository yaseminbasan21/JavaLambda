package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

/*
           TASK :
           fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
           pojo class:plan old java object -->model class'ı

 */

    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));


        System.out.println(notOrt74BykUnv(unv));//true       return type oldugu icin sout'un icine yazıyoruz
        System.out.println("\n   ***   ");
        System.out.println(ogrencıSayısı100AzMı(unv));//false
        System.out.println("\n   ***   ");
        System.out.println(matBolumVarMı(unv));//true
        System.out.println("\n   ***   ");
        System.out.print(ogrSayıBkSırala(unv));
        System.out.println("\n   ***   ");
        ogrSayıBkSırala2(unv);
        System.out.println("\n   ***   ");
        System.out.println(notOrtBkSıralıİlkUc(unv));
        System.out.println("\n   ***   ");
        System.out.println(enAzOgrSayısıİkinciUnv(unv));//[Universite{universite='bogazici', bolum='matematik', ogrSayısı=571, notOrt=93]
        System.out.println("mapToInt ile" + notOrt63BykUniOgrSayısıTopla(unv));//4050
        System.out.println("\n   ***   ");
        ogrSayısı333BykNotOrtOrtalamaAl(unv);//OptionalDouble[80.5]
        System.out.println("\n   ***   ");
        System.out.println(mathBolumSayısı(unv));//2
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayısı571dnBykMaxNotOrt(unv));//OptionalInt[81]
        System.out.println("\n   ***   ");
        System.out.println(ogrnSayısı1071AzMinNotOrt(unv));//OptionalInt[74]

    }

    //Task 01-->notOrt'larının 74'den buyuk oldugunu konrol eden pr create ediniz
    public static boolean notOrt74BykUnv( List<Universite> unv){
        return unv.
                stream().
                anyMatch(t-> t.getNotOrt() > 74);

    }

    //Task 02-->ogrenci sayılarının 110'dan az olmadıgını kontrol eden pr create ediniz
    public static boolean ogrencıSayısı100AzMı(List<Universite> unv){
        return unv.
                stream().
                allMatch(t->t.getOgrSayısı()<110);
    }

    //Task 03-->Universite'lerden herhangi birinde "matematik" olup olmadıgını kontrol eden pr create ediniz
    public static boolean matBolumVarMı(List<Universite> unv){
        return unv.
                stream().
                anyMatch(t->t.getBolum().contains("matematik"));
    }

    //Task 04-->Universite'leri ogr sayılarına gore b->k sıralayınız
    public static List<Universite> ogrSayıBkSırala(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayısı).reversed()).
                collect(Collectors.toList());
    }

    public static void ogrSayıBkSırala2(List<Universite> unv){
        unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayısı).reversed()).
                forEach(t-> System.out.println(t+" "));
    }

    //collect()->akıstaki elemanları istenen sarta gore toplar
    //Collectors.toList()->collect'e gore toplanan elemanları list'e cevirir

    //Task 05-->universite'leri notOrt gore b->k sıralayıp ilk 3'unu print ediniz
    public static List<Universite> notOrtBkSıralıİlkUc(List<Universite> unv){
        return unv.
                stream().//akısa alındı
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).//not ort gore buyukten kucuge sıralandı
                limit(3).//akısın ilk 3 elemanı alındı
                collect(Collectors.toList());//akısın ilk 3 elemanı list'e assign edildi
    }

    //Task 06--> ogr. sayısı en az olan 2. universite'yi print ediniz
    public static List<Universite> enAzOgrSayısıİkinciUnv(List<Universite> unv){
        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayısı)).
                limit(2).
                skip(1).
                collect(Collectors.toList());
    }

    //Task 07--> notOrt 63'den buyuk olan uni.'lerin ogrenci sayılarının toplamını print ediniz
    public static int notOrt63BykUniOgrSayısıTopla(List<Universite> unv){
       return unv.
               stream().//akıs var ,objelerin
               filter(t -> t.getNotOrt() > 63).//filtrelendi
               mapToInt(t -> t.getOgrSayısı()).//akıs elemanlarını int data type olarak map eder
               sum();//int degerlerini toplar
               //reduce(Integer::sum);  burda null deger olmasına karsılık exception verebilecegi icin Optional yapmamızı ister
               //reduce(Math::addExact)
               //reduce(0, (t, u) -> t + u);

        //maptoInt() --> bu method akısdaki elemanların data type'nı
        //parametresindeki()degere gore Int data type update eder
    }


    //Task 08-->Ogrenci sayısı 333'den buyuk olan uni.'lerin not ortalamalarının ortalamasını bulun
       public static void ogrSayısı333BykNotOrtOrtalamaAl(List<Universite> unv){
           System.out.println(unv.
                   stream().
                   filter(t -> t.getOgrSayısı() > 333).
                   mapToDouble(t -> t.getNotOrt()).
                   average());//akıstaki elemanların ort alındı
       }

    //maptoDouble() --> bu method akısdaki elemanların data type'nı
    //parametresindeki()degere gore Double data type update eder

    //average() method'u akıstan gelen elemanların ort alır


    //Task 09-->"matematik" bolumlerinin sayısını print ediniz
    public static int mathBolumSayısı(List<Universite> unv){
       return (int) unv.
                stream().
                filter(t -> t.getBolum().contains("matematik")).
                count();//akıstaki eleman sayısını return eder
    }

    //count() method'u filtreden cıkanları saydırır
    //akıstaki eleman sayısını return eder

    //Task 10-->Ogrenci sayıları 571'den fazla olan universite'lerin en buyuk not ort bulun
      public static OptionalInt ogrcSayısı571dnBykMaxNotOrt(List<Universite> unv){

       return unv.
                stream().
                filter(t -> t.getOgrSayısı() > 571).//unv obje akısı filtrelendi
                mapToInt(t->t.getNotOrt()).//akıstaki unv obj notOrt akısı olarak update edildi
                max();//akısın en buyuk degerini return eder
                      //mapToInt yapınca karsımıza cıkar bu method


          /* System.out.println(unv.
                  stream().
                  filter(t -> t.getOgrSayısı() > 571).
                  sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                  findFirst());
              (basta ben boyle dusundum yaptım oldu)
                  */
      }

          //Task 11-->Ogrenci sayıları 1071'den az olan universite'lerin en kucuk not ort'unu bulun
            public static OptionalInt ogrnSayısı1071AzMinNotOrt(List<Universite> unv){
              return unv.
                      stream().
                      filter(t->t.getOgrSayısı()<1071).
                      mapToInt(t->t.getNotOrt()).
                      min();
            }


}
