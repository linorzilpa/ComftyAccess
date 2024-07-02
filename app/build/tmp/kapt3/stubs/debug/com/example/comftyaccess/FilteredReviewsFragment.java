package com.example.comftyaccess;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\'()B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/comftyaccess/FilteredReviewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "accessNeedType", "", "ageRangeType", "binding", "Lcom/example/comftyaccess/databinding/FragmentFilteredReviewsBinding;", "email", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFirebaseAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "firebaseAuth$delegate", "Lkotlin/Lazy;", "hotelName", "rating", "reviewRecyclerAdapter", "Lcom/example/comftyaccess/FilteredReviewsFragment$ReviewRecyclerAdapter;", "viewModel", "Lcom/example/comftyaccess/FilteredReviewsViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "reloadData", "setupRecyclerView", "setupViewModel", "showDialogWithReviewDetails", "review", "Lcom/example/comftyaccess/model/Review;", "pos", "", "FilteredReviewsViewHolder", "OnItemClickListener", "ReviewRecyclerAdapter", "app_debug"})
public final class FilteredReviewsFragment extends androidx.fragment.app.Fragment {
    private com.example.comftyaccess.databinding.FragmentFilteredReviewsBinding binding;
    private com.example.comftyaccess.FilteredReviewsFragment.ReviewRecyclerAdapter reviewRecyclerAdapter;
    private com.example.comftyaccess.FilteredReviewsViewModel viewModel;
    @org.jetbrains.annotations.Nullable
    private java.lang.String accessNeedType;
    @org.jetbrains.annotations.Nullable
    private java.lang.String ageRangeType;
    @org.jetbrains.annotations.Nullable
    private java.lang.String email;
    @org.jetbrains.annotations.Nullable
    private java.lang.String rating;
    @org.jetbrains.annotations.Nullable
    private java.lang.String hotelName;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy firebaseAuth$delegate = null;
    
    public FilteredReviewsFragment() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth getFirebaseAuth() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupRecyclerView() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingInflatedId"})
    public final void showDialogWithReviewDetails(@org.jetbrains.annotations.NotNull
    com.example.comftyaccess.model.Review review, int pos) {
    }
    
    private final void setupViewModel() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    public final void reloadData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b\'\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/example/comftyaccess/FilteredReviewsFragment$FilteredReviewsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;", "(Landroid/view/View;Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;)V", "ageTV", "Landroid/widget/TextView;", "getAgeTV", "()Landroid/widget/TextView;", "setAgeTV", "(Landroid/widget/TextView;)V", "avatarImg", "Landroid/widget/ImageView;", "getAvatarImg", "()Landroid/widget/ImageView;", "setAvatarImg", "(Landroid/widget/ImageView;)V", "disTV", "getDisTV", "setDisTV", "hotelnameTV", "getHotelnameTV", "setHotelnameTV", "star1", "getStar1", "setStar1", "star2", "getStar2", "setStar2", "star3", "getStar3", "setStar3", "star4", "getStar4", "setStar4", "star5", "getStar5", "setStar5", "bind", "", "re", "Lcom/example/comftyaccess/model/Review;", "app_debug"})
    public static final class FilteredReviewsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView hotelnameTV;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView ageTV;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView disTV;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView avatarImg;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView star1;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView star2;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView star3;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView star4;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView star5;
        
        public FilteredReviewsViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView, @org.jetbrains.annotations.Nullable
        com.example.comftyaccess.FilteredReviewsFragment.OnItemClickListener listener) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getHotelnameTV() {
            return null;
        }
        
        public final void setHotelnameTV(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getAgeTV() {
            return null;
        }
        
        public final void setAgeTV(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDisTV() {
            return null;
        }
        
        public final void setDisTV(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getAvatarImg() {
            return null;
        }
        
        public final void setAvatarImg(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getStar1() {
            return null;
        }
        
        public final void setStar1(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getStar2() {
            return null;
        }
        
        public final void setStar2(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getStar3() {
            return null;
        }
        
        public final void setStar3(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getStar4() {
            return null;
        }
        
        public final void setStar4(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getStar5() {
            return null;
        }
        
        public final void setStar5(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.comftyaccess.model.Review re) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;", "", "onItemClick", "", "pos", "", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(int pos);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/example/comftyaccess/FilteredReviewsFragment$ReviewRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/comftyaccess/FilteredReviewsFragment$FilteredReviewsViewHolder;", "inflater", "Landroid/view/LayoutInflater;", "_data", "", "Lcom/example/comftyaccess/model/Review;", "(Landroid/view/LayoutInflater;Ljava/util/List;)V", "value", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "listener", "Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;", "getListener", "()Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;", "setListener", "(Lcom/example/comftyaccess/FilteredReviewsFragment$OnItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "app_debug"})
    public static final class ReviewRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.comftyaccess.FilteredReviewsFragment.FilteredReviewsViewHolder> {
        @org.jetbrains.annotations.NotNull
        private android.view.LayoutInflater inflater;
        @org.jetbrains.annotations.Nullable
        private java.util.List<com.example.comftyaccess.model.Review> _data;
        @org.jetbrains.annotations.Nullable
        private com.example.comftyaccess.FilteredReviewsFragment.OnItemClickListener listener;
        
        public ReviewRecyclerAdapter(@org.jetbrains.annotations.NotNull
        android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
        java.util.List<com.example.comftyaccess.model.Review> _data) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.comftyaccess.FilteredReviewsFragment.OnItemClickListener getListener() {
            return null;
        }
        
        public final void setListener(@org.jetbrains.annotations.Nullable
        com.example.comftyaccess.FilteredReviewsFragment.OnItemClickListener p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<com.example.comftyaccess.model.Review> getData() {
            return null;
        }
        
        public final void setData(@org.jetbrains.annotations.Nullable
        java.util.List<com.example.comftyaccess.model.Review> value) {
        }
        
        public final void setOnItemClickListener(@org.jetbrains.annotations.Nullable
        com.example.comftyaccess.FilteredReviewsFragment.OnItemClickListener listener) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.example.comftyaccess.FilteredReviewsFragment.FilteredReviewsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.example.comftyaccess.FilteredReviewsFragment.FilteredReviewsViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
    }
}