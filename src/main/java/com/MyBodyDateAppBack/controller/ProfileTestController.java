// package com.MyBodyDateAppBack.controller;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.MyBodyDateAppBack.entity.ProfileTest;
// import com.MyBodyDateAppBack.service.ProfileTestService;

// @RestController
// @RequestMapping("/profiletest")
// public class ProfileTestController {
//     @Autowired
//     private ProfileTestService profileTestService;

//     @PostMapping
//     public ResponseEntity<ProfileTest> createProfileTest() {
//         LocalDateTime now = LocalDateTime.now();
//         ProfileTest profileTest = new ProfileTest(now);
//         ProfileTest createdProfileTest = profileTestService.createProfileTest(profileTest);
//         return new ResponseEntity<>(createdProfileTest, HttpStatus.CREATED);
//     }

//     @GetMapping
//     public ResponseEntity<List<ProfileTest>> getAllProfileTests() {
//         List<ProfileTest> profileTests = profileTestService.getAllProfileTests();
//         return new ResponseEntity<>(profileTests, HttpStatus.OK);
//     }
// }