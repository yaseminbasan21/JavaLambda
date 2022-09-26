package Lambda;

public class Universite {


           /*
             TASK :
             fields --> Universite (String)
                        bolum (String)
                        ogrcSayisi (int)
                        notOrt (int)
                      olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
                       pojo class:plan old java object -->model class'ı

           private variable
           constructor
           getter     -->>genrate'den
           setter
           toString
   */
           private String universite;
           private String bolum;
           private int ogrSayısı;
           private int notOrt;

           public Universite(){

           }



    @Override
    public String toString() {
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayısı=" + ogrSayısı +
                ", notOrt=" + notOrt +
                "\n"//bunu yazarsak her elemanı assagı atar
                ;
    }

    public Universite(String universite, String bolum, int ogrSayısı, int notOrt) {
        this.universite = universite;
        this.bolum = bolum;
        this.ogrSayısı = ogrSayısı;
        this.notOrt = notOrt;
    }



    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayısı() {
        return ogrSayısı;
    }

    public void setOgrSayısı(int ogrSayısı) {
        this.ogrSayısı = ogrSayısı;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }




}
