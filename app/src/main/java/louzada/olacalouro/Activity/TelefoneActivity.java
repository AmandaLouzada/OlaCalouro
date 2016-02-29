package louzada.olacalouro.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import louzada.olacalouro.OlaCalouroDAO;
import louzada.olacalouro.R;
import louzada.olacalouro.domain.Telefone;

public class TelefoneActivity extends FragmentActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab_creation");
        // text and image of tab
        spec.setIndicator("Create adresse");
        // specify layout of tab
        spec.setContent(R.id.linearLayout);
        // adding tab in TabHost
        tabHost.addTab(spec);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab_creation");
        // text and image of tab
        spec2.setIndicator("Contatos UFT");
        // specify layout of tab
        spec2.setContent(R.id.layoutUftFone);
        // adding tab in TabHost
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab_creation");
        // text and image of tab
        spec3.setIndicator("Contatos Palmas");
        // specify layout of tab
        spec3.setContent(R.id.layoutPalmas);
        // adding tab in TabHost
        tabHost.addTab(spec3);

    }
}
