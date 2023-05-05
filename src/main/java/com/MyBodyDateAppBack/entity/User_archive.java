package com.MyBodyDateAppBack.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.GeoPoint;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;


public class User_archive {
    @Id
    private String id;
    private  String email;
    private  String phone ;
    private  String password ;
    private  String pseudonym;
    private  String city ;
   // @JsonProperty( value = "location")
    //private GeoPoint location ;
    private String  typeSubscriber;
    private  String firstName;
    private  String lastName;
    private String  dateOfBirth;
    private  Number size ;
    private ArrayList<String> languages ;
    private  String gender ;
    private  String loveSituation;
    private  String sexualOrientation ;
    private  String genderSearch;
    private  ArrayList<String> relations;
    private  ArrayList<String> objectives;
    private  ArrayList<String> affinities;
    private  String lifeStyle;
    private  ArrayList<String> lifeStyle2;
    private  String dateOfCreation ;

    //public User_archive(GeoPoint location) {
        //this.location = location;

   // }

    public String getId() {
        return id;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPseudonym() {
        return pseudonym;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //public GeoPoint getLocation() {
        //return location;
    //}

    //public GeoPoint setLocation(GeoPoint location) {
        //this.location = location;
        //return location;
    //}

    public String getTypeSubscriber() {
        return typeSubscriber;
    }

    public void setTypeSubscriber(String typeSubscriber) {
        this.typeSubscriber = typeSubscriber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Number getSize() {
        return size;
    }

    public void setSize(Number size) {
        this.size = size;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLoveSituation() {
        return loveSituation;
    }

    public void setLoveSituation(String loveSituation) {
        this.loveSituation = loveSituation;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public String getGenderSearch() {
        return genderSearch;
    }

    public void setGenderSearch(String genderSearch) {
        this.genderSearch = genderSearch;
    }

    public ArrayList<String> getRelations() {
        return relations;
    }

    public void setRelations(ArrayList<String> relations) {
        this.relations = relations;
    }

    public ArrayList<String> getObjectives() {
        return objectives;
    }

    public void setObjectives(ArrayList<String> objectives) {
        this.objectives = objectives;
    }

    public ArrayList<String> getAffinities() {
        return affinities;
    }

    public void setAffinities(ArrayList<String> affinities) {
        this.affinities = affinities;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public ArrayList<String> getLifeStyle2() {
        return lifeStyle2;
    }

    public void setLifeStyle2(ArrayList<String> lifeStyle2) {
        this.lifeStyle2 = lifeStyle2;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
