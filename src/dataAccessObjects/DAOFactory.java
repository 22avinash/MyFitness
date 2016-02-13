package dataAccessObjects;

public class DAOFactory {
	private DAOFactory(){}
	public static DAO getDAO(TABLE table){
		switch(table)
		{
		case EVENT:
			return new EventDAO();
		case F_SHARED_EVENT:
		case F_SHARED_IMG:
		case F_SHARED_LOC:
		case F_SHARED_VID:
		case FRIENDS:
		case G_SHARED_EVENT:
		case G_SHARED_IMG:
		case G_SHARED_LOC:
		case G_SHARED_VID:
		case GROUP_DETAIL:
		case IMAGE:
		case LOCATION:
		case MYGROUP:
		case PERSON:
			return new PersonDAO();
		case VIDEO:
		}
		return null;
	}
}
