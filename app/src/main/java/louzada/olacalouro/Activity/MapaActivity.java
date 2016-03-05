package louzada.olacalouro.Activity;

import android.Manifest;
import android.content.pm.PackageManager;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import louzada.olacalouro.DatabaseHelper;
import louzada.olacalouro.Dijkstra;
import louzada.olacalouro.Grafo;
import louzada.olacalouro.OlaCalouroDAO;
import louzada.olacalouro.R;
import louzada.olacalouro.domain.Aresta;
import louzada.olacalouro.domain.Local;
import louzada.olacalouro.domain.Vertice;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private OlaCalouroDAO dao;
    private List <String> locais = new ArrayList<String>();
    Polyline polyline;
    Grafo grafo;
    Dijkstra dijkstra;
    LinkedList<Vertice> caminho = new LinkedList<Vertice>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        dao = new OlaCalouroDAO(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                for (Local l : dao.listarLocais())
                {
                    locais.add(l.getNome());

                }


        popularGrafo();
        popularDijkstra();



        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.dropdown_mapa, locais);
        final AutoCompleteTextView destino = (AutoCompleteTextView) findViewById(R.id.destino);
        destino.setAdapter(adaptador);
        destino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Local localDestino = dao.buscarLocalPorNome(String.valueOf(destino.getText()));
                mMap.clear();
                Marker marcador = mMap.addMarker(new MarkerOptions().position(new LatLng(localDestino.getLat(), localDestino.getLng())).title(localDestino.getNome()).snippet(localDestino.getDescricao()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(localDestino.getLat(), localDestino.getLng()), 18));
                marcador.showInfoWindow();

            }
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // Add a marker in Sydney and move the camera
        LatLng uft = new LatLng(-10.178709, -48.360024);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uft, 17));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }


    public void popularGrafo() {
        grafo = new Grafo(dao.listarVertices(),dao.listarArestas());
    }

    public void popularDijkstra() {
        dijkstra = new Dijkstra(grafo);
    }

    public void desenharRota(Long idDestino){
        popularGrafo();
        popularDijkstra();
        dijkstra.execute(dao.buscarVerticePorId((long) 1));
        Log.i("CAM", "aq");
        caminho = dijkstra.getPath(dao.buscarVerticePorId(idDestino));
        PolylineOptions polylineOptions = new PolylineOptions();
                for(Vertice v : caminho) {
                    LatLng coordenada = new LatLng(v.getLat(), v.getLng());
                    polylineOptions.add(coordenada);
                }

        polylineOptions.color(Color.BLUE).width(5);
        polyline = mMap.addPolyline(polylineOptions);

    }

}
