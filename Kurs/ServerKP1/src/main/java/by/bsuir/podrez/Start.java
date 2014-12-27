package by.bsuir.podrez;

import by.bsuir.podrez.database.DAO.UserDAOImpl;
import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.User;
import by.bsuir.podrez.manager.EntityManager;
import by.bsuir.podrez.manager.EntityManagerImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {
    private static int curr_port = -1;
    private static Registry registry = null;
    private static EntityManager usersAct = null;
    private static Remote uaStub = null;
        
    public static void main(String[] args) {
         
            try {
                if (curr_port != 2099) {
                    if (registry != null) {
                        UnicastRemoteObject.unexportObject(registry, true);
                    }
                    curr_port = 2099;
                }

                registry = LocateRegistry.createRegistry(curr_port);

                if (usersAct == null) {
                    usersAct = new EntityManagerImpl();
                }

                if (uaStub == null) {
                    uaStub = UnicastRemoteObject.exportObject(usersAct, 0);
                }

                registry.bind("UsersActivities", uaStub);

        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
