package teoria.conexion.singleton;

public class Test {
    public static void main(String[] args) {
        NoSingleton uno = new NoSingleton("uno");
        NoSingleton dos = new NoSingleton("dos");
        NoSingleton tres = new NoSingleton("tres");
        System.out.println(uno);
        System.out.println(dos);
        System.out.println(tres);
        Singleton one = Singleton.getSingleton();
        Singleton two = Singleton.getSingleton();
        Singleton three = Singleton.getSingleton();
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

    }
}
