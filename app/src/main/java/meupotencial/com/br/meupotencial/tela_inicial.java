package meupotencial.com.br.meupotencial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class tela_inicial extends ActionBarActivity {

    private com.google.android.gms.ads.AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);


        MobileAds.initialize(this, "ca-app-pub-6526158567739347~9122323311");
        AdView adView = (AdView) findViewById(R.id.Propaganda_3);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }}


    //load ads
//    AdView adView = (AdView)findViewById(R.id.bannerAd);
//    AdRequest.Builder request = new AdRequest.Builder();
//    request.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
//    adView.loadAd(request.build());

//
//
//    AdView adView = (AdView)this.findViewById(com.example.lovetestactual.R.id.adView);
//    AdRequest adRequest = new AdRequest.Builder().build();
//adView.loadAd(adRequest);
//
////




//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.my, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    /** Called when leaving the activity */
//    @Override
//    public void onPause() {
//        if (mAdView != null) {
//            mAdView.pause();
//        }
//        super.onPause();
//    }
//
//    /** Called when returning to the activity */
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mAdView != null) {
//            mAdView.resume();
//        }
//    }
//
//    /** Called before the activity is destroyed */
//    @Override
//    public void onDestroy() {
//        if (mAdView != null) {
//            mAdView.destroy();
//        }
//        super.onDestroy();
//    }
//}
