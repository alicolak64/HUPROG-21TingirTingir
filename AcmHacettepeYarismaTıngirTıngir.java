import java.util.Scanner;

/**
 * @author Ali Çolak
 * 29.04.2021
 */
public class AcmHacettepeYarismaTıngirTıngir {

    public static void main(String[] args) {

        int para=0;
        Scanner gir=new Scanner(System.in);
        System.out.println("");
        String s=gir.nextLine();
        String [] satir1=s.split(" ");
        int N=Integer.parseInt(satir1[0]);
        int M=Integer.parseInt(satir1[1]);
        int K=Integer.parseInt(satir1[2]);
        String  si=gir.nextLine();
        String [] x =si.split(" ");
        int [] standart=new int[M];
        int total=0;
        int [] yarismacilarTotal=new int[N];
        for (int i = 0; i < M; i++) {
            standart[i]=Integer.parseInt(x[i]);
            total+=standart[i];
        }
        int [][] yarismacilar=new int[N][M];
        for (int i = 0; i < N; i++) {
            int yarismaciTotal=0;
            String [] q=gir.nextLine().split(" ");
            int [] yarismaci=new int[M];
            for (int j = 0; j < M; j++) {
                yarismaci[j]=Integer.parseInt(q[j]);
                yarismaciTotal+=yarismaci[j];
            }
            yarismacilarTotal[i]=yarismaciTotal;
            yarismacilar[i]=yarismaci;
        }
        for (int i = 0; i < N; i++) {
            int f=((total-yarismacilarTotal[i])/400)*100;
            for (int j = 0; j < M; j++) {
                yarismacilar[i][j]=yarismacilar[i][j]+f;
            }
        }
        int beklemeSuresi=K;
        for (int i = 0; i < N; i++) {
            int dakika=0;
            for (int j = 0; j < M; j++) {
                int bolum=(Math.abs(standart[j]-yarismacilar[i][j])/50);
                int kalan=(Math.abs(standart[j]-yarismacilar[i][j])%50);
                if (kalan>20)
                    dakika+=1;
                dakika+=bolum;
            }
            if (dakika<=beklemeSuresi){
                beklemeSuresi+=K;
                para+=500;
            }
        }
        System.out.println(para);

    }

}
