package com.example.comftyaccess;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0003J\b\u0010\u001b\u001a\u00020\u001aH\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010\'\u001a\u00020\u0016H\u0002J#\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u00a2\u0006\u0002\u0010,R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/comftyaccess/AddReviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "auth$delegate", "Lkotlin/Lazy;", "binding", "Lcom/example/comftyaccess/databinding/FragmentAddReviewBinding;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "email", "", "galleryLauncher", "hotelViewModel", "LHotelViewModel;", "isAvatarSelected", "", "addReview", "", "description", "hotelName", "rate", "", "getSelectedRate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setupActivityResultLaunchers", "setupStarRating", "showLoginDialog", "updateStars", "stars", "", "Landroid/widget/ImageView;", "([Landroid/widget/ImageView;I)V", "app_debug"})
public final class AddReviewFragment extends androidx.fragment.app.Fragment {
    private com.example.comftyaccess.databinding.FragmentAddReviewBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy auth$delegate = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String email = "";
    private androidx.activity.result.ActivityResultLauncher<java.lang.Void> cameraLauncher;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher;
    private boolean isAvatarSelected = false;
    private HotelViewModel hotelViewModel;
    
    public AddReviewFragment() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void showLoginDialog() {
    }
    
    @android.annotation.SuppressLint(value = {"SuspiciousIndentation"})
    private final void addReview(java.lang.String description, java.lang.String hotelName, int rate) {
    }
    
    private final int getSelectedRate() {
        return 0;
    }
    
    private final void setupStarRating() {
    }
    
    private final void updateStars(android.widget.ImageView[] stars, int rate) {
    }
    
    private final void setupActivityResultLaunchers() {
    }
}