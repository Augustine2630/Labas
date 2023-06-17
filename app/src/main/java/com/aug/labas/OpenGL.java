package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class OpenGL extends AppCompatActivity {

    private GLSurfaceView gLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gLView = new GLSurfaceView(this);
//        MyGLSurfaceView(this);
        setContentView(gLView);
    }
}