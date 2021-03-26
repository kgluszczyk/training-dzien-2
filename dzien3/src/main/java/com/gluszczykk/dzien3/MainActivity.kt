package com.gluszczykk.dzien3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.progressindicator.CircularProgressIndicator

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.actionObservableStream.observe(this, Observer<MainActivityViewModel.State> {
            when (it) {
                is MainActivityViewModel.State.Zaladowano -> {
                    setProgressVisibility(false)
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment2, DetailsFragment.newInstance(it.brightness.imageSrc))
                        //.addToBackStack(null)
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .commit()

                    findViewById<View>(R.id.fragment2).apply {
                        visibility = View.VISIBLE
                    }
                }
                MainActivityViewModel.State.Laduj -> {
                    setProgressVisibility(true)
                    findViewById<View>(R.id.fragment2).apply {
                        visibility = View.INVISIBLE
                    }
                }
            }
        })
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action1-> {
                Toast.makeText(this, "Kliknieto: ${item.title}", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action2 -> {
                ShutdownDialog().show(supportFragmentManager, "ShutdownDialog")
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}

fun AppCompatActivity.setProgressVisibility(isVisible: Boolean) {
    findViewById<CircularProgressIndicator>(R.id.progress).apply {
        visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }
}

class DetailsFragment : Fragment() {

    companion object {

        private const val ImageSrcKey = "ImageSrcKey"
        fun newInstance(@DrawableRes imageSrc: Int): Fragment {
            val args = Bundle()
            args.putInt(ImageSrcKey, imageSrc)

            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ImageView(ContextThemeWrapper(requireContext(),R.style.ImageTint), null, R.style.ImageTint).apply {
            setImageResource(requireArguments().getInt(ImageSrcKey))
        }
    }
}