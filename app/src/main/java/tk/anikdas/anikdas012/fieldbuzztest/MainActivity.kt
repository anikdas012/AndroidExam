package tk.anikdas.anikdas012.fieldbuzztest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.anikdas.anikdas012.fieldbuzztest.ui.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.place_holder, LoginFragment(), "Login_Fragment")
            .commit()
    }
}