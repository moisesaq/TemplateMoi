package moises.com.templatemoi.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import moises.com.templatemoi.model.Player;
import moises.com.templatemoi.model.Team;

import static moises.com.templatemoi.database.AppDataBase.DB_VERSION;

@Database(entities = { Team.class, Player.class }, version = DB_VERSION)
public abstract class AppDataBase extends RoomDatabase{
    public static final int DB_VERSION = 1;
    private static final String DB_NAME = "database_app";
    private static AppDataBase INSTANCE;

    public abstract TeamDao teamDao();
    public abstract PlayerDao playerDao();

    public static AppDataBase getInstance(Context context){
        if(INSTANCE == null)
            INSTANCE =  Room.databaseBuilder(
                    context.getApplicationContext(), AppDataBase.class, DB_NAME)
                    .build();

        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
