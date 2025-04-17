//perplexity ai helped me again! Mainly just for the entity moving code.
import java.util.ArrayList;

class entitySystemTest{
    public static ArrayList<Integer> entities = new ArrayList<Integer>();
    public static char pixels[][] = {{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}};
    //main method
    public static void main(String[] args) throws InterruptedException {
        addEntity(1, 1, -1);
        addEntity(2, 2, -3);

        while(1==1){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //reset pixel buffer
            for (int x = 0; x < 4; x++){
                for (int y = 0; y < 4; y++){
                    pixels[x][y] = '.';
                }
            }
            
            //put each entity into buffer
            for (int i = 0; i < entities.size(); i += 3){
                setPixel(entities.get(i+1), entities.get(i+2), '#');
            }

            //move entities
            for (int a = 0; a < entities.size(); a += 3){
                entities.set(a+1, entities.get(a+1) + 1);
                if (entities.get(a+1) > 3){
                    entities.set(a+1, 3);
                }
            }
            
            //render
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    System.out.print(pixels[j][k]);
                }
                System.out.println();
            }
            Thread.sleep(1000);
        }
    }
    
    //other functions
    public static void addEntity(int id, int x, int y){
        entities.add(id);
        entities.add(x);
        entities.add(y);
    }
    public static void setPixel(int x, int y, char sym){
        pixels[Math.abs(y)][x] = sym;
    }
}