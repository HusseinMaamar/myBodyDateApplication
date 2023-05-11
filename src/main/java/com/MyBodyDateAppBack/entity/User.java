package com.MyBodyDateAppBack.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.GeoPoint;

import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String mail;
    private String phone;
    private String pseudonym;
    private String password;
    private String city;
    private GeoPoint location;
    private String dynamicGeolocation;
    private String id;
    private boolean loveCoatch;
    private boolean multiProfil;
    private boolean subscriber;
    private Role role;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private Category category;
    private String size;
    private ArrayList<String> languages;
    private byte[] picture;
    private byte[] voicePrint;
    private byte[] proofOfIdentity;
    private Gender gender;
    private ArrayList<Situation>   situation;
    private ArrayList<SexualOrientation>  sexualOrientation;
    private Gender  genderWanted;
    private ArrayList<Relation>  relations;
    private ArrayList<Objective> objectives;
    private ArrayList<Affinity> affinities;
    private LifeStyle lifeStyle;
    private ArrayList<LifeStyle2> lifeStyle2;
    @ServerTimestamp
    private Timestamp dateCreation ;

    public User(String id) {
        this.id = id;
        this.mail= "tata55@gmail.com";
        this.dateCreation = null ; //Timestamp.of(new Date());
    }



    public String setId(String id) {
        this.id = id;
        return id;
    }

    public enum Role {
        INVITE,
        MEMBER,
        SUBSCRIBER,
        ADMIN,
        SUPER_ADMIN
    }

    public enum Category {
        CATEGORY_A,
        CATEGORY_B,
        CATEGORY_C
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public enum Situation {
        SINGLE,
        MARRIED,
        DIVORCED,
        WIDOWED,
        OTHER
    }

    public enum SexualOrientation {
        HETEROSEXUAL,
        HOMOSEXUAL,
        BISEXUAL,
        OTHER
    }

    public enum Relation {
        FRIENDS,
        DATING,
        SERIOUS_RELATIONSHIP,
        MARRIAGE,
        OTHER
    }

    public enum Objective {
        FRIENDSHIP,
        DATING,
        SERIOUS_RELATIONSHIP,
        MARRIAGE,
        OTHER
    }

    public enum Affinity {
        SPORTS,
        CULTURE,
        NATURE,
        MUSIC,
        TRAVEL,
        FOOD,
        OTHER
    }

    public enum LifeStyle {
        HEALTHY,
        BALANCED,
        UNHEALTHY
    }

    public enum LifeStyle2 {
        SMOKER,
        DRINKER,
        VEGETARIAN,
        VEGAN,
        OTHER
    }
}