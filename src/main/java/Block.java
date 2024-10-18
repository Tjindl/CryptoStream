import java.util.Date;
import java.security.MessageDigest; // to get access to SHA-256 algorithm


public class Block {

    public String hash;  // current block hash
    public String previousHash; // previous block hash
    private String data; // data (simple message)
    private long timeStamp; // time of block creation

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.applysha256(
                previousHash +
                Long.toString(timeStamp) +
                data
        );
        return calculatedHash;
    }

}
