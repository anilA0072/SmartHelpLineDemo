package com.example.anil.smarthelpline.login_tabs;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.anil.smarthelpline.Navigation_Elements.modelListClick;
import com.example.anil.smarthelpline.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = "myTag";

    DbContract dbContract;
    ContentValues Values;
    private Resources mResources;
    public static final String DB_NAME="SmartHelpLine.db";
    public static final  int DB_VERSION=6  ;
    Context context;
    SQLiteDatabase sqLiteOpenHelper;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

      /*
create table users(
    id integer primary key autoincrement,
    email text,
    password text);
 */
    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public static final String CREATE_TABLE_USERS1 = "CREATE TABLE " + DbContract.FirstAid.TABLE_NAME + " ( "
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DbContract.FirstAid.COLUMN_NAME + " TEXT UNIQUE,"
            + DbContract.FirstAid.COLUMN_p0 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p1 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p2 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p3 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p4 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p5 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p6 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p7 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p8 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p9 + " TEXT ,"
            + DbContract.FirstAid.COLUMN_p10 + " TEXT );" ;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mResources=context.getResources();
        sqLiteOpenHelper=this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.v( "onupgrade","i ma here" );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbContract.FirstAid.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void readDataToDb(SQLiteDatabase db) throws IOException, JSONException {


         final String COLUMN_NAME="title";
         final String COLUMN_p0="p0";
         final String COLUMN_p1="p1";
         final String COLUMN_p2="p2";
         final String COLUMN_p3="p3";
         final String COLUMN_p4="p4";
         final String COLUMN_p5="p5";
         final String COLUMN_p6="p6";
         final String COLUMN_p7="p7";
         final String COLUMN_p8="p8";
         final String COLUMN_p9="p9";
         final String COLUMN_p10="p10";

        try {
            String jsonDataString = readJsonDataFromFile();
            JSONArray ItemsJsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < ItemsJsonArray.length(); ++i) {

                String title;
                String p0;String p1;String p2;String p3;String p4;String p5;String p6;String p7;
                String p8;String p9;String p10;


                JSONObject ItemObject = ItemsJsonArray.getJSONObject(i);


                title = ItemObject.getString(COLUMN_NAME);
                p0 = ItemObject.getString(COLUMN_p0);
                p1 = ItemObject.getString(COLUMN_p1);
                p2 = ItemObject.getString(COLUMN_p2);
                p3 = ItemObject.getString(COLUMN_p3);
                p4 = ItemObject.getString(COLUMN_p4);
                p5 = ItemObject.getString(COLUMN_p5);
                p6 = ItemObject.getString(COLUMN_p6);
                p7 = ItemObject.getString(COLUMN_p7);
                p8 = ItemObject.getString(COLUMN_p8);
                p9 = ItemObject.getString(COLUMN_p9);
                p10 = ItemObject.getString(COLUMN_p10);

                 Values = new ContentValues();

                Values.put(DbContract.FirstAid.COLUMN_NAME, title);
                Values.put(DbContract.FirstAid.COLUMN_p0, p0);
                Values.put(DbContract.FirstAid.COLUMN_p1, p1);
                Values.put(DbContract.FirstAid.COLUMN_p2, p2);
                Values.put(DbContract.FirstAid.COLUMN_p3, p3);
                Values.put(DbContract.FirstAid.COLUMN_p4, p4);
                Values.put(DbContract.FirstAid.COLUMN_p5, p5);
                Values.put(DbContract.FirstAid.COLUMN_p6, p6);
                Values.put(DbContract.FirstAid.COLUMN_p7, p7);
                Values.put(DbContract.FirstAid.COLUMN_p8, p8);
                Values.put(DbContract.FirstAid.COLUMN_p9, p9);
                Values.put(DbContract.FirstAid.COLUMN_p10, p10);

            long count=    db.insert(DbContract.FirstAid.TABLE_NAME, null, Values);


                Log.d(TAG, "Inserted Successfully " + Values );
                Log.d(TAG, "count_data " + count);
            }

        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS1);

        Log.d(TAG, "Database Created Successfully" );

        try {
            readDataToDb(sqLiteDatabase);
        } catch (IOException e) {
            Log.v( "exce",e.getMessage() );
        } catch (JSONException e) {
            Log.v( "json_exce",e.getMessage() );
        }

    }

    /**
     * Storing user details in database
     * */
    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public boolean getUser(String email, String pass){
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + COLUMN_PASS + " = " + "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

    public modelListClick getData(String title){

      modelListClick model=new modelListClick();
        String selectQuery = "select * from  " + DbContract.FirstAid.TABLE_NAME + " where title = ?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{title});
        cursor.moveToFirst();
       Log.v( "count","value "+cursor.getCount() );
      if(cursor.getCount()!=0){
         model.setTitle( cursor.getString( 1 ) );
         model.setP0( cursor.getString( 2 ) );
         model.setP1( cursor.getString( 3 ) );
         model.setP2( cursor.getString( 4 ) );
         model.setP3( cursor.getString( 5 ) );
         model.setP4( cursor.getString( 6 ) );
         model.setP5( cursor.getString( 7 ) );
         model.setP6( cursor.getString( 8 ) );
         model.setP7( cursor.getString( 9 ) );
         model.setP8( cursor.getString( 10 ) );
         model.setP9( cursor.getString( 11 ) );
         model.setP10( cursor.getString( 12 ) );
      }
        cursor.close();
        db.close();

        return model;
    }


    private String readJsonDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonDataString = null;
            inputStream = mResources.openRawResource( R.raw.firstaid);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }

}
