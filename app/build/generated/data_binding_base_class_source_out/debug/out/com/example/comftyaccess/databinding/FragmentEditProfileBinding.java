// Generated by view binder compiler. Do not edit!
package com.example.comftyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comftyaccess.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEditProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Spinner accessNeedSpinnerSpinnerFilter;

  @NonNull
  public final TextView accessNeedTvEprofile;

  @NonNull
  public final TextInputEditText ageEditText;

  @NonNull
  public final TextInputLayout ageInputEprofile;

  @NonNull
  public final Button cancelBtEprofile;

  @NonNull
  public final ImageButton eProfileCameraBt;

  @NonNull
  public final ImageView eProfileGalleryIv;

  @NonNull
  public final TextView emailEprofileTv;

  @NonNull
  public final TextInputEditText fullNameEditText;

  @NonNull
  public final TextInputLayout fullNameInputEprofile;

  @NonNull
  public final TextView helloEprofileTv;

  @NonNull
  public final ProgressBar progressBarEP;

  @NonNull
  public final Button saveBtEprofile;

  @NonNull
  public final TextView titleEprofileTv;

  @NonNull
  public final ImageView userEprofileIv;

  private FragmentEditProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull Spinner accessNeedSpinnerSpinnerFilter, @NonNull TextView accessNeedTvEprofile,
      @NonNull TextInputEditText ageEditText, @NonNull TextInputLayout ageInputEprofile,
      @NonNull Button cancelBtEprofile, @NonNull ImageButton eProfileCameraBt,
      @NonNull ImageView eProfileGalleryIv, @NonNull TextView emailEprofileTv,
      @NonNull TextInputEditText fullNameEditText, @NonNull TextInputLayout fullNameInputEprofile,
      @NonNull TextView helloEprofileTv, @NonNull ProgressBar progressBarEP,
      @NonNull Button saveBtEprofile, @NonNull TextView titleEprofileTv,
      @NonNull ImageView userEprofileIv) {
    this.rootView = rootView;
    this.accessNeedSpinnerSpinnerFilter = accessNeedSpinnerSpinnerFilter;
    this.accessNeedTvEprofile = accessNeedTvEprofile;
    this.ageEditText = ageEditText;
    this.ageInputEprofile = ageInputEprofile;
    this.cancelBtEprofile = cancelBtEprofile;
    this.eProfileCameraBt = eProfileCameraBt;
    this.eProfileGalleryIv = eProfileGalleryIv;
    this.emailEprofileTv = emailEprofileTv;
    this.fullNameEditText = fullNameEditText;
    this.fullNameInputEprofile = fullNameInputEprofile;
    this.helloEprofileTv = helloEprofileTv;
    this.progressBarEP = progressBarEP;
    this.saveBtEprofile = saveBtEprofile;
    this.titleEprofileTv = titleEprofileTv;
    this.userEprofileIv = userEprofileIv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEditProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_edit_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEditProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.access_need_spinner_spinner_filter;
      Spinner accessNeedSpinnerSpinnerFilter = ViewBindings.findChildViewById(rootView, id);
      if (accessNeedSpinnerSpinnerFilter == null) {
        break missingId;
      }

      id = R.id.access_need_tv_eprofile;
      TextView accessNeedTvEprofile = ViewBindings.findChildViewById(rootView, id);
      if (accessNeedTvEprofile == null) {
        break missingId;
      }

      id = R.id.age_editText;
      TextInputEditText ageEditText = ViewBindings.findChildViewById(rootView, id);
      if (ageEditText == null) {
        break missingId;
      }

      id = R.id.age_input_eprofile;
      TextInputLayout ageInputEprofile = ViewBindings.findChildViewById(rootView, id);
      if (ageInputEprofile == null) {
        break missingId;
      }

      id = R.id.cancel_bt_eprofile;
      Button cancelBtEprofile = ViewBindings.findChildViewById(rootView, id);
      if (cancelBtEprofile == null) {
        break missingId;
      }

      id = R.id.eProfile_camera_bt;
      ImageButton eProfileCameraBt = ViewBindings.findChildViewById(rootView, id);
      if (eProfileCameraBt == null) {
        break missingId;
      }

      id = R.id.eProfile_gallery_iv;
      ImageView eProfileGalleryIv = ViewBindings.findChildViewById(rootView, id);
      if (eProfileGalleryIv == null) {
        break missingId;
      }

      id = R.id.email_eprofile_tv;
      TextView emailEprofileTv = ViewBindings.findChildViewById(rootView, id);
      if (emailEprofileTv == null) {
        break missingId;
      }

      id = R.id.fullName_editText;
      TextInputEditText fullNameEditText = ViewBindings.findChildViewById(rootView, id);
      if (fullNameEditText == null) {
        break missingId;
      }

      id = R.id.fullName_input_eprofile;
      TextInputLayout fullNameInputEprofile = ViewBindings.findChildViewById(rootView, id);
      if (fullNameInputEprofile == null) {
        break missingId;
      }

      id = R.id.hello_eprofile_tv;
      TextView helloEprofileTv = ViewBindings.findChildViewById(rootView, id);
      if (helloEprofileTv == null) {
        break missingId;
      }

      id = R.id.progressBar_EP;
      ProgressBar progressBarEP = ViewBindings.findChildViewById(rootView, id);
      if (progressBarEP == null) {
        break missingId;
      }

      id = R.id.save_bt_eprofile;
      Button saveBtEprofile = ViewBindings.findChildViewById(rootView, id);
      if (saveBtEprofile == null) {
        break missingId;
      }

      id = R.id.title_eprofile_tv;
      TextView titleEprofileTv = ViewBindings.findChildViewById(rootView, id);
      if (titleEprofileTv == null) {
        break missingId;
      }

      id = R.id.user_eprofile_iv;
      ImageView userEprofileIv = ViewBindings.findChildViewById(rootView, id);
      if (userEprofileIv == null) {
        break missingId;
      }

      return new FragmentEditProfileBinding((ConstraintLayout) rootView,
          accessNeedSpinnerSpinnerFilter, accessNeedTvEprofile, ageEditText, ageInputEprofile,
          cancelBtEprofile, eProfileCameraBt, eProfileGalleryIv, emailEprofileTv, fullNameEditText,
          fullNameInputEprofile, helloEprofileTv, progressBarEP, saveBtEprofile, titleEprofileTv,
          userEprofileIv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
