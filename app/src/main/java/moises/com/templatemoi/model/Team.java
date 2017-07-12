package moises.com.templatemoi.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Team {
    public static final String TABLE_NAME = "team";
    public static final String ID = "id";
    public static final String NAME = "name";

    @PrimaryKey @ColumnInfo(name = ID) public String id;
    @ColumnInfo(name = NAME) public String name;

    public String getId() {
        return id;
    }

    public Team setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }
}
