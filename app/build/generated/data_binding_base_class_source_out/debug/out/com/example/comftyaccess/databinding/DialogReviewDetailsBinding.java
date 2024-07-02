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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comftyaccess.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogReviewDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btBackReviewDetails;

  @NonNull
  public final CardView card1;

  @NonNull
  public final CardView card2;

  @NonNull
  public final CardView card3;

  @NonNull
  public final ImageView ivEditreviewReviewDetails;

  @NonNull
  public final ImageView ivReviewDetails;

  @NonNull
  public final ProgressBar progressBarRD;

  @NonNull
  public final ImageView rowStar1ReviewDetails;

  @NonNull
  public final ImageView rowStar2ReviewDetails;

  @NonNull
  public final ImageView rowStar3ReviewDetails;

  @NonNull
  public final ImageView rowStar4ReviewDetails;

  @NonNull
  public final ImageView rowStar5ReviewDetails;

  @NonNull
  public final TextView tvAccessNeedReviewDetails;

  @NonNull
  public final TextView tvDescReviewDetails;

  @NonNull
  public final TextView tvEditAccessNeedReviewDetails;

  @NonNull
  public final TextView tvEditAgeReviewDetails;

  @NonNull
  public final TextView tvEditDescReviewDetails;

  @NonNull
  public final TextView tvEditEmailReviewDetails;

  @NonNull
  public final TextView tvEditHotelnameReviewDetails;

  @NonNull
  public final TextView tvHotelnameReviewDetails;

  private DialogReviewDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btBackReviewDetails, @NonNull CardView card1, @NonNull CardView card2,
      @NonNull CardView card3, @NonNull ImageView ivEditreviewReviewDetails,
      @NonNull ImageView ivReviewDetails, @NonNull ProgressBar progressBarRD,
      @NonNull ImageView rowStar1ReviewDetails, @NonNull ImageView rowStar2ReviewDetails,
      @NonNull ImageView rowStar3ReviewDetails, @NonNull ImageView rowStar4ReviewDetails,
      @NonNull ImageView rowStar5ReviewDetails, @NonNull TextView tvAccessNeedReviewDetails,
      @NonNull TextView tvDescReviewDetails, @NonNull TextView tvEditAccessNeedReviewDetails,
      @NonNull TextView tvEditAgeReviewDetails, @NonNull TextView tvEditDescReviewDetails,
      @NonNull TextView tvEditEmailReviewDetails, @NonNull TextView tvEditHotelnameReviewDetails,
      @NonNull TextView tvHotelnameReviewDetails) {
    this.rootView = rootView;
    this.btBackReviewDetails = btBackReviewDetails;
    this.card1 = card1;
    this.card2 = card2;
    this.card3 = card3;
    this.ivEditreviewReviewDetails = ivEditreviewReviewDetails;
    this.ivReviewDetails = ivReviewDetails;
    this.progressBarRD = progressBarRD;
    this.rowStar1ReviewDetails = rowStar1ReviewDetails;
    this.rowStar2ReviewDetails = rowStar2ReviewDetails;
    this.rowStar3ReviewDetails = rowStar3ReviewDetails;
    this.rowStar4ReviewDetails = rowStar4ReviewDetails;
    this.rowStar5ReviewDetails = rowStar5ReviewDetails;
    this.tvAccessNeedReviewDetails = tvAccessNeedReviewDetails;
    this.tvDescReviewDetails = tvDescReviewDetails;
    this.tvEditAccessNeedReviewDetails = tvEditAccessNeedReviewDetails;
    this.tvEditAgeReviewDetails = tvEditAgeReviewDetails;
    this.tvEditDescReviewDetails = tvEditDescReviewDetails;
    this.tvEditEmailReviewDetails = tvEditEmailReviewDetails;
    this.tvEditHotelnameReviewDetails = tvEditHotelnameReviewDetails;
    this.tvHotelnameReviewDetails = tvHotelnameReviewDetails;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogReviewDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogReviewDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_review_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogReviewDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_back_review_details;
      Button btBackReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (btBackReviewDetails == null) {
        break missingId;
      }

      id = R.id.card1;
      CardView card1 = ViewBindings.findChildViewById(rootView, id);
      if (card1 == null) {
        break missingId;
      }

      id = R.id.card2;
      CardView card2 = ViewBindings.findChildViewById(rootView, id);
      if (card2 == null) {
        break missingId;
      }

      id = R.id.card3;
      CardView card3 = ViewBindings.findChildViewById(rootView, id);
      if (card3 == null) {
        break missingId;
      }

      id = R.id.iv_editreview_review_details;
      ImageView ivEditreviewReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (ivEditreviewReviewDetails == null) {
        break missingId;
      }

      id = R.id.iv_review_details;
      ImageView ivReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (ivReviewDetails == null) {
        break missingId;
      }

      id = R.id.progressBarRD;
      ProgressBar progressBarRD = ViewBindings.findChildViewById(rootView, id);
      if (progressBarRD == null) {
        break missingId;
      }

      id = R.id.row_star1_review_details;
      ImageView rowStar1ReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (rowStar1ReviewDetails == null) {
        break missingId;
      }

      id = R.id.row_star2_review_details;
      ImageView rowStar2ReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (rowStar2ReviewDetails == null) {
        break missingId;
      }

      id = R.id.row_star3_review_details;
      ImageView rowStar3ReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (rowStar3ReviewDetails == null) {
        break missingId;
      }

      id = R.id.row_star4_review_details;
      ImageView rowStar4ReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (rowStar4ReviewDetails == null) {
        break missingId;
      }

      id = R.id.row_star5_review_details;
      ImageView rowStar5ReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (rowStar5ReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_accessNeed_review_details;
      TextView tvAccessNeedReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvAccessNeedReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_desc_review_details;
      TextView tvDescReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvDescReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_edit_accessNeed_review_details;
      TextView tvEditAccessNeedReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvEditAccessNeedReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_edit_age_review_details;
      TextView tvEditAgeReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvEditAgeReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_edit_desc_review_details;
      TextView tvEditDescReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvEditDescReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_edit_email_review_details;
      TextView tvEditEmailReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvEditEmailReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_edit_hotelname_review_details;
      TextView tvEditHotelnameReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvEditHotelnameReviewDetails == null) {
        break missingId;
      }

      id = R.id.tv_hotelname_review_details;
      TextView tvHotelnameReviewDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvHotelnameReviewDetails == null) {
        break missingId;
      }

      return new DialogReviewDetailsBinding((ConstraintLayout) rootView, btBackReviewDetails, card1,
          card2, card3, ivEditreviewReviewDetails, ivReviewDetails, progressBarRD,
          rowStar1ReviewDetails, rowStar2ReviewDetails, rowStar3ReviewDetails,
          rowStar4ReviewDetails, rowStar5ReviewDetails, tvAccessNeedReviewDetails,
          tvDescReviewDetails, tvEditAccessNeedReviewDetails, tvEditAgeReviewDetails,
          tvEditDescReviewDetails, tvEditEmailReviewDetails, tvEditHotelnameReviewDetails,
          tvHotelnameReviewDetails);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
