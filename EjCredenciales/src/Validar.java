import java.io.*;
import java.util.Scanner;


public class Validar {
    private static Scanner sc = new Scanner(System.in);

    public static boolean logearse(String usuario, String contrasena) {

        String linea;
        String[] array;
        byte[] pass;
        boolean valido = false;

        try {

            byte[] digest = CalculoHash.getDigest(contrasena);
            BufferedReader br = new BufferedReader(new FileReader("credenciales.cre"));
            linea = br.readLine();

            while (linea != null) {

                String usuarioSplit = linea.split("/")[0];

                if (usuarioSplit.equals(usuario)) {

                    array = linea.split("/")[1].split(", ");
                    array[0] = array[0].substring(1);

                    array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].length() - 1);
                    pass = new byte[array.length];

                    for (int i = 0; i < array.length; i++) {
                        pass[i] = Byte.parseByte(array[i]);
                    }

                    if (CalculoHash.comparar(digest, pass)) {
                        valido = true;
                        break;
                    }
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valido;
    }
}