import org.apache.commons.codec.binary.Base64;

public class Base64Convert {

    public static String decode(final byte[] bytes) {
        return new String(Base64.decodeBase64(bytes));
    }

    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

}
