package EetakemonGo;

import java.util.*;

public class Controller {

    private static Controller controllerSingleton;
    private Hashtable<Integer, Eetakemon> hashtableEetakemon;
    private Hashtable<Integer, User> hashtableUsuarios;
    private Hashtable<Integer, Capture> hashtableCaptures;
    private Hashtable<Integer, Location> hashtableLocations;
    private int generatedIdEetakemon = 0;
    private int generatedIdUsuario = 100;
    private int generatedIdCapture = 0;
    private int generatedIdLocation = 0;
    private int userLoged;

    public static Controller getController(){
        if (controllerSingleton == null){
            controllerSingleton = new Controller();
        }
        return controllerSingleton;
    }

    private Controller() {
        hashtableEetakemon = new Hashtable<Integer, Eetakemon>();
        hashtableUsuarios = new Hashtable<Integer, User>();
        hashtableCaptures = new Hashtable<Integer, Capture>();
        hashtableLocations = new Hashtable<Integer, Location>();
    }

    //Añadir
    public boolean add(Object o) {

        //Si es un Eetakemon
        if (o.getClass().equals(Eetakemon.class)) {
            Eetakemon add = (Eetakemon) o;
            add.setId(generatedIdEetakemon);
            hashtableEetakemon.put(this.generatedIdEetakemon, add);
            this.generatedIdEetakemon++;
            return true;
        }
        //Si es un Usuario
        else if (o.getClass().equals(User.class)) {

            User add = (User) o;

            if (validateRegister(add.getEmail())) {
                add.setId(generatedIdUsuario);
                add.setLevel(1);
                add.setExperience(0);
                add.setExperienceNextLevel(250);
                hashtableUsuarios.put(this.generatedIdUsuario, add);
                this.generatedIdUsuario++;
                return true;
            }
            return false;
        }

        //Si es una captura
        else if (o.getClass().equals(Capture.class)){
            Capture add = (Capture) o;
            add.setIdUser(this.userLoged);
            //Añadir la experiencia al usuario
            hashtableUsuarios.get(this.userLoged).setExperience(hashtableUsuarios.get(this.userLoged).getExperience()+100);
            if (hashtableUsuarios.get(this.userLoged).getExperience()>=hashtableUsuarios.get(this.userLoged).getExperienceNextLevel()){
                levelUp(); //función abajo
                //experiencia restante
                hashtableUsuarios.get(this.userLoged).setExperience(hashtableUsuarios.get(this.userLoged).getExperience()-
                hashtableUsuarios.get(this.userLoged).getExperienceNextLevel());
                //nuevo objetivo de experiencia
                int expNextLvl = (int) (250*Math.pow(1.5,hashtableUsuarios.get(this.userLoged).getLevel()-1));
                hashtableUsuarios.get(this.userLoged).setExperienceNextLevel(expNextLvl);
            }

            add.setId(this.generatedIdCapture);
            hashtableCaptures.put(add.getId(), add);
            this.generatedIdCapture++;
            return true;
        }

        //Si es una localización
        else if (o.getClass().equals(Location.class)){
            Location add = (Location) o;
            add.setId(generatedIdLocation);
            hashtableLocations.put(add.getId(), add);
            this.generatedIdLocation++;
            return true;
        }
        return false;
    }

    //Borrar Eetakemon por identificador
    public boolean delEetakemon(int id) {
        int size = hashtableEetakemon.size();
        hashtableEetakemon.remove(id);

        if (hashtableEetakemon.size() < size) {
            return true;
        } else return false;
    }

    //Borrar Usuario por identificador
    public boolean delUsuario(int id) {
        int size = hashtableUsuarios.size();
        hashtableUsuarios.remove(id);

        if (hashtableUsuarios.size() < size) {
            return true;
        } else return false;
    }

    //Devolver lista de Eetakemon
    public Enumeration<Eetakemon> getListEetakemon() {
        return hashtableEetakemon.elements();
    }

    //Devolver lista de Usuarios
    public Enumeration<User> getListUsuarios() {
        return hashtableUsuarios.elements();
    }

    //Devolver lista de Capturas
    public Enumeration<Capture> getListCaptures() {return hashtableCaptures.elements();}

    //Buscar Eetakemon por nombre
    public Eetakemon searchEetakemonByName(String name) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getName().equals(name)) {
                return search.get(i);
            }
        }
        return null;
    }

    //Buscar Usuario por nombre
    public User searchUsuarioByName(String name) {

        List<User> search = Collections.list(hashtableUsuarios.elements());

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getName().equals(name)) {
                return search.get(i);
            }
        }
        return null;
    }

    //Buscar Eetakemon por fracción de nombre
    public List<Eetakemon> searchEetakemonAprox(String aprox) {

        List<Eetakemon> search = Collections.list(hashtableEetakemon.elements());
        List<Eetakemon> finded = new ArrayList<Eetakemon>();

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getName().contains(aprox)) {
                finded.add(search.get(i));
            }
        }
        return finded;
    }

    //Buscar Usuario por fracción de nombre
    public List<User> searchUsuarioAprox(String aprox) {

        List<User> search = Collections.list(hashtableUsuarios.elements());
        List<User> finded = new ArrayList<User>();

        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getName().contains(aprox)) {
                finded.add(search.get(i));
            }
        }
        return finded;
    }

    //Comprobar si un usuario esta registrado y validar sus datos
    public boolean validateLogin(String email, String password){

        List<User> validate = Collections.list(hashtableUsuarios.elements());

        for (int i = 0; i<validate.size(); i++){
            if ((validate.get(i).getEmail().equals(email))&&
                    (validate.get(i).getPassword().equals(password))){
                this.userLoged = validate.get(i).getId();
                return true;
            }
        }
        return false;
    }

    public boolean validateRegister(String email){
        List<User> validate = Collections.list(hashtableUsuarios.elements());

        for (int i = 0; i<validate.size(); i++)
        {
            if (validate.get(i).getEmail().equalsIgnoreCase(email))
            {
                return false;
            }
        }
        return true;
    }

    //Generar un evento de captura
    public Capture spawnCapture(){
        Capture spawn = new Capture();
        int wichEetakemon = ((int) Math.floor(Math.random()*(hashtableEetakemon.size())));
        spawn.setEetakemon(hashtableEetakemon.get(wichEetakemon));
        int where = ((int) Math.floor((Math.random()*(hashtableLocations.size()))));
        spawn.setLocation(hashtableLocations.get(where));
        if (spawn.getEetakemon().getNature()==0){
            spawn.setAttack(spawn.getAttack()+15);
        }
        else if (spawn.getEetakemon().getNature()==1){
            spawn.setDefense(spawn.getDefense()+15);
        }
        else if (spawn.getEetakemon().getNature()==2){
            spawn.setHp(spawn.getHp()+200);
        }
        return spawn;
    }

    public void levelUp(){
        hashtableUsuarios.get(this.userLoged).setLevel(hashtableUsuarios.get(this.userLoged).getLevel()+1);
    }
}
