package Lambda;

import java.util.Arrays;

public class Lambda06 {
    public static void main(String[] args) {



    }
    /*




    //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)
 System.out.println("\nTASK 01 --> haluk.txt dosyasini okuyunuz -->  ");

    Path haluk=Path.of("src/lambdaTutorial/haluk.txt");//path haluk obj atandi
    Stream<String> akıs=Files.lines(haluk);//haluk.çtxt dataları akıs stream'e atandı

    //1. yol...
Files.lines(haluk).//path'deki dosyanın dataları akısa alındı
    //Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).//path'deki dosyanın dataları akısa alındı
    forEach(System.out::println);//akısdaki datalar(her satırdaki string) print edildi.
    //2.yol..
 akıs.forEach(System.out::println);

    //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
System.out.println("\nTASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");

Files.lines(Paths.get("src/lambdaTutorial/haluk.txt")).
    map(String::toUpperCase).//akısdaki datalar buyuk harfe update edldi
    forEach(System.out::println);//akısadaki datalar(her satırdaki string)yazıldı)


Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
 fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
  Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.







        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..
        System.out.println("\nTASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz  -->  ");
//1. yol limit();
        Files.lines(haluk).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);
        //2. yol findFirst();
        System.out.println(Files.lines(haluk).
                map(String::toLowerCase).
                findFirst());

    //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
System.out.println("\nTASK 04 --> haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
System.out.println(Files.lines(haluk).
    map(String::toLowerCase).
    filter(t -> t.contains("basari")).
    count());

//TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
        System.out.println("\nTASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");

   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.



    //1. yol.. distinct()
        System.out.println(Files.lines(haluk).
    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
    flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı
    distinct().//akısdaki elemanlar tekrarsız yapıldı
    collect(Collectors.toList()));//akısdaki tekrarsız elemanlar liste atandı

    //2. yol.. toset()
        System.out.println(Files.lines(haluk).
    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
    flatMap(Arrays::stream).
    collect(Collectors.toSet()));


    //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..
System.out.println("\nTASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
Files.lines(haluk).
    map(t -> t.split(" ")).//satırlardaki kelimeler arraya atandı
    flatMap(Arrays::stream).//2D arraydaki elelmanlar tek eleman olarak akısa alındı
    sorted().//harf sırası yapıldı
    forEach(System.out::println);//print edildi



    //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
System.out.println("\nTASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
System.out.println(Files.lines(haluk).
    map(t -> t.replaceAll("\\W", "").//satırlar \\W ifadesi a-z A-Z 0-9 _ disindakileri kapsar
    replaceAll("\\d", "").
    split("")).//harf akısı saglanır
    flatMap(Arrays::stream).
    distinct().
    count());


//TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.
System.out.println("\nTASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
System.out.println(Files.lines(haluk).
    map(t -> t.replaceAll("[.!,:)\\-]", "").

    split(" ")).//kelime akısı saglanır
    flatMap(Arrays::stream).
    distinct().
    count());


//TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
Files.lines(haluk).
    map(t -> t.replaceAll("[.!,:)\\-]", "").
    split(" ")).//kelime akısı saglanır
    flatMap(Arrays::stream).
    distinct().forEach(System.out::println);
*/
    /*

     */












}
