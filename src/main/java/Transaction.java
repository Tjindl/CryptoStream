import java.security.*;
import java.util.ArrayList;

public class Transaction {
    public String transactionId; // hash of transaction
    public PublicKey sender; // senders address/public key
    public PublicKey recipient; // recipient's address/public key
    public float value;
    public byte[] signature; // to prevent anyone else from spending funds in our wallet

    public ArrayList<TransactionInput> inputs = new ArrayList<>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<>();

    private static int sequence = 0; // rough count of the number os transactions that have been generated


    // Constructor //
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.recipient = to;
        this.value = value;
        this.inputs = inputs;
    }

    // transaction hash calculator
    private String calculateHash() {
        sequence++;
        return StringUtil.applysha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recipient) +
                        Float.toString(value) + sequence
        );
    }


    //Signs all the data we dont wish to be tampered with.
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    //Verifies the data we signed hasnt been tampered with
    public boolean verifiySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recipient) + Float.toString(value)	;
        return StringUtil.verifyECDSASig(sender, data, signature);
    }

}