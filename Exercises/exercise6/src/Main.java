import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        String message = "Hi Bob! How are you?";
        System.out.printf("Alice wants to send a message to Bob: \"%s\"\n\n", message);

        // 1 - symmetric encryption
        System.out.println("1 - Symmetric encryption with AES/GCM/NoPadding");

        // generate key & spec
        KeyGenerator symmetricKeyGen = KeyGenerator.getInstance("AES");
        symmetricKeyGen.init(256);
        SecretKey symmetricKey = symmetricKeyGen.generateKey();
        byte[] iv = new byte[12];
        new SecureRandom().nextBytes(iv);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

        // encrypt
        Cipher aesEncryptCipher = Cipher.getInstance("AES/GCM/NoPadding");
        aesEncryptCipher.init(Cipher.ENCRYPT_MODE, symmetricKey, gcmSpec);
        byte[] aesCiphertext = aesEncryptCipher.doFinal(message.getBytes());
        System.out.printf("Encrypted message: \"%s\"\n", aesCiphertext);

        // decrypt
        Cipher aesDecryptCipher = Cipher.getInstance("AES/GCM/NoPadding");
        aesDecryptCipher.init(Cipher.DECRYPT_MODE, symmetricKey, gcmSpec);
        byte[] decryptedBytes = aesDecryptCipher.doFinal(aesCiphertext);
        String aesDecryptedMessage = new String(decryptedBytes);
        System.out.printf("Decrypted message: \"%s\"\n\n", aesDecryptedMessage);

        // 2 - asymmetric encryption
        System.out.println("2 - Asymmetric encryption with RSA/ECB/PKCS1Padding");

        // generate keys
        KeyPairGenerator asymmetricKeyGen = KeyPairGenerator.getInstance("RSA");
        asymmetricKeyGen.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4));
        // Alice’s keys
        KeyPair aliceKeyPair = asymmetricKeyGen.generateKeyPair();
        PublicKey alicePublicKey = aliceKeyPair.getPublic();
        PrivateKey alicePrivateKey = aliceKeyPair.getPrivate();
        // Bob’s keys
        KeyPair bobKeyPair = asymmetricKeyGen.generateKeyPair();
        PublicKey bobPublicKey = bobKeyPair.getPublic();
        PrivateKey bobPrivateKey = bobKeyPair.getPrivate();

        // encrypt
        Cipher rsaEncryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaEncryptCipher.init(Cipher.ENCRYPT_MODE, bobPublicKey);
        byte[] rsaCiphertext = rsaEncryptCipher.doFinal(message.getBytes());
        System.out.printf("Encrypted message: \"%s\"\n", rsaCiphertext);

        // decrypt
        Cipher rsaDecryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaDecryptCipher.init(Cipher.DECRYPT_MODE, bobPrivateKey);
        byte[] rsaDecrypted = rsaDecryptCipher.doFinal(rsaCiphertext);
        String rsaDecryptedMessage = new String(rsaDecrypted);
        System.out.printf("Decrypted message: \"%s\"\n\n", rsaDecryptedMessage);

        // 3 - sign & validate
        System.out.println("3 - Sign and Validate with RSA-2048");

        // sign
        Signature signSignature = Signature.getInstance("SHA256withRSA");
        signSignature.initSign(alicePrivateKey);
        signSignature.update(message.getBytes());
        byte[] signatureBytes = signSignature.sign();
        System.out.printf("Signature: %s\n", Base64.getEncoder().encodeToString(signatureBytes));

        // verify
        Signature verifySignature = Signature.getInstance("SHA256withRSA");
        verifySignature.initVerify(alicePublicKey);
        verifySignature.update(message.getBytes());
        boolean isValid = verifySignature.verify(signatureBytes);
        System.out.printf("Signature is valid: %s\n", isValid);
    }
}
