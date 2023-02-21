import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Registro {
    private static Scanner sc = new Scanner(System.in);
    
    public static void escribirCredenciales(String usuario, String contrasena) {

        byte[] digest = CalculoHash.getDigest(contrasena);

        String hashContrasena = String.format("%064x", new BigInteger(1, digest));

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("credenciales.cre", true));

            bw.write(usuario + "/" + Arrays.toString(digest) + "/" + hashContrasena);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.err.println("Error al escribir el usuario en el fichero");
        }
    }
}