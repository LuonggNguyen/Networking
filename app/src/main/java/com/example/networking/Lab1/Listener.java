package com.example.networking.Lab1;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
