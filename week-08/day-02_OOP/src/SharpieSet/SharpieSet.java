package SharpieSet;
import java.util.ArrayList;

public class SharpieSet {

    ArrayList<Sharpie> sharpieSet;

     public SharpieSet(){
         sharpieSet = new ArrayList<>();
     }

     public void add(Sharpie sharpie){
         sharpieSet.add(sharpie);
     }

     public int countUsable() {
         int counter = 0;
         for (int i = 0; i < sharpieSet.size(); i++) {
             if(sharpieSet.get(i).inkAmount > 0) {
                 counter++;
             }
         }
         return counter;
     }

    public ArrayList<Sharpie> removeTrash() {
        for (int i = 0; i < sharpieSet.size(); i++) {
            if (sharpieSet.get(i).inkAmount == 0) {
                sharpieSet.remove(i);
            }
        }
        return sharpieSet;
    }
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < sharpieSet.size(); i++) {
            result += sharpieSet.get(i) + " ";
        }
        return result;
    }
}
