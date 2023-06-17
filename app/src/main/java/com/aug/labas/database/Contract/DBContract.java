package com.aug.labas.database.Contract;

import android.provider.BaseColumns;

public final class DBContract {
    private DBContract() {
    }

    public static class DBEntry implements BaseColumns {
        public static final String TABLE_NAME = "people";

        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PHONE = "phone";

        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_DATE = "date_of_birth";
    }
}