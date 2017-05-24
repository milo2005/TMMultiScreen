package unicauca.movil.multiscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.multiscreen.fragments.ColorFragment;
import unicauca.movil.multiscreen.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity implements MasterFragment.ColorSelected {

    boolean port, phone, inColor = false;
    MasterFragment master;
    ColorFragment color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        port = getResources().getBoolean(R.bool.port);
        phone = getResources().getBoolean(R.bool.phone);

        color = ColorFragment.instance(ColorFragment.AZUL);
        master = MasterFragment.instance();

        putFragment(R.id.container1, master);

        if (!phone && !port) {
            putFragment(R.id.container2, color);
        }

    }

    void putFragment(int container, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public void onColorSelected(int pos) {
        if (phone || port) {
            color = ColorFragment.instance(pos);
            putFragment(R.id.container1, color);
            inColor = true;
        }
        color.setColor(pos);
    }

    @Override
    public void onBackPressed() {
        if (inColor) {
            putFragment(R.id.container1, master);
        } else {
            super.onBackPressed();
        }
    }
}
