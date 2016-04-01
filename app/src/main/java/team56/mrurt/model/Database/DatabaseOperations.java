package team56.mrurt.model.Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import team56.mrurt.model.Movie;
import team56.mrurt.model.Rating;
import team56.mrurt.model.User;

/**
 * Created by Haruka on 2016/03/30.
 */

/**
 * A SQLiteOpenHelper class that manages all the database operations
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + UserData.TableInfo.TABLE_USER + "(" +
            UserData.TableInfo.USER_EMAIL + " TEXT," + UserData.TableInfo.USER_NAME + " TEXT," + UserData.TableInfo.NAME_USER + " TEXT," +
            UserData.TableInfo.MAJOR_USER + " TEXT," + UserData.TableInfo.BANNED_STATUS + " INTEGER," + UserData.TableInfo.ADMIN_STATUS + " INTEGER," + UserData.TableInfo.PASSWORD_USER + " TEXT );";
    public String CREATE_TABLE_RATINGS = "CREATE TABLE IF NOT EXISTS " + UserData.TableInfo.TABLE_MOVIE + "(" +
            UserData.TableInfo.USER_NAME + " TEXT," + UserData.TableInfo.MAJOR_USER + " TEXT," +
            UserData.TableInfo.MOVIE_TITLE + " TEXT," + UserData.TableInfo.MOVIE_YEAR + " TEXT," + UserData.TableInfo.MOVIE_SYNO + " TEXT," + UserData.TableInfo.MOVIE_CRITRATE +" TEXT," +
            UserData.TableInfo.MOVIE_RATE +" TEXT," +UserData.TableInfo.MOVIE_ID + " TEXT );";

    public DatabaseOperations (Context context) {
        super(context, UserData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Database Created");
    }
    private static DatabaseOperations instance;

    /**
     * Gets an instance of DatabaseOperations
     * @param context the application context
     * @return returns the instance of DatabaseOperations
     */
    public static synchronized DatabaseOperations getHelper(Context context) {
        if (instance == null)
            instance = new DatabaseOperations(context);

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_RATINGS);
        Log.d("Database Operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ON UPGRADE DROP OLDER TABLES
        db.execSQL("DROP TABLE IF EXISTS " + UserData.TableInfo.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + UserData.TableInfo.TABLE_MOVIE);

        onCreate(db);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
    /**
     * put user into user table
     */
    public void putUserInformation(DatabaseOperations dop, String email, String username, String name, String major, String password, int banned, int admin) {
        SQLiteDatabase SQ =  dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UserData.TableInfo.USER_EMAIL, email);
        cv.put(UserData.TableInfo.USER_NAME, username);
        cv.put(UserData.TableInfo.NAME_USER, name);
        cv.put(UserData.TableInfo.MAJOR_USER, major);
        cv.put(UserData.TableInfo.PASSWORD_USER, password);
        cv.put(UserData.TableInfo.BANNED_STATUS, banned);
        cv.put(UserData.TableInfo.ADMIN_STATUS, admin);

        //insert rows
        long k = SQ.insert(UserData.TableInfo.TABLE_USER, null, cv);
        Log.d("Database Operations", "Information inserted");
    }

    /**
     * put rating into movie table
     */
    public void addRating(DatabaseOperations db, Rating r) {
        SQLiteDatabase SQ =  db.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserData.TableInfo.USER_NAME, r.getUser());
        cv.put(UserData.TableInfo.MOVIE_TITLE, r.getMovie().getTitle());
        cv.put(UserData.TableInfo.MAJOR_USER, r.getMajor());
        cv.put(UserData.TableInfo.MOVIE_YEAR, r.getMovie().getYear());
        cv.put(UserData.TableInfo.MOVIE_SYNO, r.getMovie().getSynopsis());
        cv.put(UserData.TableInfo.MOVIE_CRITRATE, r.getMovie().getCriticsRating());
        cv.put(UserData.TableInfo.MOVIE_RATE, r.getMovie_Rating());
        cv.put(UserData.TableInfo.MOVIE_ID, r.getMovie().getId());

        long k = SQ.insert(UserData.TableInfo.TABLE_MOVIE, null, cv);
        Log.d("Database Operations", "rRating inserted");
    }

    /**
     * get all the users
     * @return returns a list of all the registered users
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + UserData.TableInfo.TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                String email = c.getString(c.getColumnIndex(UserData.TableInfo.USER_EMAIL));
                String username = c.getString(c.getColumnIndex(UserData.TableInfo.USER_NAME));
                String name = c.getString(c.getColumnIndex(UserData.TableInfo.NAME_USER));
                String major = c.getString(c.getColumnIndex(UserData.TableInfo.MAJOR_USER));
                String password = c.getString(c.getColumnIndex(UserData.TableInfo.PASSWORD_USER));
                int banned = c.getInt(c.getColumnIndex(UserData.TableInfo.BANNED_STATUS));
                int admin = c.getInt(c.getColumnIndex(UserData.TableInfo.ADMIN_STATUS));

                User u = new User(email, username, name, major, password);
                if(admin == 0) {
                    u.setAdminStatus(false);
                } else {
                    u.setAdminStatus(true);
                }
                if(banned == 0) {
                    u.setBanStatus(false);
                } else {
                    u.setBanStatus(true);
                }

                // adding to allUsers
                allUsers.add(u);
            } while (c.moveToNext());
        }

        return allUsers;
    }

    /**
     * Gets a single user
     * @return returns a single user
     */
    public User getSingleUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + UserData.TableInfo.TABLE_USER + " WHERE "
                + UserData.TableInfo.USER_NAME + " = " + username;
        Cursor c = db.rawQuery(selectQuery, null);

        String email = c.getString(c.getColumnIndex(UserData.TableInfo.USER_EMAIL));
        String username1 = c.getString(c.getColumnIndex(UserData.TableInfo.USER_NAME));
        String name = c.getString(c.getColumnIndex(UserData.TableInfo.NAME_USER));
        String major = c.getString(c.getColumnIndex(UserData.TableInfo.MAJOR_USER));
        String password = c.getString(c.getColumnIndex(UserData.TableInfo.PASSWORD_USER));
        int banned = c.getInt(c.getColumnIndex(UserData.TableInfo.BANNED_STATUS));
        int admin = c.getInt(c.getColumnIndex(UserData.TableInfo.ADMIN_STATUS));

        User u = new User(email, username1, name, major, password);

        if(admin == 0) {
            u.setAdminStatus(false);
        } else {
            u.setAdminStatus(true);
        }
        if(banned == 0) {
            u.setBanStatus(false);
        } else {
            u.setBanStatus(true);
        }
        return u;
    }
    /**
     * Gets all the ratings
     * @return returns an Arraylist of all the Ratings
     */
    public ArrayList<Rating> getAllRatings() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Rating> allRatings = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + UserData.TableInfo.TABLE_MOVIE;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                String username = c.getString(c.getColumnIndex(UserData.TableInfo.USER_NAME));
                String title = c.getString(c.getColumnIndex(UserData.TableInfo.MOVIE_TITLE));
                String major = c.getString(c.getColumnIndex(UserData.TableInfo.MAJOR_USER));
                String year = c.getString(c.getColumnIndex(UserData.TableInfo.MOVIE_YEAR));
                String synopsis = c.getString(c.getColumnIndex(UserData.TableInfo.MOVIE_SYNO));
                String critic_rate = c.getString(c.getColumnIndex(UserData.TableInfo.MOVIE_CRITRATE));
                double rating = c.getFloat(c.getColumnIndex(UserData.TableInfo.MOVIE_RATE));
                String id = c.getString(c.getColumnIndex(UserData.TableInfo.MOVIE_ID));

                Movie m = new Movie();
                m.setTitle(title);
                m.setYear(year);
                m.setSynopsis(synopsis);
                m.setCriticsRating(critic_rate);
                m.setId(id);

                Rating r = new Rating(major, username,m,rating);

                // adding to allUsers
                allRatings.add(r);
            } while (c.moveToNext());
        }
        return allRatings;
    }

    /**
     * Updates the user in the database
     * @param d The instance of the database
     * @param u the user we are going to update
     */
    public void updateUser(DatabaseOperations d, User u) {
        SQLiteDatabase db = d.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserData.TableInfo.BANNED_STATUS, u.getBanStatus());
        cv.put(UserData.TableInfo.ADMIN_STATUS, u.getAdminStatus());

        db.update(UserData.TableInfo.TABLE_USER, cv, " USER_EMAIL = ?", new String[]{u.getEmail()});
    }

    /**
     * Updates the user's movie rating in the database
     * @param d The instance of the database
     * @param r the rating we are going to update
     */
    public void updateRating(DatabaseOperations d, Rating r) {
        SQLiteDatabase db = d.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UserData.TableInfo.MOVIE_RATE, r.getMovie_Rating());
        db.update(UserData.TableInfo.TABLE_MOVIE, values, " USER_NAME = ?", new String[]{r.getUser()});
    }

    /**
     * Updates the user's movie rating in the database
     * @param d The instance of the database
     * @param newUsername the new user name
     * @param oldUsername the users old username
     */
    public void updateUserRating(DatabaseOperations d, String newUsername, String oldUsername) {
        SQLiteDatabase db = d.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UserData.TableInfo.USER_NAME, newUsername);
        db.update(UserData.TableInfo.TABLE_MOVIE, values, " USER_NAME = ?", new String[]{oldUsername});
    }

    /**
     * Deletes User based on their email
     * @param d The instance of the database
     * @param email the user we will delete
     */
    public void deleteUser(DatabaseOperations d, String email) {
        SQLiteDatabase db = d.getWritableDatabase();
        db.delete(UserData.TableInfo.TABLE_USER, UserData.TableInfo.USER_EMAIL + " = ?", new String[]{email});
    }
}
