
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CalculoHash {

    public static byte[] getDigest(String input) {

        MessageDigest msgDigest;

        byte[] byteinput;
        byte[] resumen = new byte[0];
        try {
            byteinput = input.getBytes(StandardCharsets.UTF_8);

            msgDigest = MessageDigest.getInstance("SHA-256");
            msgDigest.reset();
            msgDigest.update(byteinput);

            resumen = msgDigest.digest();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return resumen;
    }

    public static boolean comparar(byte[] resumen1, byte[] resumen2) {

        return MessageDigest.isEqual(resumen1, resumen2);
    }
}