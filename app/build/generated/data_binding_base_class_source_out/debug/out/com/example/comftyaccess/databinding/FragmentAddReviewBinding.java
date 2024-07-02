// Generated by view binder compiler. Do not edit!
package com.example.comftyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comftyaccess.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddReviewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btAddReview;

  @NonNull
  public final Button btCancelReview;

  @NonNull
  public final ImageButton btnCameraAddReview;

  @NonNull
  public final ImageButton btnGalleryAddReview;

  @NonNull
  public final TextInputEditText descriptionEditTextAddReview;

  @NonNull
  public final TextInputLayout descriptionInputAddReview;

  @NonNull
  public final TextView emailTvAddReview;

  @NonNull
  public final Spinner hotelNameSpinnerAddReview;

  @NonNull
  public final MaterialTextView hotelNameTvAddReview;

  @NonNull
  public final ImageView ivAddReview;

  @NonNull
  public final MaterialCardView materialCardViewAddReivew;

  @NonNull
  public final ProgressBar progressBarAR;

  @NonNull
  public final ImageView rowStar1AddReview;

  @NonNull
  public final ImageView rowStar2AddReview;

  @NonNull
  public final ImageView rowStar3AddReview;

  @NonNull
  public final ImageView rowStar4AddReview;

  @NonNull
  public final ImageView rowStar5AddReview;

  @NonNull
  public final ScrollView scrollView2;

  @NonNull
  public final TextView textView4;

  private FragmentAddReviewBinding(@NonNull ConstraintLayout rootView, @NonNull Button btAddReview,
      @NonNull Button btCancelReview, @NonNull ImageButton btnCameraAddReview,
      @NonNull ImageButton btnGalleryAddReview,
      @NonNull TextInputEditText descriptionEditTextAddReview,
      @NonNull TextInputLayout descriptionInputAddReview, @NonNull TextView emailTvAddReview,
      @NonNull Spinner hotelNameSpinnerAddReview, @NonNull MaterialTextView hotelNameTvAddReview,
      @NonNull ImageView ivAddReview, @NonNull MaterialCardView materialCardViewAddReivew,
      @NonNull ProgressBar progressBarAR, @NonNull ImageView rowStar1AddReview,
      @NonNull ImageView rowStar2AddReview, @NonNull ImageView rowStar3AddReview,
      @NonNull ImageView rowStar4AddReview, @NonNull ImageView rowStar5AddReview,
      @NonNull ScrollView scrollView2, @NonNull TextView textView4) {
    this.rootView = rootView;
    this.btAddReview = btAddReview;
    this.btCancelReview = btCancelReview;
    this.btnCameraAddReview = btnCameraAddReview;
    this.btnGalleryAddReview = btnGalleryAddReview;
    this.descriptionEditTextAddReview = descriptionEditTextAddReview;
    this.descriptionInputAddReview = descriptionInputAddReview;
    this.emailTvAddReview = emailTvAddReview;
    this.hotelNameSpinnerAddReview = hotelNameSpinnerAddReview;
    this.hotelNameTvAddReview = hotelNameTvAddReview;
    this.ivAddReview = ivAddReview;
    this.materialCardViewAddReivew = materialCardViewAddReivew;
    this.progressBarAR = progressBarAR;
    this.rowStar1AddReview = rowStar1AddReview;
    this.rowStar2AddReview = rowStar2AddReview;
    this.rowStar3AddReview = rowStar3AddReview;
    this.rowStar4AddReview = rowStar4AddReview;
    this.rowStar5AddReview = rowStar5AddReview;
    this.scrollView2 = scrollView2;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_review, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddReviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_add_review;
      Button btAddReview = ViewBindings.findChildViewById(rootView, id);
      if (btAddReview == null) {
        break missingId;
      }

      id = R.id.bt_cancel_review;
      Button btCancelReview = ViewBindings.findChildViewById(rootView, id);
      if (btCancelReview == null) {
        break missingId;
      }

      id = R.id.btn_camera_addReview;
      ImageButton btnCameraAddReview = ViewBindings.findChildViewById(rootView, id);
      if (btnCameraAddReview == null) {
        break missingId;
      }

      id = R.id.btn_gallery_addReview;
      ImageButton btnGalleryAddReview = ViewBindings.findChildViewById(rootView, id);
      if (btnGalleryAddReview == null) {
        break missingId;
      }

      id = R.id.description_editText_addReview;
      TextInputEditText descriptionEditTextAddReview = ViewBindings.findChildViewById(rootView, id);
      if (descriptionEditTextAddReview == null) {
        break missingId;
      }

      id = R.id.description_input_addReview;
      TextInputLayout descriptionInputAddReview = ViewBindings.findChildViewById(rootView, id);
      if (descriptionInputAddReview == null) {
        break missingId;
      }

      id = R.id.email_tv_addReview;
      TextView emailTvAddReview = ViewBindings.findChildViewById(rootView, id);
      if (emailTvAddReview == null) {
        break missingId;
      }

      id = R.id.hotelName_spinner_addReview;
      Spinner hotelNameSpinnerAddReview = ViewBindings.findChildViewById(rootView, id);
      if (hotelNameSpinnerAddReview == null) {
        break missingId;
      }

      id = R.id.hotelName_tv_addReview;
      MaterialTextView hotelNameTvAddReview = ViewBindings.findChildViewById(rootView, id);
      if (hotelNameTvAddReview == null) {
        break missingId;
      }

      id = R.id.iv_addReview;
      ImageView ivAddReview = ViewBindings.findChildViewById(rootView, id);
      if (ivAddReview == null) {
        break missingId;
      }

      id = R.id.materialCardView_addReivew;
      MaterialCardView materialCardViewAddReivew = ViewBindings.findChildViewById(rootView, id);
      if (materialCardViewAddReivew == null) {
        break missingId;
      }

      id = R.id.progressBar_AR;
      ProgressBar progressBarAR = ViewBindings.findChildViewById(rootView, id);
      if (progressBarAR == null) {
        break missingId;
      }

      id = R.id.row_star1_addReview;
      ImageView rowStar1AddReview = ViewBindings.findChildViewById(rootView, id);
      if (rowStar1AddReview == null) {
        break missingId;
      }

      id = R.id.row_star2_addReview;
      ImageView rowStar2AddReview = ViewBindings.findChildViewById(rootView, id);
      if (rowStar2AddReview == null) {
        break missingId;
      }

      id = R.id.row_star3_addReview;
      ImageView rowStar3AddReview = ViewBindings.findChildViewById(rootView, id);
      if (rowStar3AddReview == null) {
        break missingId;
      }

      id = R.id.row_star4_addReview;
      ImageView rowStar4AddReview = ViewBindings.findChildViewById(rootView, id);
      if (rowStar4AddReview == null) {
        break missingId;
      }

      id = R.id.row_star5_addReview;
      ImageView rowStar5AddReview = ViewBindings.findChildViewById(rootView, id);
      if (rowStar5AddReview == null) {
        break missingId;
      }

      id = R.id.scrollView2;
      ScrollView scrollView2 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView2 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new FragmentAddReviewBinding((ConstraintLayout) rootView, btAddReview, btCancelReview,
          btnCameraAddReview, btnGalleryAddReview, descriptionEditTextAddReview,
          descriptionInputAddReview, emailTvAddReview, hotelNameSpinnerAddReview,
          hotelNameTvAddReview, ivAddReview, materialCardViewAddReivew, progressBarAR,
          rowStar1AddReview, rowStar2AddReview, rowStar3AddReview, rowStar4AddReview,
          rowStar5AddReview, scrollView2, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
