import java.awt.*;

public class ComputerTest {

    public static void main(String[] args) {

        Komputer komputer = new Komputer(10, Color.blue, 2050.10);
        komputer.switchOn();
        komputer.colorChange(Color.pink);
        komputer.priceChange(2500);


    }
}
