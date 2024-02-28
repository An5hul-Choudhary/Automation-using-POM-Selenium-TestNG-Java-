public class looping {
    public static void main(String[] args) {

      /*  int count =1;
        for(int i=0;i<4;i++){
            for(int j=4-i;j>0;j--){
                System.out.print(count);
                count++;
            }
            System.out.println();
        }

       */

        for(int i=4;i>0;i--){
            for(int j=i;j<=4;j++){
                System.out.print((j-i+1) + "\t");
            }
            System.out.println();
        }

    }
}
