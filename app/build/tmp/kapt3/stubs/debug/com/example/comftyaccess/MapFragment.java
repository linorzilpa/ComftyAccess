package com.example.comftyaccess;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\rH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006&"}, d2 = {"Lcom/example/comftyaccess/MapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "allReviewsViewModel", "Lcom/example/comftyaccess/AllReviewsViewModel;", "getAllReviewsViewModel", "()Lcom/example/comftyaccess/AllReviewsViewModel;", "allReviewsViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/example/comftyaccess/databinding/FragmentMapBinding;", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "hotelViewModel", "LHotelViewModel;", "getHotelViewModel", "()LHotelViewModel;", "hotelViewModel$delegate", "addHotelsToMap", "", "hotels", "", "LHotel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "onStart", "onViewCreated", "view", "setupMapListeners", "map", "app_debug"})
public final class MapFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.google.android.gms.maps.GoogleMap googleMap;
    private com.example.comftyaccess.databinding.FragmentMapBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy hotelViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy allReviewsViewModel$delegate = null;
    
    public MapFragment() {
        super();
    }
    
    private final HotelViewModel getHotelViewModel() {
        return null;
    }
    
    private final com.example.comftyaccess.AllReviewsViewModel getAllReviewsViewModel() {
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
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onMapReady(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    private final void addHotelsToMap(java.util.List<Hotel> hotels) {
    }
    
    private final void setupMapListeners(com.google.android.gms.maps.GoogleMap map) {
    }
}