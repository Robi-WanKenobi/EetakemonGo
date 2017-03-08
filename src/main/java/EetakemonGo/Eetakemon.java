package EetakemonGo;

/**
 * Created by Roberto on 08/03/2017.
 */

public class Eetakemon {

    private int id;
    private String name;
    private int nature; // 0 -> Attacker; 1 -> Defender; 2 -> Tank
    private String spell;

    public Eetakemon(){}

    public Eetakemon(String name, int nature, String spell) {
        this.name = name;
        this.nature = nature;
        this.spell = spell;
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

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
}
