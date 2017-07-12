package moises.com.templatemoi.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import moises.com.templatemoi.model.Team;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TeamDao {
    @Query("SELECT * FROM " + Team.TABLE_NAME)
    List<Team> findAllTeamSync();

    @Insert(onConflict = IGNORE)
    void insert(Team team);

    @Update(onConflict = REPLACE)
    int update(Team team);

    @Query("DELETE FROM " + Team.TABLE_NAME)
    void deleteAll();

    @Query("SELECT * FROM " + Team.TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM " + Team.TABLE_NAME + " WHERE id = :id")
    Cursor selectById(String id);
}
