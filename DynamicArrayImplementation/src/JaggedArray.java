public class JaggedArray {


    public static void pascalsTriangle(int rows){
        int[][] pt = new int[rows][];
        for(int i = 0;i<rows;i++){
            pt[i] = new int[i+1];
            pt[i][0] = 1;
            for(int j = 1;j<i;j++){
                pt[i][j] = pt[i-1][j-1] + pt[i-1][j];
            }
            pt[i][i] = 1;
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<pt[i].length;j++){
                System.out.print(" " + pt[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        pascalsTriangle(7);
    }

}
