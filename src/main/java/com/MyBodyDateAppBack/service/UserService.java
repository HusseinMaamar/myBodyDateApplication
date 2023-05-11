package com.MyBodyDateAppBack.service;

import com.MyBodyDateAppBack.entity.User;
import com.google.api.client.util.Value;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.cloud.FirestoreClient;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static final String COLLECTION_NAME =  "Users" ;


     @SneakyThrows
     public  String saveUser(User user)  {
         Firestore dbFirestore = FirestoreClient.getFirestore();
         // Date
         Date currentDate = new Date();
         // Date pattern (model)
         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
         // Date passed
         String formattedDate = formatter.format(currentDate);
         //
         Query query = dbFirestore.collection(COLLECTION_NAME).orderBy("id", Query.Direction.DESCENDING).limit(1);
         ApiFuture<QuerySnapshot> future = query.get();
         QuerySnapshot querySnapshot = future.get();
         int lastId = 0;

         if (!querySnapshot.isEmpty()){
             lastId = Integer.parseInt(querySnapshot.getDocuments().get(0).getId().substring(8));

         }
         int newId = lastId + 1;

         String  idDoc = formattedDate + newId;
         ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.setId(idDoc)).set(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }


    //GeoPoint location = new GeoPoint(45,85);
   /* public String saveUser(User user) throws ExecutionException, InterruptedException {
        user.setLocation(location);
        user.setId("test");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).add(user);
        DocumentReference documentReference = collectionApiFuture.get();
        return documentReference.getId();
    }*/


}
