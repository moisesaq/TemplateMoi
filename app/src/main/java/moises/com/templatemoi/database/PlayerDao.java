package moises.com.templatemoi.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import moises.com.templatemoi.model.Player;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM " + Player.TABLE_NAME)
    List<Player> findAllPlayerSync();

    @Insert(onConflict = IGNORE)
    void insert(Player player);

    @Update(onConflict = REPLACE)
    int update(Player player);

    @Query("DELETE FROM " + Player.TABLE_NAME)
    void deleteAll();

    @Query("SELECT * FROM " + Player.TABLE_NAME)
    Cursor selectAll();

    @Query("SELECT * FROM " + Player.TABLE_NAME + " WHERE id = :id")
    Cursor selectById(String id);
}
