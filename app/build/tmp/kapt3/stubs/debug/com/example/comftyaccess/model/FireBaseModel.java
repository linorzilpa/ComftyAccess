package com.example.comftyaccess.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u0014J\u001a\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0014J$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/comftyaccess/model/FireBaseModel;", "", "()V", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "addReview", "", "review", "Lcom/example/comftyaccess/model/Review;", "listener", "Lcom/example/comftyaccess/model/Model$ListenerVoid;", "addUser", "user", "Lcom/example/comftyaccess/model/User;", "getAllReviewsSince", "since", "", "callback", "Lcom/example/comftyaccess/model/Model$Listener;", "", "getAllUsers", "uploadImage", "name", "", "bitmap", "Landroid/graphics/Bitmap;", "app_debug"})
public final class FireBaseModel {
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    
    public FireBaseModel() {
        super();
    }
    
    public final void getAllReviewsSince(long since, @org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Model.Listener<java.util.List<com.example.comftyaccess.model.Review>> callback) {
    }
    
    public final void addReview(@org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Review review, @org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Model.ListenerVoid listener) {
    }
    
    public final void getAllUsers(@org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Model.Listener<java.util.List<com.example.comftyaccess.model.User>> callback) {
    }
    
    public final void addUser(@org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.User user, @org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Model.ListenerVoid listener) {
    }
    
    public final void uploadImage(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Model.Listener<java.lang.String> listener) {
    }
}