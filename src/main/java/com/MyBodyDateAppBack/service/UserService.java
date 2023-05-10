package com.MyBodyDateAppBack.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBodyDateAppBack.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@Service
public class UserService {

    private static final String COLLECTION_NAME = "users";

    @Autowired
    private Firestore firestore;

    public String saveUser(User user) throws InterruptedException, ExecutionException {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = formatter.format(currentDate);
        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);
        Query query = collectionReference.orderBy("id", Query.Direction.DESCENDING).limit(1);
        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot querySnapshot = future.get();
        int lastId = 0;
        if (!querySnapshot.isEmpty()) {
            lastId = Integer.parseInt(querySnapshot.getDocuments().get(0).getId().substring(8));
        }
        int newId = lastId + 1;
        String id = formattedDate + "-" + newId;
        DocumentReference documentReference = collectionReference.document(id);
        ApiFuture<DocumentSnapshot> futureDoc = documentReference.get();
        DocumentSnapshot document = futureDoc.get();
        if (document.exists()) {
            return "User with ID " + user.getId() + " already exists.";
        } else {
            user.setId(id);
            documentReference.set(user).get();
            return "User with ID " + user.getId() + " successfully created.";
        }
    }

    public User getUserById(String id) throws InterruptedException, ExecutionException {
        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            return document.toObject(User.class);
        } else {
            return null;
        }
    }

    public List<User> getAllUsers() throws InterruptedException, ExecutionException {
        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> future = collectionReference.get();
        QuerySnapshot querySnapshot = future.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        return documents.stream().map(doc -> doc.toObject(User.class)).collect(Collectors.toList());
    }

    public List<User> getUsersByCity(String city) throws InterruptedException, ExecutionException {
        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);
        Query query = collectionReference.whereEqualTo("city", city);
        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot querySnapshot = future.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        return documents.stream().map(doc -> doc.toObject(User.class)).collect(Collectors.toList());
    }

    public String updateUser(User user) throws InterruptedException, ExecutionException {
        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(user.getId());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            documentReference.set(user).get();
            return "User with ID " + user.getId() + " successfully updated.";
        } else {
            return "User with ID " + user.getId() + " does not exist.";
        }
    }

    public String deleteUser(String id) throws InterruptedException, ExecutionException {
        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            documentReference.delete().get();
            return "User with ID " + id + " successfully deleted.";
        } else {
            return "User with ID " + id + " does not exist.";
        }
    }
}
