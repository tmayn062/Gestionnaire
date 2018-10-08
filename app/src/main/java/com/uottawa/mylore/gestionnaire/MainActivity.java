package com.uottawa.mylore.gestionnaire;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps (View view) {
    EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);
    Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
    mapIntent.setPackage("com.google.android.apps.maps");
    startActivity(mapIntent);}

    public void OnSetAvatarButton(View view) {
    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);  //changed from ProfileActivity to Main2Activity
    startActivityForResult (intent,0);}
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

        String drawableName = "wolframalpha";
        //4
        switch (data.getIntExtra("imageID",R.id.teamid00))
        {//Figuring out the correct image
            case R.id.teamid00:
                drawableName = "banana";
        break;
        case R.id.teamid01:
            drawableName = "beercan";
            break;
            case R.id.teamid02:
         drawableName = "beerglass";
         break;
         case R.id.teamid03:
             drawableName = "cherry";
          break;
          case R.id.teamid04:
              drawableName = "coconutcocktail";
         break;
         case R.id.teamid05:
             drawableName = "cookies";
             break;
         default:
             drawableName = "banana";
             break;    } //27
         int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        avatarImage.setImageResource(resID);
        }
}