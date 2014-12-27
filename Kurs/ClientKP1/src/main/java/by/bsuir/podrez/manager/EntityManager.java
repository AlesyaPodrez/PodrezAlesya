package by.bsuir.podrez.manager;

import by.bsuir.podrez.logic.ActorsLogic;
import by.bsuir.podrez.logic.AddActorsLogic;
import by.bsuir.podrez.logic.AddGenreLogic;
import by.bsuir.podrez.logic.AddLogic;
import by.bsuir.podrez.logic.AddTicketLogic;
import by.bsuir.podrez.logic.AddTimetableLogic;
import by.bsuir.podrez.logic.GenresLogic;
import by.bsuir.podrez.logic.LoginLogic;
import by.bsuir.podrez.logic.PerformancesLogic;
import by.bsuir.podrez.logic.TicketLogic;
import by.bsuir.podrez.logic.TimetableLogic;
import by.bsuir.podrez.logic.UserLogic;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EntityManager extends Remote{
    public LoginLogic getLoginManager() throws RemoteException;
    public TimetableLogic getTimetableManager() throws RemoteException;
    public PerformancesLogic getPerformancesManager() throws RemoteException;
    public AddLogic getAddManager() throws RemoteException;
    public ActorsLogic getActorsManager() throws RemoteException;
    public AddActorsLogic getAddActorsManager() throws RemoteException;
    public AddTimetableLogic getAddTimetableManager() throws RemoteException;
    public UserLogic getUserManager() throws RemoteException;
    public GenresLogic getGenresManager() throws RemoteException;
    public AddGenreLogic getAddGenreManager() throws RemoteException;
    public TicketLogic getTicketManager() throws RemoteException;
    public AddTicketLogic getAddTicketManager() throws RemoteException;
}
