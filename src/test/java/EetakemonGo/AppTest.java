package EetakemonGo;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class AppTest {
    Controller testControlador = Controller.getController();

    @Test
    public void addEetakemon(){
        testControlador.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        testControlador.add(new Eetakemon("Alakasals", 0, "Psicocarga"));
        testControlador.add(new Eetakemon("Robopass", 1, "Aguante"));
        testControlador.add(new Eetakemon("Livanny", 0, "Hoja afilada"));
        assertTrue(testControlador.getListEetakemon().hasMoreElements());
    }

    @Test
    public void delEetakemon(){
        assertTrue(testControlador.delEetakemon(1));
    }

    @Test
    public void searchEetakemonByName(){
        testControlador.add(new Eetakemon("Nachop", 1, "Fortaleza"));
        assertEquals(Eetakemon.class, testControlador.searchEetakemonByName("Nachop").getClass());
    }

    @Test
    public void searchEetakemonByAprox(){
        testControlador.add(new Eetakemon("Decerior", 2, "Examen final"));
        assertTrue(testControlador.searchEetakemonAprox("ecer").size() == 1);
    }

    @org.junit.Test
    public void addUser() {
        testControlador.add(new User("Ivan", "Ivanivienen", "vanivan", "munozlois@gmail.com"));
        testControlador.add(new User("Daniel", "SheldorSob", "danidanidani", "danieh@gmail.com"));
        assertTrue(testControlador.getListUsuarios().hasMoreElements());
    }

    @org.junit.Test
    public void delUser() {
        assertTrue(testControlador.delUsuario(100));
    }

    @org.junit.Test
    public void searchUserByName() {
        testControlador.add(new User("Roberto", "DomingueroRob", "robrobrob", "rob@gmail.com"));
        assertEquals(User.class, testControlador.searchUsuarioByName("Roberto").getClass());
    }

    @org.junit.Test
    public void searchUserByAprox() {
        testControlador.add(new User("Victor", "Vissssa", "visasasa", "vgporcell@gmail.com"));
        assertTrue(testControlador.searchUsuarioAprox("ict").size() == 1);
    }

    @Test
    public void invalidRegister(){
        testControlador.add(new User("Bruno", "Nodet", "peruano","love4matel@gmail.com"));
        assertFalse(testControlador.add(new User("Bruno", "Nodet", "peruano","LovE4matel@gmail.com")));
    }

    @Test
    public void invalidLogin(){
        assertTrue(!testControlador.validateLogin("roberto@gmail.com","rob14"));
    }
}
