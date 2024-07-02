// Generated by view binder compiler. Do not edit!
package com.example.comftyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comftyaccess.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMyProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView accessneedProfileTv;

  @NonNull
  public final TextView accessneedTitleProfileTv;

  @NonNull
  public final TextView ageProfileTv;

  @NonNull
  public final TextView ageTitleProfileTv;

  @NonNull
  public final ImageView editMyprofileIv;

  @NonNull
  public final ImageView editMyprofileIv2;

  @NonNull
  public final TextView emailProfileTv;

  @NonNull
  public final TextView fullnameProfileTv;

  @NonNull
  public final TextView fullnameTitleProfileTv;

  @NonNull
  public final TextView helloProfileTv;

  @NonNull
  public final Button myReviewsMyprofileBt;

  @NonNull
  public final ProgressBar progressBarMyProf;

  @NonNull
  public final TextView titleProfileTv;

  @NonNull
  public final ImageView userProfileIv;

  private FragmentMyProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView accessneedProfileTv, @NonNull TextView accessneedTitleProfileTv,
      @NonNull TextView ageProfileTv, @NonNull TextView ageTitleProfileTv,
      @NonNull ImageView editMyprofileIv, @NonNull ImageView editMyprofileIv2,
      @NonNull TextView emailProfileTv, @NonNull TextView fullnameProfileTv,
      @NonNull TextView fullnameTitleProfileTv, @NonNull TextView helloProfileTv,
      @NonNull Button myReviewsMyprofileBt, @NonNull ProgressBar progressBarMyProf,
      @NonNull TextView titleProfileTv, @NonNull ImageView userProfileIv) {
    this.rootView = rootView;
    this.accessneedProfileTv = accessneedProfileTv;
    this.accessneedTitleProfileTv = accessneedTitleProfileTv;
    this.ageProfileTv = ageProfileTv;
    this.ageTitleProfileTv = ageTitleProfileTv;
    this.editMyprofileIv = editMyprofileIv;
    this.editMyprofileIv2 = editMyprofileIv2;
    this.emailProfileTv = emailProfileTv;
    this.fullnameProfileTv = fullnameProfileTv;
    this.fullnameTitleProfileTv = fullnameTitleProfileTv;
    this.helloProfileTv = helloProfileTv;
    this.myReviewsMyprofileBt = myReviewsMyprofileBt;
    this.progressBarMyProf = progressBarMyProf;
    this.titleProfileTv = titleProfileTv;
    this.userProfileIv = userProfileIv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accessneed_profile_tv;
      TextView accessneedProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (accessneedProfileTv == null) {
        break missingId;
      }

      id = R.id.accessneed_title_profile_tv;
      TextView accessneedTitleProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (accessneedTitleProfileTv == null) {
        break missingId;
      }

      id = R.id.age_profile_tv;
      TextView ageProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (ageProfileTv == null) {
        break missingId;
      }

      id = R.id.age_title_profile_tv;
      TextView ageTitleProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (ageTitleProfileTv == null) {
        break missingId;
      }

      id = R.id.edit_myprofile_iv;
      ImageView editMyprofileIv = ViewBindings.findChildViewById(rootView, id);
      if (editMyprofileIv == null) {
        break missingId;
      }

      id = R.id.edit_myprofile_iv2;
      ImageView editMyprofileIv2 = ViewBindings.findChildViewById(rootView, id);
      if (editMyprofileIv2 == null) {
        break missingId;
      }

      id = R.id.email_profile_tv;
      TextView emailProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (emailProfileTv == null) {
        break missingId;
      }

      id = R.id.fullname_profile_tv;
      TextView fullnameProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (fullnameProfileTv == null) {
        break missingId;
      }

      id = R.id.fullname_title_profile_tv;
      TextView fullnameTitleProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (fullnameTitleProfileTv == null) {
        break missingId;
      }

      id = R.id.hello_profile_tv;
      TextView helloProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (helloProfileTv == null) {
        break missingId;
      }

      id = R.id.myReviews_myprofile_bt;
      Button myReviewsMyprofileBt = ViewBindings.findChildViewById(rootView, id);
      if (myReviewsMyprofileBt == null) {
        break missingId;
      }

      id = R.id.progressBar_MyProf;
      ProgressBar progressBarMyProf = ViewBindings.findChildViewById(rootView, id);
      if (progressBarMyProf == null) {
        break missingId;
      }

      id = R.id.title_profile_tv;
      TextView titleProfileTv = ViewBindings.findChildViewById(rootView, id);
      if (titleProfileTv == null) {
        break missingId;
      }

      id = R.id.user_profile_iv;
      ImageView userProfileIv = ViewBindings.findChildViewById(rootView, id);
      if (userProfileIv == null) {
        break missingId;
      }

      return new FragmentMyProfileBinding((ConstraintLayout) rootView, accessneedProfileTv,
          accessneedTitleProfileTv, ageProfileTv, ageTitleProfileTv, editMyprofileIv,
          editMyprofileIv2, emailProfileTv, fullnameProfileTv, fullnameTitleProfileTv,
          helloProfileTv, myReviewsMyprofileBt, progressBarMyProf, titleProfileTv, userProfileIv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
