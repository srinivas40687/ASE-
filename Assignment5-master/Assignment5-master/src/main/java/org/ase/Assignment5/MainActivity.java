package org.ase.Assignment5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView proImage;
    Uri myUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(null!=getIntent().getExtras());
        {
            Bundle extras = getIntent().getExtras();
            if(null!=extras)
            myUri = Uri.parse(extras.getString("imageUri"));
            proImage = (ImageView) findViewById(R.id.imageView);
        }
        if(null!=myUri)
        proImage.setImageURI(myUri);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
}
    public void onClickOfPhotoButton(View v) {
        //This code redirects to the photo activity.
        Intent redirect = new Intent(MainActivity.this, GalleryActivity.class);
        startActivity(redirect);
    }
    public void onClickOfMapButton(View v) {
        //This code redirects the from main page to the maps page.
        Intent redirect = new Intent(MainActivity.this,MapsActivity.class);
        if(null!=getIntent().getExtras())
        {
            redirect.putExtra("imageUri",myUri.toString());
        }
        startActivity(redirect);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
