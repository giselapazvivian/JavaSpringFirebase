// package com.example.demo.config;

// import java.io.FileInputStream;
// import java.io.IOException;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.cloud.firestore.Firestore;
// import com.google.firebase.FirebaseApp;
// import com.google.firebase.FirebaseOptions;
// import com.google.firebase.cloud.FirestoreClient;

// @Configuration
// public class FirebaseConfig {

// @Bean
// public Firestore firestore() throws IOException {
// FileInputStream serviceAccount = new FileInputStream("./firebase-key.json");

// FirebaseOptions options = FirebaseOptions.builder()
// .setCredentials(GoogleCredentials.fromStream(serviceAccount))
// // .setDatabaseUrl("https://project-java-8f8e6.firebaseio.com")
// .build();

// FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);

// return FirestoreClient.getFirestore(firebaseApp);
// }

// }