package com.example.venkateswaris.expensetracker;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BaseDAO extends SQLiteOpenHelper {
    private Context context;
    private static SQLiteDatabase writableDatabase;

    public BaseDAO(Context context, int version, String DATABASE_NAME) {
        super(context, DATABASE_NAME, null, version);
        this.context = context;
         writableDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        readAndExecuteSQLScript(db,context,R.raw.create_expense_table);
    }

    protected void executeSql(String sqlStatement) {
        writableDatabase.beginTransaction();
        writableDatabase.execSQL(sqlStatement);
        writableDatabase.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DB","Database upgrade");
    }

    private void readAndExecuteSQLScript(SQLiteDatabase db, Context ctx,
                                         Integer sqlScriptResId) {
        Resources res = ctx.getResources();

        try {
            InputStream is = res.openRawResource(sqlScriptResId);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            executeSQLScript(db, reader);

            reader.close();
            isr.close();
            is.close();

        } catch (IOException e) {
            throw new RuntimeException("Unable to read SQL script", e);
        }
    }

    private void executeSQLScript(SQLiteDatabase db, BufferedReader reader)
            throws IOException {
        String line;
        StringBuilder statement = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            statement.append(line);
            statement.append("\n");
            if (line.endsWith(";")) {
                db.execSQL(statement.toString());
                statement = new StringBuilder();
            }
        }
    }
}
