package com.example.nextLearnServer.util;

import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class DecryptUtil {
    public static void main(String[] args) throws Exception {
        // load public key
        String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkydbk+Y8wtX9BuTiFTNrKI09jct+k2P0bG6ExqDbuM4UFS1wYwFH10bU23gGtbIDUIJUTOK4IB0ohZR3CGfWZuMNJOHa55WwypoXoAXLFSbJBXVwkXl8JH/mKq8F6U4hfUVCTedu883IbEttjVKORbPc+9UUjM4MkzUHEAum71LC+wxviCI50JkXmHowGdNc/4+rIZ900mYHYxR+VI/M55CZH1tAXwlVLJh3JEhRihDUEteg1yCp2/DpN9b/KtUojKKLcuugyDbfw1Td6M8cpgjngBXl7xP0wPbUB/F4UohrRtV9N4hhMEtp1X9raCyiRFPMP5q5dAzrrCcxDhuVDwIDAQAB";
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        // received data
        String encryptedData = "gFlnJ+mWsbBaznB/KrsKgqnvZ1ZB6YpcUfpZpmpKaMs9lxYwTMex2WTnVSGu7OJwMrxBzegTKbQ4BflUZ8SgU/cl74GGdxl/3S3GKfXQDcHmbZ8rMtwnnRJEW4SiCPYXrUk/fB0iA98swWX0kG3/aBBCaGuUjuE7dHbf9aF+G4Pm5VYu47ay+IGGgUOyt21toEy7LGxzmWPpSWPmUiloD+uK5rVBKfChcBm/kZKt4h1+FT1vA27nl/fPsdkowPAerMTK4pB0wAOrRSaDgUUEeqmrvnpULmXzbMlYGy/Z342LJblgLEH2RjFrxXF69hK/QcH0EabR+8WpdLfNnPMAXw==";

        // use public key to decrypt
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));

        String decryptedData = new String(decryptedBytes);
        System.out.println("the decrypted data: " + decryptedData);
    }
}
