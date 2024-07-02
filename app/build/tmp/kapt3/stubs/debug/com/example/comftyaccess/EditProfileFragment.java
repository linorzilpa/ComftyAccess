package com.example.comftyaccess;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/comftyaccess/EditProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "accessNeedType", "", "accessNeedsOptions", "", "binding", "Lcom/example/comftyaccess/databinding/FragmentEditProfileBinding;", "cameraLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "firebaseAuth$delegate", "Lkotlin/Lazy;", "galleryLauncher", "isAvatarSelected", "", "bindProfile", "", "createAccessNeedSpinner", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "saveUserUpdate", "setupActivityResultLaunchers", "app_debug"})
public final class EditProfileFragment extends androidx.fragment.app.Fragment {
    private com.example.comftyaccess.databinding.FragmentEditProfileBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy firebaseAuth$delegate = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String accessNeedType;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> accessNeedsOptions = null;
    private boolean isAvatarSelected = false;
    private androidx.activity.result.ActivityResultLauncher<java.lang.Void> cameraLauncher;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher;
    
    public EditProfileFragment() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
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
    
    private final void saveUserUpdate() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void bindProfile() {
    }
    
    private final void createAccessNeedSpinner() {
    }
    
    private final void setupActivityResultLaunchers() {
    }
}