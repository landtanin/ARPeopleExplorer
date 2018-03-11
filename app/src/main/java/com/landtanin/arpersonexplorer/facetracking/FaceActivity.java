/*
 * Copyright (c) 2017 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish, 
 * distribute, sublicense, create a derivative work, and/or sell copies of the 
 * Software in any work that is designed, intended, or marketed for pedagogical or 
 * instructional purposes related to programming, coding, application development, 
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works, 
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.landtanin.arpersonexplorer.facetracking;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.landtanin.arpersonexplorer.R;
import com.landtanin.arpersonexplorer.ui.camera.CameraSourcePreview;
import com.landtanin.arpersonexplorer.ui.camera.GraphicOverlay;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public final class FaceActivity extends AppCompatActivity {

  private static final String TAG = "FaceActivity";

  private static final int RC_HANDLE_GMS = 9001;
  // permission request codes need to be < 256
  private static final int RC_HANDLE_CAMERA_PERM = 255;

  private CameraSource mCameraSource = null;
  private CameraSourcePreview mPreview;
  private GraphicOverlay mGraphicOverlay;
  private boolean mIsFrontFacing = true;
  private ImageView previewImg;

  // Activity event handlers
  // =======================

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate called.");

    setContentView(R.layout.activity_face);

    mPreview = (CameraSourcePreview) findViewById(R.id.preview);
    mGraphicOverlay = (GraphicOverlay) findViewById(R.id.faceOverlay);
    final ImageButton button = (ImageButton) findViewById(R.id.flipButton);
    final Button captureBtn = findViewById(R.id.captureBtn);

    previewImg = findViewById(R.id.previewImage);
    button.setOnClickListener(mSwitchCameraButtonListener);
    captureBtn.setOnClickListener(mCaptureButtonListener);

    if (savedInstanceState != null) {
      mIsFrontFacing = savedInstanceState.getBoolean("IsFrontFacing");
    }

    // Start using the camera if permission has been granted to this app,
    // otherwise ask for permission to use it.
    int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
    if (rc == PackageManager.PERMISSION_GRANTED) {
      createCameraSource();
    } else {
      requestCameraPermission();
    }
  }

  private View.OnClickListener mSwitchCameraButtonListener = new View.OnClickListener() {
    public void onClick(View v) {
      mIsFrontFacing = !mIsFrontFacing;

      if (mCameraSource != null) {
        mCameraSource.release();
        mCameraSource = null;
      }

      createCameraSource();
      startCameraSource();
    }
  };

  private View.OnClickListener mCaptureButtonListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      // TODO: capture image and show it to the previewImg
      Context context = getApplicationContext();
      MyFaceDetector faceDetector = createFaceDetector(context);

      // crop current photo on the screen
//      File imageFile = takeScreenshot();
//      if (imageFile == null) {
//        return;
//      }
//
//      Uri uri = Uri.fromFile(imageFile);
//      Bitmap bitmap = null;
//      try {
//        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//
//      previewImg.setImageBitmap(bitmap);
      // put it in Bitmap format

      // put it in frame

      // use faceDetector to detect it

//      SparseArray<Face> detectedFaces = faceDetector.detect(faceDetector.frame);
//      for(int i=0;i<detectedFaces.size();i++){          //can't use for-each loops for SparseArrays
//        Face face = detectedFaces.valueAt(i);
//        //get it's coordinates
//        Bitmap faceBitmap = Bitmap.createBitmap(bitmap, (int) face.getPosition().x, (int) face.getPosition().y, (int) face.getWidth(), (int) face.getHeight());
//        //Do whatever you want with this cropped Bitmap
//      }



//      Resources r = getResources();
//      int heightInPx = Math.round(TypedValue.applyDimension(
//              TypedValue.COMPLEX_UNIT_DIP, 100,r.getDisplayMetrics()));
//
//      int widthInPx = Math.round(TypedValue.applyDimension(
//              TypedValue.COMPLEX_UNIT_DIP, 80,r.getDisplayMetrics()));
//
////      BitmapFactory.Options options = new BitmapFactory.Options();
////      options.inMutable=true;
//      Bitmap myBitmap = Bitmap.createBitmap(heightInPx, widthInPx, Bitmap.Config.RGB_565);
//
//      Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
//      SparseArray<Face> faces = faceDetector.detect(frame);

//      faceDetector.croppedBitMap

//      Frame frame = new Frame.Builder().set
//      ByteBuffer buf = faceDetector.detect().getGrayscaleImageData();
//
//      byte[] imageBytes= new byte[buf.remaining()];
//      buf.get(imageBytes);
//      final Bitmap bmp= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);



    }
  };



  private File takeScreenshot() {
    Date now = new Date();
    android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

    try {
      // image naming and path  to include sd card  appending name you choose for file
      String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

      // create bitmap screen capture
      View v1 = getWindow().getDecorView().getRootView();
      v1.setDrawingCacheEnabled(true);
      Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
      v1.setDrawingCacheEnabled(false);

      File imageFile = new File(mPath);

      FileOutputStream outputStream = new FileOutputStream(imageFile);
      int quality = 100;
      bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
      outputStream.flush();
      outputStream.close();

//      openScreenshot(imageFile);
      return imageFile;
    } catch (Throwable e) {
      // Several error may come out with file handling or DOM
      e.printStackTrace();
    }
    return null;
  }


  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume called.");

    startCameraSource();
  }

  @Override
  protected void onPause() {
    super.onPause();

    mPreview.stop();
  }

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    savedInstanceState.putBoolean("IsFrontFacing", mIsFrontFacing);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (mCameraSource != null) {
      mCameraSource.release();
    }
  }

  // Handle camera permission requests
  // =================================

  private void requestCameraPermission() {
    Log.w(TAG, "Camera permission not acquired. Requesting permission.");

    final String[] permissions = new String[]{Manifest.permission.CAMERA};
    if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
      Manifest.permission.CAMERA)) {
      ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
      return;
    }

    final Activity thisActivity = this;
    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ActivityCompat.requestPermissions(thisActivity, permissions, RC_HANDLE_CAMERA_PERM);
      }
    };
    Snackbar.make(mGraphicOverlay, R.string.permission_camera_rationale,
      Snackbar.LENGTH_INDEFINITE)
      .setAction(R.string.ok, listener)
      .show();
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                         @NonNull int[] grantResults) {
    if (requestCode != RC_HANDLE_CAMERA_PERM) {
      Log.d(TAG, "Got unexpected permission result: " + requestCode);
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      return;
    }

    if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      // We have permission to access the camera, so create the camera source.
      Log.d(TAG, "Camera permission granted - initializing camera source.");
      createCameraSource();
      return;
    }

    // If we've reached this part of the method, it means that the user hasn't granted the app
    // access to the camera. Notify the user and exit.
    Log.e(TAG, "Permission not granted: results len = " + grantResults.length +
      " Result code = " + (grantResults.length > 0 ? grantResults[0] : "(empty)"));
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        finish();
      }
    };
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(R.string.app_name)
      .setMessage(R.string.no_camera_permission)
      .setPositiveButton(R.string.disappointed_ok, listener)
      .show();
  }

  // Camera source
  // =============

  private void createCameraSource() {
    Log.d(TAG, "createCameraSource called.");

    // 1
    Context context = getApplicationContext();
    MyFaceDetector detector = createFaceDetector(context);

    // 2
    int facing = CameraSource.CAMERA_FACING_FRONT;
    if (!mIsFrontFacing) {
      facing = CameraSource.CAMERA_FACING_BACK;
    }

    // 3
    mCameraSource = new CameraSource.Builder(context, detector)
      .setFacing(facing)
      .setRequestedPreviewSize(320, 240)
      .setRequestedFps(60.0f)   // Sets the camera frame rate. Higher rates mean better face tracking, but use more processor power.
      .setAutoFocusEnabled(true)
      .build();




//    ByteBuffer mPendingFrameData = detector.frame.getGrayscaleImageData();
//
//    Resources r = getResources();
//    int heightInPx = Math.round(TypedValue.applyDimension(
//              TypedValue.COMPLEX_UNIT_DIP, 100,r.getDisplayMetrics()));
//
//    int widthInPx = Math.round(TypedValue.applyDimension(
//              TypedValue.COMPLEX_UNIT_DIP, 80,r.getDisplayMetrics()));
//
//    Frame outputFrame = new Frame.Builder()
//            .setImageData(mPendingFrameData, widthInPx,
//                    heightInPx, ImageFormat.NV21)
//            .build();
//
//    int w = outputFrame.getMetadata().getWidth();
//    int h = outputFrame.getMetadata().getHeight();
//    SparseArray<Face> detectedFaces = detector.detect(outputFrame);
//    Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//
//    if (detectedFaces.size() > 0) {
//      ByteBuffer byteBufferRaw = outputFrame.getGrayscaleImageData();
//      byte[] byteBuffer = byteBufferRaw.array();
//      YuvImage yuvimage  = new YuvImage(byteBuffer, ImageFormat.NV21, w, h, null);
//
//      Face face = detectedFaces.valueAt(0);
//      int left = (int) face.getPosition().x;
//      int top = (int) face.getPosition().y;
//      int right = (int) face.getWidth() + left;
//      int bottom = (int) face.getHeight() + top;
//
//      ByteArrayOutputStream baos = new ByteArrayOutputStream();
//      yuvimage.compressToJpeg(new Rect(left, top, right, bottom), 80, baos);
//      byte[] jpegArray = baos.toByteArray();
//      bitmap = BitmapFactory.decodeByteArray(jpegArray, 0, jpegArray.length);
//    }
//
//    previewImg.setImageBitmap(bitmap);

  }

  private void startCameraSource() {
    Log.d(TAG, "startCameraSource called.");

    // Make sure that the device has Google Play services available.
    int code = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(
      getApplicationContext());
    if (code != ConnectionResult.SUCCESS) {
      Dialog dlg = GoogleApiAvailability.getInstance().getErrorDialog(this, code, RC_HANDLE_GMS);
      dlg.show();
    }

    if (mCameraSource != null) {
      try {
        mPreview.start(mCameraSource, mGraphicOverlay);
      } catch (IOException e) {
        Log.e(TAG, "Unable to start camera source.", e);
        mCameraSource.release();
        mCameraSource = null;
      }
    }
  }

  // Face detector
  // =============

  /**
   *  Create the face detector, and check if it's ready for use.
   */
  @NonNull
  private MyFaceDetector createFaceDetector(final Context context) {
    Log.d(TAG, "createFaceDetector called.");

    // 1
    FaceDetector detector = new FaceDetector.Builder(context)
      .setLandmarkType(FaceDetector.ALL_LANDMARKS)
      .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
            // Set to NO_CLASSIFICATIONS if it should not detect whether subjects’ eyes are open
            // or closed or if they’re smiling (which speeds up face detection)
      .setTrackingEnabled(true)
      .setMode(FaceDetector.FAST_MODE)
            // Set to FAST_MODE to detect fewer faces (but more quickly),
            // or ACCURATE_MODE to detect more faces (but more slowly)
            // and to detect the Euler Y angles of faces
      .setProminentFaceOnly(mIsFrontFacing)
      .setMinFaceSize(mIsFrontFacing ? 0.35f : 0.15f)
      .build();

    MyFaceDetector myFaceDetector = new MyFaceDetector(detector);

    // 2
    MultiProcessor.Factory<Face> factory = new MultiProcessor.Factory<Face>() {
      @Override
      public Tracker<Face> create(Face face) {
        return new FaceTracker(mGraphicOverlay, context, mIsFrontFacing);
      }
    };

    // 3
    Detector.Processor<Face> processor = new MultiProcessor.Builder<>(factory).build();
    detector.setProcessor(processor);
    myFaceDetector.setProcessor(processor);

    // 4
    if (!detector.isOperational()) {
      Log.w(TAG, "Face detector dependencies are not yet available.");

      // Check the device's storage.  If there's little available storage, the native
      // face detection library will not be downloaded, and the app won't work,
      // so notify the user.
      IntentFilter lowStorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
      boolean hasLowStorage = registerReceiver(null, lowStorageFilter) != null;

      if (hasLowStorage) {
        Log.w(TAG, getString(R.string.low_storage_error));
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            finish();
          }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name)
          .setMessage(R.string.low_storage_error)
          .setPositiveButton(R.string.disappointed_ok, listener)
          .show();
      }
    }
    return myFaceDetector;
  }

}