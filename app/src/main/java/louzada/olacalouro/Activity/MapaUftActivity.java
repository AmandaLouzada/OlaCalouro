package louzada.olacalouro.Activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import louzada.olacalouro.OlaCalouroDAO;
import louzada.olacalouro.R;
import louzada.olacalouro.domain.Local;

public class MapaUftActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private OlaCalouroDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_uft);

        dao = new OlaCalouroDAO(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng uft = new LatLng(-10.178709,-48.360024);
        mMap.addMarker(new MarkerOptions().position(uft).title("UFT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uft, 18));
        adicionarMarcadores();
    }

    public void adicionarMarcadores(){

        List<Local> listaLocais = dao.listarLocais();

        for (Local local : listaLocais) {
            LatLng posicaoMarcador = new LatLng(local.getLat(), local.getLng());
            mMap.addMarker(new MarkerOptions().position(posicaoMarcador).title(local.getNome()).snippet(local.getDescricao()));

        }

    }
}
