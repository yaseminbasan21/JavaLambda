package Lambda;

import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer>sayı=new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKareyiPrint(sayı);//16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayı);//1332 -124 344 28 3376
        System.out.println("\n   ***   ");
        ciftKarePrint(sayı);//2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n   ***   ");
        maxElemanıBul(sayı);//Optional[15]
                            //halukca :Optional[15]
        System.out.println("\n   ***   ");
        ciftKareMaxBul(sayı);//Optional[36]
        System.out.println("\n   ***   ");
        elemanTopla(sayı);//met. ref :Optional[43]
                          //Lambda exp. :43
        System.out.println("\n   ***   ");
        cıftCarp(sayı);//Optional[48]
                       //48
        System.out.println("\n   ***   ");
        minBulInt(sayı);//Optional[-5]
        System.out.println("\n   ***   ");
        minBulMath(sayı);//Optional[-5]
        System.out.println("\n   ***   ");//
        minBulLambda(sayı);//-5
        System.out.println("\n   ***   ");//
        minBUlByHaluk(sayı);//Optional[-5]
        System.out.println("\n   ***   ");
        bestenBykEnKck(sayı);//7
        System.out.println("\n   ***   ");
        cıftKareKucuktenBuyugePrint(sayı);//4 16 36
        System.out.println("\n   ***   ");
        tekKareBkPrint(sayı);//225 121 49 25 9








    }

    //Task : Functional Programming ile listin cift elemanlarının karelerini aynı satırda
    //bosluk bırakarak print ediniz

    public static void ciftKareyiPrint(List<Integer>sayı){
        sayı.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::yazdır);

                //Burdaki map'le collectionlardaki data saklayan map aynı map degildir
                //Burdaki map islem yapan bir fonksiyondur
                //kendisinden once akıstan gelen elemanları isleme alır
    }

        //map()--> Stream icerisindeki elemanları baska tiplere donusturmek
        //veya uzerlerinde islem yapmak (update) icin Map kullanılmaktadır


     //Task : Functional Programming ile listin tek elemanlarının kuplerinin bir fazlasını
    //aynı satırda aralarına bosluk bırakarak print edin

    public static void tekKupBirFazlaPrint(List<Integer>sayı){
        sayı.
                stream(). //sayılar akısa alındı
                filter(t-> t%2!=0). //tek elemanlar filtrelendi
                map(t->(t*t*t)+1). //tek elemanları kuplerının 1 fazlasına update edildi
                forEach(Lambda01::yazdır); //print edildi
    }

    //Task : Functional Programming ile listin cift elemanlarının karekoklerini
    //aynı satırda aralarına bosluk bırakarak yazdırınız

    public static void ciftKarePrint(List<Integer>sayı){
        sayı.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//method ref-->double deger return eder
                //forEach(Lambda01::yazdır)-->yazdır() method int. calıstıgı icin map'den cıkan double dataları calıstırmaz
                forEach(t-> System.out.print(t+" "));

    }

    //Task : list'in en buyuk elemanını yazdırınız

    public static void maxElemanıBul(List<Integer>sayı){
      Optional<Integer> maxSayı=sayı.stream().reduce(Math::max);//akısa giren elemanları aksiyon sonrası tek eleman haline getirir
                                                                //null olma ihtimaline karsı optional yapar,Or/ okul projesinde 50 ustu
                                                                //alanların ortalamasını bul dedi, 50 ustu alan yoksa islem gerceklesmez
                                                                //Java optional kabul eder ve onlem alır expression'lara karsı

        System.out.println(maxSayı); //cıkan degeri variable'a bagladım, asagıdakı gibi baglamadan direkt de yazdırabilirdim
        System.out.println("halukca :" +sayı.stream().reduce(Math::max));
    }
    //reduce'dan sonra for each yapamayız, variable'a baglarız ya da direkt yazdırırız

    /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carpma toplama vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */

    //Task : List'in cıft elemanların karelerinin en buyugunu print ediniz

    public static void ciftKareMaxBul (List<Integer>sayı){

        System.out.println(sayı.
                stream().
                filter(Lambda01::ciftBul).
                map(t-> t*t).
                reduce(Math::max));//36

        System.out.println("Daha hızlı Integer class : "+sayı.
                stream().
                filter(Lambda01::ciftBul).
                map(t-> t*t).
                reduce(Integer::max));//36 spesific class daha hızlı run olur
    }

    //Task : List'deki tum elemanların toplamını yazdırınız
       //Lambda Expression...
    public static void elemanTopla(List<Integer>sayı){
        //sayı.stream().reduce(Integer::sum);//method referans
        int toplam=sayı.stream().reduce(0,(a,b)->a+b); //burda degerini ben atadıgım icin hata atma ihtimali yok o yuzden optional yap demedi java
        /*
        a ilk degerini her zaman atanan degerden (identity) alır 0
        b degerini her zaman stream()'den akıstan alır
        a ilk degerinden sonraki her degeri action(islem)'den alır
         */
        System.out.println("met. ref :" +sayı.stream().reduce(Integer::sum));//method reference
        Optional<Integer>topla=sayı.stream().reduce(Integer::sum);
        System.out.println("Lambda exp. :" +toplam);//variable a atayıp yazdırdık
    }

    //Task : List'deki cift elemanların carpımını yazdırınız
    public static void cıftCarp (List<Integer>sayı){
      //Method Ref...
        System.out.println( sayı.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //Optional[48]


      //Lambda Expression...
        System.out.println(sayı.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b)));//48
    }



    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    //1. yontem Method Reference --> Integer class
    //2. yontem Method Reference --> Math class
    //3. yontem Lambda Expression
    //4. yontem Method Reference --> Haluk class



    //1. yontem Method Reference --> Integer class
    public static void minBulInt(List<Integer>sayı){
        Optional<Integer> minSayıInteger= sayı.stream().reduce(Integer::min);
        System.out.println(minSayıInteger);

    }


    //2. yontem Method Reference --> Math class
    public static void minBulMath(List<Integer>sayı){
        Optional<Integer> minSayıMath=sayı.stream().reduce(Math::min);
        System.out.println(minSayıMath);

    }
    //3. yontem Lambda Expression
    public static void minBulLambda(List<Integer>sayı){
        int minSayıLambda=sayı.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y ?x:y);  // identity, ilk deger isleme etki etmemeli
        System.out.println(minSayıLambda);                                          //Burda en buyuk deger isleme etki etmeyecegi icin Integer.MAX_VALUE sectik


    }

    //4. yontem Method Reference --> Haluk class
    public static void minBUlByHaluk(List<Integer>sayı){
        Optional<Integer>minSayıHaluk=sayı.stream().reduce(Lambda02::byHalukMin);
        System.out.println(minSayıHaluk);


    }

    public static Integer byHalukMin(int a,int b){ //bu method kendisine verilen iki int degerin en kucugunu return eder
        return a<b?a:b;
    }                                      //bu method bize Integer dondurecegi icin void yapmadık Integer yaptık







    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer>sayı){
       Integer bestenBykEnkck= sayı.
               stream().
               filter(t->t%2!=0 && t>5).
               reduce(Integer.MAX_VALUE,(x,y)->x<y ?x:y); //burayı Lambda::byHalukMin yapıp variable data turunu Optional de yapabilirdik

        System.out.println(bestenBykEnkck);
    }



    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
      public static void cıftKareKucuktenBuyugePrint(List<Integer>sayı){
                sayı.
                stream().//akısa alındı
                filter(Lambda01::ciftBul).//cıft elemanlar filtrelendi
                map(t->t*t).//filtrelenen cift sayı karesi alındı
                sorted().//karesi alınan elemanlar dogal(k->b) sıralandı
                forEach(Lambda01::yazdır);//print edildi

          //sorted() => Dogal duzene gore sıralanmıs, bu akısın elemanlarında olusan bir akıs dondurur
          //sorted() method'u tekrarlı kullanılırsa en son kullanılan aktif olur
      }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

       public static void tekKareBkPrint(List<Integer>sayı){
           sayı.//akıs kaynagı
                   stream().//akısa alındı
                   filter(t-> t%2!=0).//tek elemanlar filtrelendi
                   map(t->t*t).//filtrelenen tek sayı'nın karesi alındı
                   sorted(Comparator.reverseOrder()).//buyukten kucuge istedigi icin ters sıra olur
                   forEach(Lambda01::yazdır);//print edildi

           //Comparator class'ına git, reverseOrder methodu ters sırala demektir
           //sorted diyip parantezin icine yazınca ,icerde yazılana gore sırala demek olur
           //sorted()icine bisey yazmazsak dogal sıraya gor (k->b) sıralar
       }









}
