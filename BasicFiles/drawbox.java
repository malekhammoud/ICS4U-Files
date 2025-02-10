package BasicFiles;

public class drawbox {
    public static void drawbox(int width, int height, String text){
        for(int i=0; i<height; i++){
            System.out.print(text);
            for(int j=0; j<width-2; j++){
                if (i!=0 && i != (width-1)){
                    System.out.print(" ");
                }else{
                    System.out.print(text);
                }
            }
            System.out.println(text);
        }
    }
    public static void main(String[] args) {
        drawbox(5,5, "4");
    }
}
