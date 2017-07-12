package moises.com.templatemoi.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static moises.com.templatemoi.model.Player.TEAM_ID;

@Entity(foreignKeys = @ForeignKey(entity = Team.class, parentColumns = Team.ID, childColumns = TEAM_ID)/*, indices = {@Index(value = {TEAM_ID}, unique = true)}*/)
public class Player {
    public static final String TABLE_NAME = "player";
    public static final String ID = "id";
    public static final String NAME = "NAME";
    public static final String TEAM_ID = "team_id";

    @PrimaryKey @ColumnInfo(name = ID) public String id;
    @ColumnInfo(name = NAME) public String name;
    @ColumnInfo(name = TEAM_ID) public String teamId;

    public String getId() {
        return id;
    }

    public Player setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public String getTeamId() {
        return teamId;
    }

    public Player setTeamId(String teamId) {
        this.teamId = teamId;
        return this;
    }
}
