package by.bsuir.podrez.manager;

import by.bsuir.podrez.logic.ActorsLogic;
import by.bsuir.podrez.logic.ActorsLogicImpl;
import by.bsuir.podrez.logic.AddActorsLogic;
import by.bsuir.podrez.logic.AddActorsLogicImpl;
import by.bsuir.podrez.logic.AddGenreLogic;
import by.bsuir.podrez.logic.AddGenreLogicImpl;
import by.bsuir.podrez.logic.AddLogic;
import by.bsuir.podrez.logic.AddLogicImpl;
import by.bsuir.podrez.logic.AddTicketLogic;
import by.bsuir.podrez.logic.AddTicketLogicImpl;
import by.bsuir.podrez.logic.AddTimetableLogic;
import by.bsuir.podrez.logic.AddTimetableLogicImpl;
import by.bsuir.podrez.logic.GenresLogic;
import by.bsuir.podrez.logic.GenresLogicImpl;
import by.bsuir.podrez.logic.LoginLogic;
import by.bsuir.podrez.logic.LoginLogicImpl;
import by.bsuir.podrez.logic.PerformancesLogic;
import by.bsuir.podrez.logic.PerformancesLogicImpl;
import by.bsuir.podrez.logic.TicketLogic;
import by.bsuir.podrez.logic.TicketLogicImpl;
import by.bsuir.podrez.logic.TimetableLogic;
import by.bsuir.podrez.logic.TimetableLogicImpl;
import by.bsuir.podrez.logic.UserLogic;
import by.bsuir.podrez.logic.UserLogicImpl;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityManagerImpl implements EntityManager{

    @Override
    public synchronized LoginLogic getLoginManager() throws RemoteException {
       return new LoginLogicImpl();
    }
    
    @Override
    public synchronized TimetableLogic getTimetableManager() throws RemoteException {
       return new TimetableLogicImpl();
    }

    @Override
    public PerformancesLogic getPerformancesManager() throws RemoteException {
        return new PerformancesLogicImpl();
    }

    @Override
    public AddLogic getAddManager() throws RemoteException {
        return new AddLogicImpl();
    }

    @Override
    public ActorsLogic getActorsManager() throws RemoteException {
        return new ActorsLogicImpl();
    }

    @Override
    public AddActorsLogic getAddActorsManager() throws RemoteException {
        return new AddActorsLogicImpl();
    }

    @Override
    public AddTimetableLogic getAddTimetableManager() throws RemoteException {
        return new AddTimetableLogicImpl();
    }

    @Override
    public UserLogic getUserManager() throws RemoteException {
        return new UserLogicImpl();
    }

    @Override
    public GenresLogic getGenresManager() throws RemoteException {
        return new GenresLogicImpl();
    }

    @Override
    public AddGenreLogic getAddGenreManager() throws RemoteException {
         return new AddGenreLogicImpl();
    }

    @Override
    public TicketLogic getTicketManager() throws RemoteException {
        return new TicketLogicImpl();
    }

    @Override
    public AddTicketLogic getAddTicketManager() throws RemoteException {
       return new AddTicketLogicImpl();
    }
    
}
