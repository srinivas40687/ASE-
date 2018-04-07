package org.ase.Assignment5;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;


public class GalleryActivity extends ActionBarActivity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
    ImageView iv;
    View v;
    Uri selectedImageUri;
    private static final int SELECT_PICTURE = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setTitle("Capture image");
        setContentView(R.layout.activity_gallery);
        Button capture = (Button) findViewById(R.id.btn_take_photo);
        LayoutInflater inflater = this.getLayoutInflater();
         v = inflater.inflate(R.layout.content_main, null);
        iv = (ImageView) v.findViewById(R.id.imageView);
        Log.v("Image is pk",iv.toString());
        userImage = (ImageView) findViewById(R.id.view_photo);
        //Button click eventlistener. Initializes the camera.
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
            }
        });
    }
    //If the photo is captured then set the image view to the photo captured.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                selectedImageUri = data.getData();
                String selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                userImage.setImageURI(selectedImageUri);
                iv.setImageURI(selectedImageUri);
                iv.invalidate();
                v.invalidate();
            }
        }
    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public void redirectToHome(View v)
    {
        Intent redirect = new Intent(GalleryActivity.this, MainActivity.class);
        redirect.putExtra("imageUri",selectedImageUri.toString());
        startActivity(redirect);
    }
}