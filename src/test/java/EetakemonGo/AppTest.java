package EetakemonGo;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    Controller testControlador = new Controller();

    @Test
    public void addEetakemon(){
        testControlador.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        assertTrue(testControlador.getListEetakemon().hasMoreElements());
    }

    @Test
    public void delEetakemon(){
        testControlador.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        testControlador.delEetakemon(0);
        assertTrue(!testControlador.getListEetakemon().hasMoreElements());
    }

    @Test
    public void searchEetakemonByName(){
        testControlador.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        assertEquals(Eetakemon.class, testControlador.searchEetakemonByName("Tonix").getClass());
    }

    @Test
    public void searchEetakemonByAprox(){
        testControlador.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        testControlador.add(new Eetakemon("Brunown", 1, "Repetición"));
        testControlador.add(new Eetakemon("Juaunter", 0, "Fantasmada"));
        assertTrue(testControlador.searchEetakemonAprox("un").size() == 2);
    }

    @org.junit.Test
    public void addUser() {
        //Introducimos un usuario y miramos que en la lista haya algo
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "rob@gmail.com"));
        assertTrue(testControlador.getListUsuarios().hasMoreElements());
    }

    @org.junit.Test
    public void delUser() {
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "rob@gmail.com"));
        //Borramos y miramos que la lsita este vacía
        testControlador.delUsuario(0);
        assertTrue(!testControlador.getListUsuarios().hasMoreElements());
    }

    @org.junit.Test
    public void searchUserByName() {
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "rob@gmail.com"));
        assertEquals(User.class, testControlador.searchUsuarioByName("Roberto").getClass());
    }

    @org.junit.Test
    public void searchUserByAprox() {
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "roberto@gmail.com"));
        testControlador.add(new User("Norberto", "EntrenaNor", "nornornor", "bert@gmail.com"));
        testControlador.add(new User("Bertin", "Tumama", "osborne", "bosborne@gmail.com"));
        assertTrue(testControlador.searchUsuarioAprox("er").size() == 3);
    }

    @Test
    public void validLogin(){
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "roberto@gmail.com"));
        assertTrue(testControlador.validateLogin("roberto@gmail.com","robrobrob"));
    }

    @Test
    public void invalidLogin(){
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "roberto@gmail.com"));
        assertTrue(!testControlador.validateLogin("roberto@gmail.com","rob14"));
    }
}
