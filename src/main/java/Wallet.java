import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
    public PrivateKey privateKey;  // used ot sign transactions, not shareable
    public PublicKey publicKey;  // our address, shareable

    public Wallet() {
        generateKeyPair();
    }


    // This method is it uses Java.security.KeyPairGenerator to generate an Elliptic Curve KeyPair.
    // This method makes and sets our Public and Private keys. Nifty.
    public void generateKeyPair() {
        try {
            //
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");

            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();

            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }
        catch (Exception e) {
            //
            throw new RuntimeException(e);
        }
    }

}
