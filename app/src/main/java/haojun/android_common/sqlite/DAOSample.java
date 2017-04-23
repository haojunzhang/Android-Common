package haojun.android_common.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import haojun.android_common.model.SampleModel;


public class DAOSample {
    // table name
    public static final String TABLE_NAME = "Sample";
    // pk
    private static final String ID = "SampleId";
    // other column
    private static final String TEXT = "SampleText";
    private static final String INTEGER = "SampleInteger";

    static String createTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("Create Table " + TABLE_NAME + " ( ");
        sb.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT , ");
        sb.append(TEXT + " TEXT NOT NULL, ");
        sb.append(INTEGER + " INTEGER NOT NULL) ");
        return sb.toString();
    }

    private SQLiteDatabase db;

    public DAOSample(Context context) {
        db = DBHelper.getDatabase(context);
    }

    public SampleModel insert(SampleModel sample) {

        ContentValues cv = new ContentValues();

        cv.put(TEXT, sample.getSampleText());
        cv.put(INTEGER, sample.getSampleInteger());

        long id = db.insert(TABLE_NAME, null, cv);

        sample.setSampleId((int) id);

        return sample;
    }

    public boolean update(SampleModel sample) {

        ContentValues cv = new ContentValues();

        cv.put(TEXT, sample.getSampleText());
        cv.put(INTEGER, sample.getSampleInteger());

        String where = ID + "=" + sample.getSampleId();

        return db.update(TABLE_NAME, cv, where, null) > 0;
    }


    public boolean delete(int id) {

        String where = ID + "=" + id;

        return db.delete(TABLE_NAME, where, null) > 0;
    }

    public List<SampleModel> getAll() {
        List<SampleModel> result = new ArrayList<>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }


    public SampleModel get(int id) {

        SampleModel item = null;

        String where = ID + "=" + id;

        Cursor result = db.query(
                TABLE_NAME, null, where, null, null, null, null, null);


        if (result.moveToFirst()) {

            item = getRecord(result);
        }


        result.close();

        return item;
    }

    public SampleModel getRecord(Cursor cursor) {

        SampleModel result = new SampleModel();
        result.setSampleId((int) cursor.getLong(0));
        result.setSampleText(cursor.getString(1));
        result.setSampleInteger(cursor.getInt(2));

        return result;
    }


    public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }
        cursor.close();
        return result;
    }

    public void sample() {
        SampleModel c1 = new SampleModel(0, "text1", 123);
        insert(c1);
    }

}
