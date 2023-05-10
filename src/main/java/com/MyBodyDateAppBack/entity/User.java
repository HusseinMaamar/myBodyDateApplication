package com.MyBodyDateAppBack.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("location")
    private GeoPoint location;
    private String dynamicGeolocation;
    @ServerTimestamp
    private Timestamp dateOfCreation;
    @Id
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

    public User(String mail, String phone, String pseudonym, String password, String city, GeoPoint location,
                String dynamicGeolocation, boolean loveCoatch, boolean multiProfil,
                boolean subscriber, Role role, String firstname, String lastname, LocalDate dateOfBirth,
                Category category, String size, List<String> languages, byte[] picture, byte[] voicePrint,
                byte[] proofOfIdentity, Gender gender, Situation situation, SexualOrientation sexualOrientation,
                Gender genderWanted, List<Relation> relations, List<Objective> objectives, List<Affinity> affinities,
                LifeStyle lifeStyle, List<LifeStyle2> lifeStyle2) {
        this.mail = mail;
        this.phone = phone;
        this.pseudonym = pseudonym;
        this.password = password;
        this.city = city;
        this.location = location;
        this.dynamicGeolocation = dynamicGeolocation;
        this.dateOfCreation = null;
        this.loveCoatch = loveCoatch;
        this.multiProfil = multiProfil;
        this.subscriber = subscriber;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.category = category;
        this.size = size;
        this.languages = languages;
        this.picture = picture;
        this.voicePrint = voicePrint;
        this.proofOfIdentity = proofOfIdentity;
        this.gender = gender;
        this.situation = situation;
        this.sexualOrientation = sexualOrientation;
        this.genderWanted = genderWanted;
        this.relations = relations;
        this.objectives = objectives;
        this.affinities = affinities;
        this.lifeStyle = lifeStyle;
        this.lifeStyle2 = lifeStyle2;
    }
    

    public enum Role {
        INVITE, MEMBER, SUBSCRIBER, ADMIN, SUPER_ADMIN
    }

    public enum Category {
        CATEGORY_A, CATEGORY_B, CATEGORY_C
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Situation {
        SINGLE, MARRIED, DIVORCED, WIDOWED, OTHER
    }

    public enum SexualOrientation {
        HETEROSEXUAL, HOMOSEXUAL, BISEXUAL, OTHER
    }

    public enum Relation {
        FRIENDS, DATING, SERIOUS_RELATIONSHIP, MARRIAGE, OTHER
    }

    public enum Objective {
        FRIENDSHIP, DATING, SERIOUS_RELATIONSHIP, MARRIAGE, OTHER
    }

    public enum Affinity {
        SPORTS, CULTURE, NATURE, MUSIC, TRAVEL, FOOD, OTHER
    }

    public enum LifeStyle {
        HEALTHY, BALANCED, UNHEALTHY
    }

    public enum LifeStyle2 {
        SMOKER, DRINKER, VEGETARIAN, VEGAN, OTHER
    }
}