package EetakemonGo;

import java.util.Date;
import java.util.Random;

public class Capture {

    private int id;
    private int level;
    private int hp, attack, defense;
    private int idUser;
    private Eetakemon eetakemon;
    private double experience;
    private Location location;
    private Date date;
    private boolean state;

    public Capture(){
        this.level = (int) Math.floor(Math.random()*(100-1+1)+1);
        this.hp = (int) (Math.floor(Math.random()*(120-100+1)+100)) + (getLevel()*10);
        this.attack = (int) (Math.floor(Math.random()*(80-60+1)+60)) + (getLevel());
        this.defense = (int) (Math.floor(Math.random()*(60-40+1)+40)) + (getLevel());
    }

    public Capture(int nivel, int hp, int attack, int defense, int idUser, Eetakemon eetakemon, double experience, Date date) {
        this.level = nivel;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.idUser = idUser;
        this.eetakemon = eetakemon;
        this.experience = experience;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int nivel) {
        this.level = nivel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Eetakemon getEetakemon() {
        return eetakemon;
    }

    public void setEetakemon(Eetakemon eetakemon) {
        this.eetakemon = eetakemon;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
