package by.bsuir.podrez;

import by.bsuir.podrez.manager.EntityManager;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    private static EntityManager entityManager = null;
    private Start() {        
    }
    public synchronized static EntityManager getEntityManager() {
        if (entityManager == null) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost",
                        2099);
                entityManager = (EntityManager) registry
                        .lookup("UsersActivities");
                return entityManager;
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return entityManager;
    }    
}
