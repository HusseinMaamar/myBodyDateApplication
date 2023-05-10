// package com.MyBodyDateAppBack.entity;

// import java.time.LocalDateTime;
// import java.util.UUID;

// import org.springframework.data.annotation.Id;

// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class ProfileTest {
//     private LocalDateTime dateOfCreation;
//     @Id
//     private String id;

//     public ProfileTest(LocalDateTime dateOfCreation) {
//         this.dateOfCreation = dateOfCreation;
//         this.id = dateOfCreation.toString() + "-" + UUID.randomUUID().toString();
//     }

//     // Getters and setters for all fields
// }