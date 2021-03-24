package pl.altkom.trening

import android.Manifest.permission.CALL_PHONE
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), OnVisibilityChanged {

    val TAG = "MainActivty"
    lateinit var text1: TextView
    lateinit var viewModel: MainActivityViewModel

    companion object {
        const val StanLicznika = "StanLicznika"
    }

    val wykonajPolaczenie = registerForActivityResult(ActivityResultContracts.RequestPermission()) { czyUdzielono ->
        if(czyUdzielono){
            wybierzNumer()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        text1 = findViewById<TextView>(R.id.tekst_1)
        text1.text = resources.getString(R.string.app_name)

        val textView2 = TextView(this)
        textView2.id = View.generateViewId()

        textView2.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        with(findViewById<ViewGroup>(R.id.kontener)){
            addView(textView2)
            addView(TextView(this@MainActivity).apply {
                text = "Licznik: ${viewModel.licznik}"
                textSize = 25f
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            })
        }
        val textHtml = "To jest <b>moj</b> emulator"
        textView2.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(textHtml, FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(textHtml)
        }

        if(ContextCompat.checkSelfPermission(this, CALL_PHONE) != PERMISSION_GRANTED) {
            wykonajPolaczenie.launch(CALL_PHONE)
        }

    }

    private fun wybierzNumer() {
        val numer = "tel:123456789"
        val intencja = Intent(Intent.ACTION_CALL)
        intencja.data = Uri.parse(numer)
        startActivity(intencja)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.licznik +=1
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun zaprezentujInterfejs(onVisibilityChanged: OnVisibilityChanged){

    }

    override fun onVisibilityChanged(isVisible: Boolean) {
        print("${isVisible}")
    }
}

interface OnVisibilityChanged {
    fun onVisibilityChanged(isVisible: Boolean)
}