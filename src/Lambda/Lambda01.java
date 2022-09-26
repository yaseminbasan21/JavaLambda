package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma program dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/
        List<Integer>sayı=new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        printElStructured(sayı);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n   ***   ");
        printElFunctional(sayı);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n   ***   ");
        printElFunctional1(sayı);//342216113520632165446664813815
        System.out.println("\n   ***   ");
        printElFunctional2(sayı);//34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n   ***   ");
        printCiftElSturctured(sayı);//34 22 16 20 44 66 64 38
        System.out.println("\n   ***   ");
        printCiftElFunctional(sayı);//34 22 16 20 44 66 64 38
        System.out.println("\n   ***   ");
        printCiftElFunctional1(sayı);//34 22 16 20 44 66 64 38
        System.out.println("\n   ***   ");
        printCıftOtzKckFunctional(sayı);//22 16 20
        System.out.println("\n   ***   ");
        printCiftOtzBykFunctional(sayı);//34 22 16 35 20 63 65 44 66 64 81 38


    }

    //Task : "Structured Programming" kullanarak list elemanlarını aynı satırda aralarında bosluk olucak sekilde print ediniz
    public static void printElStructured(List<Integer>sayı){
        for (Integer w:sayı) {
            System.out.print(w+" ");

        }
    }

    //Task : "functional Programming" kullanarak list elemanlarını aynı satırda aralarında bosluk olucak sekilde print ediniz

     public static void printElFunctional(List<Integer>sayı){
        sayı.stream().forEach(t-> System.out.print(t+" "));
                      //sayıdan aldıgı her elemanı t ye cakıcak
                      //stream selale demek, islem akısı yapıyor,hangi aksiyonu yapıcaksak
                      // o aksiyon oncesinde list elemanlarını akısa sunuyor burda list'le calıstıgımız icin
                      //hangi collection'la calısıyorsak onun elemanlarını akısa sunar
                      //sayı.stream yaparak sayı elemanlarını akısa sunuyoruz ama dikey olarak
                      //forEach herbirine demek,her birine bu aksiyonu yap demek parantez icindeki
                      //Biz burda once sayıyı alıyoruz sonra stream methoduyla akısa sunuyoruz,
                      //akıstan sonra icerde ne varsa o aksiyona sokuyoruz

    }   /*
            stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
            forEach() :datanin parametresine gore her bir elemanı isler
             t-> : Lambda operatoru
             Lambda Expression-->(parameter list) -> {action body}
             Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir. \\t burda bir parametredir.() da olabilirdi
          -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır. \\t ile System.out.print(t+" ") birbirine baglar
             Body: Expressionları ve statementları içerir.  \\body'den kastı aksiyon

             Bir kod bloğundan oluşan bir body...
             Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
             Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

               () -> {
                double pi = 3.1415;
                   return pi;
                 };
           ahanda tric kosesinde bugun: Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
                                       //Lambda'nın felsefesiyle alakalı
                                       //Cunku mantıken dusun, nasıl yaparım degil ne yaparım diye dusunulurdu
                                       //System.out.print(t+" ") burda soyle yazdır diyerek nasıl yazdırması gerektigini
                                       //soyluyoruz aslında,,,,, hataya da acıktır cunku println i print yapmayı unutursak soru gider
                                       //Kullanıcı hata almasın diye hazır method'lar getiririz o yuzden, buna da Method Reference/call denir

                                       //Yani lambda bisey create etmicek, hazır seyleri surekli kullanıcak

                                       //Ancak Asagidaki ornekteki gibi istedigimiz sonuca ulasamıyacagımız zamanlarda
                                       //Yani library'de istedigimiz sonuca ulastıracak kullanabilecegimiz method olmadıgında
                                       //Lambda expression kullanabiliriz, oyle durumlarda da kullanmak yerine
                                        //Kendimiz method olusturup onu cagırmamız en iyisi

       */


    public static void printElFunctional1(List<Integer>sayı){
        sayı.stream().forEach( System.out::print);//method reference-->System.out yapısından print methodu refere et
                                              //bu action task'deki aynı satıra ve bosluk ile yazmayı karsılamaz
                                              //seed(tohum) method create edilip refere edilmeli
    }

    public static void yazdır(int a){ //verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a+" ");
    }

    public static void printElFunctional2(List<Integer>sayı){
        sayı.stream().forEach( Lambda01::yazdır);
                               //class  :: method
    }

    //Burdaki yazdır method'u gibi method'lara biz seed method'ları diyoruz
    //Cagırıp cagırıp kullanabiliyoruz
    //Ornegin okul application'ında calısıyoruz, karne ortalaması alıcaz
    //yazılıları gireriz o kendisi islem yapar
    //Bu tur aksiyonları standart method'lara baglarız,sonra da cagirir cagirir kullanırız


    //Task: Structured Programming ile list elemanlarının cift olanlarını aynı satırda
    //aralarına bosluk bırakarak print ediniz

    public static void printCiftElSturctured(List<Integer>sayı){

        for (Integer w:sayı) {   //herbirinin
            if (w%2 == 0)    //ciftine bak

            System.out.print(w + " ");  //yazdır

        }
    }

    //Task: Functional Programming ile list elemanlarının cift olanlarını aynı satırda
    //aralarına bosluk bırakarak print ediniz
    public static void printCiftElFunctional(List<Integer>sayı){
        sayı.
                stream().
                filter(t-> t%2==0).
                forEach(Lambda01::yazdır);
    }

    public static boolean ciftBul(int a){ //seed(tohum) method kendisine verilen int degerin cift olmasını kontrol eder

        return a%2==0;

    }

    public static void printCiftElFunctional1(List<Integer>sayı){
        sayı.
                stream(). //List elemanları akısa alındı
                filter(Lambda01::ciftBul). //cift bul method refere edilerek akıstaki elemanlar filtrelendi
                forEach(Lambda01::yazdır); //filtre'den gelen elemanlar yazdır() method refere edilerek print edildi
    }

    //Task : functional Programming ile List elemanlarının 34'dan kucuk ve cift sayı olanlarını
    //aynı satırda aralarına bosluk bırakarak print ediniz

    public static void printCıftOtzKckFunctional(List<Integer>sayı){
        sayı.
                stream().
               // filter(t->t%2==0 && t<34).
                filter(Lambda01::ciftBul). //method ref.
                filter(t-> t<34).  //lambda exp.
                forEach(Lambda01::yazdır);

    }

    //Task : functional Programming ile list elemanlarının 34'den buyuk veya cıft
    //olanlarını aynı satırda aralarına bosluk bırakarak print ediniz

    public static void printCiftOtzBykFunctional(List<Integer>sayı){
        sayı.
                stream().
                filter(t->t%2==0 || t>34).
                //filter(Lambda01::ciftBul). //method ref.
                //filter(t-> t<34).  //lambda exp.
                forEach(Lambda01::yazdır);

    }        //birden cok filter kullanırken dikkat etmemiz gereken yerler var


    public static void yazdir(int i) {
    }
}
