package Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {


        List<String> yemek = new ArrayList<>(Arrays.asList("küşleme", "adana", "trilice", "havucDilim","trilice", "buryan",
                "yaglama", "kokorec", "arabAsı", "guvec"));

        alfBykTekrarsuz(yemek);//ADANA ARABASI BURYAN GUVEC HAVUCDİLİM KOKOREC KÜŞLEME TRİLİCE YAGLAMA
        System.out.println("\n    ***   ");
        chrSayısıTersSırala(yemek);//10 7 6 5
        System.out.println("\n    ***   ");
        chrSayısıBkSırala(yemek);//adana guvec buryan küşleme trilice trilice yaglama kokorec arabAsı havucDilim
        System.out.println("\n    ***   ");
        sonHarfBkSırala(yemek);//arabAsı buryan havucDilim küşleme trilice trilice kokorec guvec adana yaglama
        System.out.println("\n    ***   ");
        charKaresiCiftElSıralama(yemek);
        System.out.println("\n    ***   ");//100 36
        harfSayısı7denAzKontrol(yemek);//List elemanları 7 harften buyuk
                                       //List elemanları 7 harften buyuk
        System.out.println("\n    ***   ");
        wİleBaslayanElKontrol(yemek);//w ile baslayan yemek yok
        System.out.println("\n    ***   ");
        xİleBitenElKontrol(yemek);//x ile biten eleman yok
        System.out.println("\n    ***   ");
        karakSayısıBykElPrint(yemek);//[havucDilim]
        System.out.println("\n    ***   ");
        ilkElHaricDigrSonHarfSıralıPrint(yemek);//yaglama kokorec guvec küşleme trilice trilice havucDilim buryan arabAsı
    }

        // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
           public static void alfBykTekrarsuz(List<String> yemek){
             yemek.//akıs kaynagı
                     stream().//akısa girdi
                     map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                    // map(t->t.toUpperCase()).//Lambda Ex.  elemanlar buyuk harf update edildi
                     sorted().//alfabetik(natural dogal) sıra yapıldı
                     distinct().//benzersiz ya da tekrarsız hale getirildi
                     forEach(t-> System.out.print(t+" "));//print edildi


               //distinct() =>Bu method tekrarlı elemanları sadece bir kere akısa sokar
               //Bu akısın farklı elemanlarından (Object.equals(Object)'e gore olusan bir akıs dondurur
               //Sıralı akıslar ıcın ,farklı elemanın secimi sabittir
               //(yinelenen ogeler icin, karsılasma sırasında ilk gorunen oge korunur)
               //Sırasız akıslar icin ,herhangi bir kararlılık garantisi verilmez.Stream return eder



           }


        // Task : list elemanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
          public static void chrSayısıTersSırala(List<String> yemek){
               yemek.
                       stream().//akısa alındı
                      // map(t->t.length()).
                       map(String::length).//elemanlar karakter sayısına update edildi
                       sorted(Comparator.reverseOrder()).//ters sıra yapıldı
                       distinct().//benzersiz yapıldı
                       forEach(Lambda01::yazdır);//print edildi
          }

        // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
                  public static void chrSayısıBkSırala(List<String> yemek){
                 yemek.
                         stream().
                         sorted(Comparator.comparing(String::length)).
                         forEach(t-> System.out.print(t+" "));

                   //-e gore sırala dediginde Comparator.comparing diyip
                   //() icine neye gore sıralamasını istiyorsak o method'u yazarız
                  }


        // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
                  public static void sonHarfBkSırala(List<String>yemek){
                  yemek.//akıs kaynagı
                          stream().//akısa alındı
                          sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).//son harf bulup ters sıralandı
                          forEach(t-> System.out.print(t+" "));//print edildi

                  //charAt String'den karakter alırken kullanılır,String'i belirttik burda
                  //String null deger kabul eder, t'ye null deger gelebilir,
                  //ornegin listemde yemekler var,tatlıları filter yaptım ama hicbir tatlı yok,
                  //o zaman filter dan cikan t null olur,null'ı hicbir isleme sokamam o yuzden
                  //null'ı toString yaparak hiclige ceviriyoruz
                  //YANİ t'ye gelen ifade String'den farklı bir ifade olsa bile toString yaparak String'e cevirmis oluyoruz
                  //ondan sonra String Manipulation ifadelerini kullanıyoruz
                  //bu ozel bir durum

                  //!Bu soruda map kullanamayız cunku elemanları degistirmiyoruz,update etmiyoruz,sadece sıralıyoruz
                  }

        // Task : listin elemanlarin karakterlerinin cift sayili karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
                  public static void charKaresiCiftElSıralama(List<String>yemek){
                      yemek.
                              stream().
                              //map.(t->t.lenght()*t.lenght())
                              map(String::length).map(t->t*t).//akıstaki string elemanları boyutlarının karesine update edildi
                              filter(Lambda01::ciftBul).//cift elemanlar filtrelendi
                              sorted(Comparator.reverseOrder()).//ters sıra yapıldı b->>k
                              distinct().//tekrarsız yapıldı
                              forEach(t-> System.out.print(t+" ")) ;//print edildi
                  }


        // Task : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
                  public static void harfSayısı7denAzKontrol(List<String>yemek){
                 //bu amele code
                     boolean kontrol= yemek.stream().allMatch(t -> t.length() <= 7);
                     if (kontrol){
                         System.out.println("List elemanları 7 ve daha az harften olusur");
                     }else System.out.println("List elemanları 7 harften buyuk");
                 //cincix code
                      System.out.println(yemek.
                              stream().
                              allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve daha az harften olusuyor" : "List elemanları 7 harften buyuk");


                     // System.out.println(yemek.stream().map(String::length).allMatch(t -> t < 7));  //benim yaptıgım,,false
                  }

                  /*
                  anyMatch()-->En az bir eleman sartı saglarsa true doner,aksi durumda false return eder
                  allMatch()-->Tum elemanlar sartı saglarsa true,en az bir eleman sartı saglamazsa false return eder
                  noneMatch()-->Hic bir sartı saglamazsa true,en az bir eleman sartı saglarsa false return eder
                   */


                  // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
                       public static void wİleBaslayanElKontrol(List<String>yemek){
                       System.out.println(yemek.
                               stream().
                               //map(String::toUpperCase).
                               noneMatch(t -> t.startsWith("W")) ? "W ile baslayan yemek yok" : "W ile baslayan yemek var");

                       //startsWith()methodu bize String'in ilk harfini verir
                   }


                   // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
                       public static void xİleBitenElKontrol(List<String>yemek){
                           System.out.println(yemek.
                                   stream().
                                   anyMatch(t -> t.endsWith("x"))?"x ile biten eleman var":"x ile biten eleman yok");

                           //en az dedigi icin anyMatch Kullandık
                       }


                    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
                         public static void karakSayısıBykElPrint(List<String>yemek){
                           Stream<String> sonIsım= yemek.
                                     stream().
                                     sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                                    // findFirst());
                                     limit(1);
                             System.out.println(Arrays.toString(sonIsım.toArray()));//array'e cevrilen sonIsım stream print edildi

                             /*
                             sonIsım.toArray()-->limit() meth return'dan dolayı stream type olan sonIsım toArray() method ile array type convert edildi
                          */


                             //akıs cıktısını bir variable assign edilebilir
                            Optional<String> enBykKrEl= yemek.
                                     stream().
                                     sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                                     findFirst();//ilk eleman alındı

                       }
                             //findFirst() method'u bize ilk elemanı al der



                         //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elemanı alır (3 yazarsak ilk 3 , 5 yazarsak ilk 5)
                         //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
                         // şekilde kesilmiş bir akış return eder. !!!
                         //limit() kullandıgımızda akıstan istedigimiz elemanları alıp bize yine bir akıs doner,
                         // o yuzden akısı bir Array'e cevirdik ve Array'e gore yazdırdık.
                         // Stream return eder.Bize stream referansını doner o yuzden bu akısı biyere balamamız lazım
                         //akıs cıktısı bir variable'a assign edilebilir.
                         //Ornegin okulda ilk 3'e girenleri bulucaz,sorted'la sıralama yaptıktan sonra limit'le ilk 3 elemanı alabiliriz


                          /*
                             TRİCK :•Stream'ler ekrana direkt yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString()'in içine alıp yazdırabiliriz.
•                            Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

                            */




                    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.    //!!Coklu data'ları biz ya Array'e atıyoruz ya limit'e
                        public static void ilkElHaricDigrSonHarfSıralıPrint(List<String>yemek){
                          yemek.
                                  stream().//akısa alındı
                                  sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harf'e gore sıralandı
                                  skip(1).//ilk eleman atlandı
                                  forEach(t-> System.out.print(t+" "));//print edildi
                        }
                           //skip() method'u atlama methodu'dur


                          //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
                          // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
                         //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.






























}

