import java.security.MessageDigest;

public class MyHash {
	public MyHash(){}
	private static MessageDigest md;
	public static byte[] myHash(byte [] m) {
		byte[] ret = new byte[3];
		byte[] h = "hello".getBytes();
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		}
		catch (java.security.NoSuchAlgorithmException e)
		{}
		h = md.digest(m);

		ret[0] = h[0];
		ret[1] = h[1];
		ret[2] = h[2];
		
		return h;
	}
}