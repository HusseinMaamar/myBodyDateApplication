package com.MyBodyDateAppBack.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private String dynamicGeolocation;
    private LocalDateTime dateOfCreation;
    private String id;
    private boolean loveCoatch;
    private boolean multiProfil;
    private boolean subscriber;
    private Role role;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Category category;
    private String size;
    private List<String> languages;
    private byte[] picture;
    private byte[] voicePrint;
    private byte[] proofOfIdentity;
    private Gender gender;
    private Situation situation;
    private SexualOrientation sexualOrientation;
    private Gender genderWanted;
    private List<Relation> relations;
    private List<Objective> objectives;
    private List<Affinity> affinities;
    private LifeStyle lifeStyle;
    private List<LifeStyle2> lifeStyle2;
    
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