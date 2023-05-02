package com.MyBodyDateAppBack.service;

import com.MyBodyDateAppBack.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
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
    public  String saveUser(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.setId(formattedDate+3)).set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
