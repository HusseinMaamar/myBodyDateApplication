package com.MyBodyDateAppBack.service;

import com.MyBodyDateAppBack.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.GeoPoint;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static final String COLLECTION_NAME =  "Users" ;
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String formattedDate = formatter.format(currentDate);

    /*- public  String saveUser(User_archive user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.setId(formattedDate+11)).set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }*/
    GeoPoint location = new GeoPoint(45,59);
    public String saveUser(User user) throws ExecutionException, InterruptedException {
        user.setLocation(location);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).add(user);
        DocumentReference documentReference = collectionApiFuture.get();
        return documentReference.getId();
    }
}
