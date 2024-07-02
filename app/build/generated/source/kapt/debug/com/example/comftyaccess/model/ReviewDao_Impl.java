package com.example.comftyaccess.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ReviewDao_Impl implements ReviewDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Review> __insertionAdapterOfReview;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public ReviewDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReview = new EntityInsertionAdapter<Review>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `reviews` (`reviewId`,`hotelName`,`email`,`rate`,`age`,`accessNeed`,`img`,`description`,`lastUpdated`,`deleted`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Review value) {
        stmt.bindLong(1, value.getReviewId());
        if (value.getHotelName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getHotelName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        stmt.bindLong(4, value.getRate());
        stmt.bindLong(5, value.getAge());
        if (value.getAccessNeed() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAccessNeed());
        }
        if (value.getImg() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImg());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDescription());
        }
        if (value.getLastUpdated() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastUpdated());
        }
        final int _tmp = value.getDeleted() ? 1 : 0;
        stmt.bindLong(10, _tmp);
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM reviews WHERE reviewId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final Review... reviews) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReview.insert(reviews);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteById(final String reviewId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    if (reviewId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, reviewId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Review>> getAllReviews() {
    final String _sql = "SELECT * FROM reviews";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"reviews"}, false, new Callable<List<Review>>() {
      @Override
      public List<Review> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReviewId = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewId");
          final int _cursorIndexOfHotelName = CursorUtil.getColumnIndexOrThrow(_cursor, "hotelName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfRate = CursorUtil.getColumnIndexOrThrow(_cursor, "rate");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfAccessNeed = CursorUtil.getColumnIndexOrThrow(_cursor, "accessNeed");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
          final List<Review> _result = new ArrayList<Review>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Review _item;
            final int _tmpReviewId;
            _tmpReviewId = _cursor.getInt(_cursorIndexOfReviewId);
            final String _tmpHotelName;
            if (_cursor.isNull(_cursorIndexOfHotelName)) {
              _tmpHotelName = null;
            } else {
              _tmpHotelName = _cursor.getString(_cursorIndexOfHotelName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final int _tmpRate;
            _tmpRate = _cursor.getInt(_cursorIndexOfRate);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            final String _tmpAccessNeed;
            if (_cursor.isNull(_cursorIndexOfAccessNeed)) {
              _tmpAccessNeed = null;
            } else {
              _tmpAccessNeed = _cursor.getString(_cursorIndexOfAccessNeed);
            }
            final String _tmpImg;
            if (_cursor.isNull(_cursorIndexOfImg)) {
              _tmpImg = null;
            } else {
              _tmpImg = _cursor.getString(_cursorIndexOfImg);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Long _tmpLastUpdated;
            if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
              _tmpLastUpdated = null;
            } else {
              _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            }
            final boolean _tmpDeleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfDeleted);
            _tmpDeleted = _tmp != 0;
            _item = new Review(_tmpReviewId,_tmpHotelName,_tmpEmail,_tmpRate,_tmpAge,_tmpAccessNeed,_tmpImg,_tmpDescription,_tmpLastUpdated,_tmpDeleted);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Review getReviewById(final int reviewId) {
    final String _sql = "select * from reviews where reviewId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, reviewId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfReviewId = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewId");
      final int _cursorIndexOfHotelName = CursorUtil.getColumnIndexOrThrow(_cursor, "hotelName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfRate = CursorUtil.getColumnIndexOrThrow(_cursor, "rate");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfAccessNeed = CursorUtil.getColumnIndexOrThrow(_cursor, "accessNeed");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
      final int _cursorIndexOfDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "deleted");
      final Review _result;
      if(_cursor.moveToFirst()) {
        final int _tmpReviewId;
        _tmpReviewId = _cursor.getInt(_cursorIndexOfReviewId);
        final String _tmpHotelName;
        if (_cursor.isNull(_cursorIndexOfHotelName)) {
          _tmpHotelName = null;
        } else {
          _tmpHotelName = _cursor.getString(_cursorIndexOfHotelName);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final int _tmpRate;
        _tmpRate = _cursor.getInt(_cursorIndexOfRate);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        final String _tmpAccessNeed;
        if (_cursor.isNull(_cursorIndexOfAccessNeed)) {
          _tmpAccessNeed = null;
        } else {
          _tmpAccessNeed = _cursor.getString(_cursorIndexOfAccessNeed);
        }
        final String _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getString(_cursorIndexOfImg);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final Long _tmpLastUpdated;
        if (_cursor.isNull(_cursorIndexOfLastUpdated)) {
          _tmpLastUpdated = null;
        } else {
          _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
        }
        final boolean _tmpDeleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDeleted);
        _tmpDeleted = _tmp != 0;
        _result = new Review(_tmpReviewId,_tmpHotelName,_tmpEmail,_tmpRate,_tmpAge,_tmpAccessNeed,_tmpImg,_tmpDescription,_tmpLastUpdated,_tmpDeleted);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
