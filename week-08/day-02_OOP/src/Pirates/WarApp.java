//Create a WarApp class with a main method
//Create 2 armadas, fill them with ships
//Have a war!

package Pirates;

public class WarApp {
    public static void main(String[] args) {
        Armada spanishArmada = new Armada("spanishArmada");
        Armada pirateArmada = new Armada("pirateArmada");

        spanishArmada.fillArmada();
        pirateArmada.fillArmada();

        spanishArmada.war(pirateArmada);
    }
}
