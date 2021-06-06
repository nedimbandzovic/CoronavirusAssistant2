package com.example.coronavirusassistant;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity (tableName="users")
public class User {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name="username")
    String username;

    @ColumnInfo (name="password")
    String password;

    @ColumnInfo (name="NameAndSurname")
    String NameAndSurname;

    @ColumnInfo (name="JMBG")
    String JMBG;

    @ColumnInfo (name="VaccinationPlace")
    String VaccinationPlace;

    @ColumnInfo (name="Vaccine")
    String Vaccine;

    @ColumnInfo (name="VaccinationDate")
    String VaccinationDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameAndSurname() {
        return NameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        NameAndSurname = nameAndSurname;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getVaccinationPlace() {
        return VaccinationPlace;
    }

    public void setVaccinationPlace(String vaccinationPlace) {
        VaccinationPlace = vaccinationPlace;
    }

    public String getVaccine() {
        return Vaccine;
    }

    public void setVaccine(String vaccine) {
        Vaccine = vaccine;
    }

    public String getVaccinationDate() {
        return VaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        VaccinationDate = vaccinationDate;
    }
}
