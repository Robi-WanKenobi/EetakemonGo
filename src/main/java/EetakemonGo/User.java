package EetakemonGo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roberto on 08/03/2017.
 */
public class User {

    private int id;
    private String name;
    private String nick;
    private String password;
    private String email;
    List<Capture> captures;
    private int level;
    private int experience;
    private int experienceNextLevel;
    private boolean modified;
    private boolean admin;


    public User() {
    }

    public User(String name, String nick, String password, String email) {
        this.name = name;
        this.nick = nick;
        this.password = password;
        this.email = email;
        captures = new ArrayList<Capture>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {return level;}

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getExperienceNextLevel() {
        return experienceNextLevel;
    }

    public void setExperienceNextLevel(int experienceNextLevel) {
        this.experienceNextLevel = experienceNextLevel;
    }
}

