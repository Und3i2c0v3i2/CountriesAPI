package com.example.countriesapi;


import android.os.Bundle;

public interface OnActionPerformedListener {

    /* define keys for all actions used with a Bundle */

    String BUNDLE_KEY = "bundle_key";

    // data
    String PARCELABLE_ARTIST = "parcelable_artist";

    // navigation options
    String OPEN_DETAILS = "open_details";
//    String OPEN_PREFS = "open_preferences";
//    String OPEN_ADD = "open_add";
//    String OPEN_EDIT = "open_edit";


    void onActionPerformed(Bundle bundle);
}
