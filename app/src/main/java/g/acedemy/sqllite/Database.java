package g.acedemy.sqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    Context context;
    String name;
    SQLiteDatabase.CursorFactory factory;
    int version;

    public Database( @Nullable Context context,  @Nullable String name,  @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
        this.name=name;
        this.factory=factory;
        this.version=version;

    }
    //try van khong tra ket qua
    public void QueryDatabase(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    //truy van co ket qua tra ve
    public Cursor GetDatabase(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
