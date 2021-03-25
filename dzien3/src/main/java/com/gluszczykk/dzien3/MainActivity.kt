package com.gluszczykk.dzien3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.actionStream.observe(this, Observer<Brightness> {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment2, DetailsFragment.newInstance(it.imageSrc))
                //.addToBackStack(null)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .commit()
        })
        setContentView(R.layout.activity_main)
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
        return ImageView(requireContext()).apply {
            setImageResource(requireArguments().getInt(ImageSrcKey))
        }
    }
}