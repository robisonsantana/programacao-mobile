package guy.voltaic.cadastroatletas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bunble = getIntent().getExtras();
        if(bunble != null) {
            String tipoAtleta = bunble.getString("tipoAtleta");
            if(tipoAtleta.equals("Juvenil")) {
                fragment = new atleta_juvenil_fragment();
            } else if (tipoAtleta.equals("Senior")) {
                fragment = new atleta_senior_fragment();
            } else {
                fragment = new atleta_outro_fragment();
            }

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if(id == R.id.menu_juvenil) {
            bundle.putString("tipoAtleta", "Juvenil");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if(id == R.id.menu_senior) {
            bundle.putString("tipoAtleta", "Senior");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if(id == R.id.menu_outro) {
            bundle.putString("tipoAtleta", "Outro");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}