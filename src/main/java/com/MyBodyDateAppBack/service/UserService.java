package com.MyBodyDateAppBack.service;

import com.MyBodyDateAppBack.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static final String COLLECTION_NAME = "Users";
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String formattedDate = formatter.format(currentDate);

    public User createUser(User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(user.getId());
        ApiFuture<WriteResult> future = documentReference.create(user); // Utiliser create() au lieu de set()
        try {
            future.get(); // Attendre la fin de l'opération
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique
        }
        return user;
    }

    public User getUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document;
        try {
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique
            return null;
        }
        User user = null;
        if (document.exists()) {
            user = document.toObject(User.class);
        }
        return user;
    }

    public User updateUser(String id, User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<WriteResult> future = documentReference.set(user); // Utiliser set()
        try {
            future.get(); // Attendre la fin de l'opération
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique
        }
        return user;
    }

    public void deleteUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<WriteResult> future = documentReference.delete();
        try {
            future.get(); // Attendre la fin de l'opération
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique
        }
    }
}