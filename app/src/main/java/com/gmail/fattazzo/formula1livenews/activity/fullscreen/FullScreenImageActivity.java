package com.gmail.fattazzo.formula1livenews.activity.fullscreen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.dspot.declex.api.runwith.RunWith;
import com.gmail.fattazzo.formula1livenews.R;
import com.gmail.fattazzo.formula1livenews.settings.ApplicationPreferenceManager;
import com.gmail.fattazzo.formula1livenews.utils.ImageUtils;
import com.gmail.fattazzo.formula1livenews.view.ZoomableImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_layout_full)
public class FullScreenImageActivity extends Activity {

    public static final String EXTRA_CIRCUIT_ID = "circuit_id";

    @Extra
    String circuit_id;

    @Bean
    ApplicationPreferenceManager preferenceManager;

    @Bean
    ImageUtils imageUtils;

    @ViewById
    ZoomableImageView imgDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(preferenceManager.getAppTheme());
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void init() {
        Bitmap circuitImage = imageUtils.getCircuitForCode(circuit_id);
        if(preferenceManager.isBitmapInvertedForCurrentTheme()) {
            circuitImage = imageUtils.invertColor(circuitImage);
        }

        imgDisplay.setImageBitmap(circuitImage);
    }

    @Click
    void btnClose() {
        FullScreenImageActivity.this.finish();
    }
}