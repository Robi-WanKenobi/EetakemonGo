package EetakemonGo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Controller gitanillo = Controller.getController();
        //Tenemos las localizaciones en la DB
        gitanillo.add(new Location("Bar", 200, 500));
        gitanillo.add(new Location("Residencia", 300, 500));
        gitanillo.add(new Location("Despachos", 150,200));
        gitanillo.add(new Location("Laboratorios", 200,200));

        //Eetakemon y usuarios en la DB
        gitanillo.add(new Eetakemon("Tonix", 2, "Avalancha programada"));
        gitanillo.add(new Eetakemon("Alakasals", 0, "Psicocarga"));
        gitanillo.add(new Eetakemon("Robopass", 1, "Aguante"));
        gitanillo.add(new Eetakemon("Livanny", 0, "Hoja afilada"));
        gitanillo.add(new Eetakemon("Nachop", 1, "Fortaleza"));
        gitanillo.add(new Eetakemon("Decerior", 2, "Examen final"));
        if (!gitanillo.add(new User("Ivan", "Ivanivienen", "vanivan", "munozlois@gmail.com"))){
            System.out.println("El email ya esta en uso");
        }
        if (!gitanillo.add(new User("Daniel", "SheldorSob", "danidanidani", "danieh@gmail.com")))
        {
            System.out.println("El email ya esta en uso");
        }
        if (!gitanillo.add(new User("Carmen", "Carmencita", "carcarrmen", "munozlois@gmail.com"))){
            System.out.println("El email ya esta en uso");
        }

        //Entra DomingueroRob y captura
        gitanillo.validateLogin("munozlois@gmail.com", "vanivan");
        Capture previo = gitanillo.spawnCapture();
        System.out.println("Ha aparecido un " +previo.getEetakemon().getName()+ " en " +previo.getLocation().getName()+
                " ||Nivel: " +previo.getLevel()+
                " | HP: " +previo.getHp()+
                " | Attack: " +previo.getAttack()+
                " | Defense: " +previo.getDefense());
        gitanillo.add(previo);
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());

        //Entra SheldorSob y captura
        gitanillo.validateLogin("danieh@gmail.com", "danidanidani");
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());

        //Vuelve a entrar DomingueroRob y captura
        gitanillo.validateLogin("munozlois@gmail.com", "vanivan");
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());
        gitanillo.add(gitanillo.spawnCapture());


        List<Capture> prueba = Collections.list(gitanillo.getListCaptures());

        for (int i = 0; i < prueba.size(); i++){
            System.out.println("ID: "+prueba.get(i).getId()+ " | User: " +prueba.get(i).getIdUser()+
                    " | Eetakemon: " +prueba.get(i).getEetakemon().getName()+ " || Nivel: " +prueba.get(i).getLevel()+
                    " | HP: " +prueba.get(i).getHp()+ " | Attack: " +prueba.get(i).getAttack()+
                    " | Defense: " +prueba.get(i).getDefense());
        }

        System.out.println(Collections.list(gitanillo.getListUsuarios()).size());
    }
}
