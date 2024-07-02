package com.example.comftyaccess.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\'J!\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000e\"\u00020\tH\'\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/comftyaccess/model/ReviewDao;", "", "deleteById", "", "reviewId", "", "getAllReviews", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/comftyaccess/model/Review;", "getReviewById", "", "insertAll", "reviews", "", "([Lcom/example/comftyaccess/model/Review;)V", "app_debug"})
@androidx.room.Dao
public abstract interface ReviewDao {
    
    @androidx.room.Query(value = "SELECT * FROM reviews")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.comftyaccess.model.Review>> getAllReviews();
    
    @androidx.room.Query(value = "select * from reviews where reviewId = :reviewId")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.comftyaccess.model.Review getReviewById(int reviewId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Review... reviews);
    
    @androidx.room.Query(value = "DELETE FROM reviews WHERE reviewId = :reviewId")
    public abstract void deleteById(@org.jetbrains.annotations.NotNull
    java.lang.String reviewId);
}