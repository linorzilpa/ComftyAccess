package com.example.comftyaccess;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JF\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010R\'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/comftyaccess/FilteredReviewsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "data", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/comftyaccess/model/Review;", "getData", "()Landroidx/lifecycle/LiveData;", "data$delegate", "Lkotlin/Lazy;", "repository", "Lcom/example/comftyaccess/model/Model;", "filterReviews", "reviews", "accessNeedType", "", "ageRangeType", "email", "rating", "hotelName", "app_debug"})
public final class FilteredReviewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.comftyaccess.model.Model repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy data$delegate = null;
    
    public FilteredReviewsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.comftyaccess.model.Review> filterReviews(@org.jetbrains.annotations.Nullable
    java.util.List<com.example.comftyaccess.model.Review> reviews, @org.jetbrains.annotations.Nullable
    java.lang.String accessNeedType, @org.jetbrains.annotations.NotNull
    java.lang.String ageRangeType, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String rating, @org.jetbrains.annotations.NotNull
    java.lang.String hotelName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.comftyaccess.model.Review>> getData() {
        return null;
    }
}