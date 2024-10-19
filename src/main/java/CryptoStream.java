import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import java.security.*;

public class CryptoStream {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;
    public static Wallet walletA;
    public static Wallet walletB;






    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i<blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }

            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasnt been mined");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Bouncy castle as security provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // init wallets
        walletA = new Wallet();
        walletB = new Wallet();

        // public and private key testing
        System.out.println("Private and Public keys");
        System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
        System.out.println(StringUtil.getStringFromKey(walletA.publicKey));

        // create and test transaction from walletA to walletB
        Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 5, null);
        transaction.generateSignature(walletA.privateKey);

        //verify signature
        System.out.println("Is signature verified");
        System.out.println(transaction.verifiySignature());

    }
}