package com.MyBodyDateAppBack.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;


@Service
public class FirebaseInitialization {

    public  void initialization(){

        FileInputStream serviceAccount =
                null;
        try {
            serviceAccount = new FileInputStream("./serviceAccountKey.json");


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://mybodydateapp-21bc7-default-rtdb.europe-west1.firebasedatabase.app")

                .build();

        FirebaseApp.initializeApp(options);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
