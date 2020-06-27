package ru.ilya.alfabattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    final static String KEYSTORE_PASSWORD = "s3cr3t";

    static
    {
        System.setProperty("javax.net.ssl.trustStore", $CLIENT_JKS_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASSWORD);
        System.setProperty("javax.net.ssl.keyStore",  $CLIENT_JKS_LOCATION);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);

        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

}
