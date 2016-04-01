package team56.mrurt.model.Database;

import android.provider.BaseColumns;

/**
 * Created by Haruka on 2016/03/30.
 */
public class UserData {
    public UserData(){
    }

    public static abstract class TableInfo implements BaseColumns{
        //USER TABLE
        public static final String USER_EMAIL = "USER_EMAIL"; //KEY
        public static final String USER_NAME = "USER_NAME";
        public static final String NAME_USER = "NAME";
        public static final String MAJOR_USER = "MAJOR";
        public static final String PASSWORD_USER = "PASSWORD";
        public static final String DATABASE_NAME = "USER_INFO";
        public static final String TABLE_USER = "USER_INFO";
        public static final String BANNED_STATUS = "BANNED_STATUS";
        public static final String ADMIN_STATUS = "ADMIN_STATUS";
        //RATING DATABASE
        public static final String MOVIE_TITLE = "TITLE";
        public static final String MOVIE_YEAR = "YEAR";
        public static final String MOVIE_SYNO = "SYNOPSIS";
        public static final String MOVIE_CRITRATE = "CRITICS_RATING";
        public static final String MOVIE_RATE = "USER_RATING";
        public static final String MOVIE_ID = "MOVIE_ID";
        public static final String TABLE_MOVIE = "MOVIE_INFO";
    }
}
