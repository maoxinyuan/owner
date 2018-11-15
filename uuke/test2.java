package cn.com.srpingboot;

public class test2 {

    static int move_square(boolean[][] A , int N, int M){
        int resultL = 0;
        if (!A[0][0]) return 0;
        int temMaxWidth = 0;
        int temMaxHeight = 0;
        for (boolean[] b : A){
            if (!b[0]) break;
            temMaxHeight++;
        }
        for (boolean b :A[0]){
            if (!b) break;
            temMaxWidth++;
        }
        // 找出最大边
        resultL = Math.min(temMaxHeight,temMaxWidth ) -1;
        for (int j = resultL ; j >0;j--){
            for (int i = resultL ; i > 0;i--){
                if (!A[j][i]){
                    resultL = Math.min(i,j) -1;
                    break;
                }
            }
        }
        // 移动 递归查找是否可以通过
        for (int  i = resultL +1 ;  i > 0 ; i--){
            int aimWidth = N-i;
            int aimHeight = M-i;

            if (swift(i,0,0,A,aimWidth,aimHeight)){
                return i;
            }
        }

        return 0;

    }



    private static boolean swiftRight(Integer width, Integer startW, Integer startH, boolean[][] A, Integer endW, Integer endH){
        for (int a = 0 ;a < width ;a++){
            if (!A[startW+a][startH+width-1]) return false;
        }
        return swift(width, startW, startH, A, endW, endH);
    }

    private static boolean swiftDown(Integer width, Integer startW, Integer startH, boolean[][] A, Integer endW, Integer endH){
        for (int a = 0 ;a < width ;a++){
            if (!A[startW+width -1][startH+a]) return false;
        }
        return swift(width, startW, startH, A, endW, endH);
    }

    static private boolean swift(Integer width, Integer startW, Integer startH, boolean[][] A, Integer endW, Integer endH) {
        if (startH.equals(endH) && startW.equals(endW)) return true;
        else {
            if (startW  < endW && startH  < endH){
                return swiftRight(width, startW , startH + 1,A ,endW,endH)
                        || swiftDown(width, startW + 1, startH ,A ,endW,endH);
            }else if (startH  < endH){
                return swiftRight(width, startW , startH + 1,A ,endW,endH);
            }else if (startW  < endW ){
                return swiftDown(width, startW + 1, startH ,A ,endW,endH);
            }else { return false;}

        }
    }
    public static void main(String[] args) {
      // boolean[][] a = {{true,true,true,false},{true,true,true,false},{true,true,true,false}
        //,{true,true,true,true},{false,true,true,true},{true,false,true,true}};
       boolean[][] a = {{true}};
       //boolean[][] a = {{true,true,false,false},{true,false,false,false},{false,true,false,true}};

     //  boolean[][] a = {{true,true,false,false},{false,true,true,true}
       //   ,{false,true,true,false},{false,false,true,true},{false,false,false,true}};



        int i = move_square(a, 1, 1);
       System.out.println(i);

    }
}
