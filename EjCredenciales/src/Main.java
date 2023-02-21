import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        boolean salir = false;

        do{
            switch (menuPrincipal(sc)){
                case "1" -> signUp();
                case "2" -> {
                    login();
                    salir = true;
                }
                default -> System.out.println("Esa opcion no existe");
            }
        }while(!salir);

    }

    public static void signUp(){

        System.out.println("REGISTRATE");

        System.out.println("Introduce tu usario:");
        String usuario = sc.next();

        System.out.println("Introduce una contraseña:");
        String contrasena = sc.next();

        System.out.println("Repite la contraseña:");
        String repetirContrasena = sc.next();

        if (contrasena.equals(repetirContrasena)) {

            Registro.escribirCredenciales(usuario, contrasena);
            System.out.println("Usuario registrado correctamente");
        } else {
            System.out.println("Las contraseñas no son iguales");
        }

    }

    public static void login(){
        System.out.println("LOGEATE");

        System.out.println("Introduce tu usuario:");
        String nombre = sc.next();

        System.out.println("Introduce tu contraseña:");
        String password = sc.next();

        if (Validar.logearse(nombre, password)) {
            System.out.println("LOGEADO");
        } else {
            System.out.println("EL USUARIO O CONTRASEÑA NO COINCIDEN");
        }
    }

    private static String menuPrincipal(Scanner sc){

        System.out.println("""
                
                [1] - REGISTRARSE
                [2] - LOGEARSE
                
                """);

        return sc.next();
    }
}
