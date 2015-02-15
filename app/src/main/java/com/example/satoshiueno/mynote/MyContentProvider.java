package com.example.satoshiueno.mynote;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by satoshiueno on 15/02/15.
 */
public class MyContentProvider extends ContentProvider {

	private static final String AUTHORITY = "com.example.satoshiueno.mynote.MyContentProvider";
	private MyDbHelper myDbHelper;
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + MyMemoContract.Memos.TABLE_NAME);

	private static final int MEMOS = 1;
	private static final int MEMO_ITEM = 2;

	private static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, MyMemoContract.Memos.TABLE_NAME, MEMOS);
		uriMatcher.addURI(AUTHORITY, MyMemoContract.Memos.TABLE_NAME + "/#", MEMO_ITEM);
	}

	@Override
	public boolean onCreate() {
		myDbHelper = new MyDbHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		if(uriMatcher.match(uri) != MEMOS) {
			throw new IllegalArgumentException("Unknown URI:" + uri);
		}

		SQLiteDatabase db = myDbHelper.getReadableDatabase();
		Cursor cursor = db.query(
			MyMemoContract.Memos.TABLE_NAME,
			projection,
			selection,
			selectionArgs,
			null,
			null,
			sortOrder
		);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}
}
