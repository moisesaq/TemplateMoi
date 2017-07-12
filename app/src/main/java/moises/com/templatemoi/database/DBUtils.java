package moises.com.templatemoi.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MergeCursor;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.Random;

import moises.com.templatemoi.model.Player;
import moises.com.templatemoi.model.Team;

public class DBUtils {

    public static void testDatabaseSync(@NonNull Context context){
        new TestDatabaseAsync(AppDataBase.getInstance(context), context).execute();
    }

    //TODO Replace with Observable RXJava
    private static class TestDatabaseAsync extends AsyncTask<Void, Void, Void> {

        private final AppDataBase db;
        private final Context context;

        TestDatabaseAsync(AppDataBase db, Context context) {
            this.db = db;
            this.context = context;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(db, context);
            return null;
        }
    }

    private static void populateWithTestData(AppDataBase db, Context context){
        deleteAllDatabase(db);
        try{
            /** NORMAL TEST */
            String teamId1 = "team-01";
            String teamId2 = "team-02";
            addTeam(db, teamId1, "River Plate");
            addPlayer(db, "player-01", "Alario", teamId1);
            addPlayer(db, "player-02", "Mora", teamId1);

            showAllDatabase(db);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void addTeam(AppDataBase db, String id, String name){
        Team team = new Team().setId(id).setName(name);
        db.teamDao().insert(team);
    }

    private static void addPlayer(AppDataBase db, String id, String name, String teamId){
        Player player = new Player().setId(id).setName(name).setTeamId(teamId);
        db.playerDao().insert(player);
    }

    private static void deleteAllDatabase(AppDataBase db){
        db.teamDao().deleteAll();
        db.playerDao().deleteAll();
    }

    public static void showAllDatabase(AppDataBase db){
        Cursor cursor = new MergeCursor(new Cursor[]
                {
                        db.teamDao().selectAll(),
                        db.playerDao().selectAll()
                });

        DatabaseUtils.dumpCursor(cursor);
    }

    private static String getLabelRandon(){
        Random rand = new Random();
        return String.format("%s %s", "MY CAR", rand.nextInt(40));
    }
}
