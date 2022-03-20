public class mergesort {
private  int[] list;

//sıralanacak listeyi alan inşa fonksiyonu

public mergesort(int[] listToSort) {list = listToSort; }
//listeyi döndüren kapsülleme fonksiyonu

public int[] gerilist() {return list; }
//dışarıdan çağrılan sıralama fonk

public void sort(){ list = sort(list); }
//özyineli olarak çaloşan ve her parça için kullanılan sıralama fonk

private int[] sort(int[] dizi){

    if (dizi.length ==1)
    return dizi;
    else
    {
        //diziyi ikiye bölüyoruz ve solu oluşturuyoruz
        int[] left = new int[dizi.length/2];
        System.arraycopy(dizi, 0, left, 0, left.length);

        //parçalı diziyi gösterme
        for(int i = 0;i< dizi.length ; i++)
            System.out.println(dizi[i] +" ");
        System.out.println("");

        //dizinin sağını oluşturuyoruz ancak tek sayı ihtimali var
        int[] right = new int[dizi.length-left.length];
        System.arraycopy(dizi, left.length, right, 0, right.length);


    for(int i =0 ;i<dizi.length; i++)
        System.out.println(dizi[i]+ " ");
        System.out.println("");


        //her iki tarafı da ayrı ayrı sıralıyoruz
        left = sort(left); //dizinin sol parçaso
        right= sort(right); // dizinin sağ parçası

        for( int i = 0;i<dizi.length ; i++)
        System.out.println(dizi[i] +" ");
        System.out.println("");

        //sıralanmış dizileri birleştiriyoruz
        merge(left , right, dizi);
        return dizi;

    }
}
        //birleştirme fonksiyonu
        private void merge(int[ ]left, int[] right , int[] sonuc){
            int x=0; int y =0; int k =0;

            //iki dizide de eleman varsa
            while( x< left.length && y< right.length){
                //bölünecek eleman yoksa
                if ( left[x] < right[y])
                {
                    sonuc[k] = right[y];y++;
                }
                k++;
            }
            int[] rest; int restIndex;
            if( x >= left.length){
                rest= right;
                restIndex = y;
            }
            else{
                rest= left;
                restIndex = x;
            }
            for(int i = restIndex; i<rest.length; i++){
                sonuc[k]= rest[i];
                k++;
            }

        }

         public static void main(String[] args) {
            int[] dizi = {15, 19, 4 , 3, 18, 6, 2, 12, 7 ,9 ,11, 16};
            System.out.println("Sırasız : ");

            for(int i=0;i<dizi.length; i++){
                System.out.print(dizi[i]+ " ");
            }
            mergesort sortObj = new mergesort(dizi);
            sortObj.sort();
            System.out.println("");
            System.out.println("Sıralı:");
            int [] sirali = sortObj.getList();
            for(int i = 0;i< sirali.length ; i++)
            {
                System.out.print(sirali[i] + " ");
            }

        }

        private int[] getList() {
            return null;
        }
}