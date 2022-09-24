package app.test.imageswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    val images = arrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
    var currentImage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSwitcher = findViewById<ImageSwitcher>(R.id.imageSwitcher)
        val changeImages = findViewById<AppCompatButton>(R.id.changeImage)
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        imageSwitcher.setFactory {
            var imageView = ImageView(this@MainActivity)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.layoutParams = FrameLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            imageView
        }

        imageSwitcher.inAnimation = inAnimation
        imageSwitcher.outAnimation = outAnimation
        imageSwitcher.setImageResource(images[currentImage])

        changeImages.setOnClickListener {
            if (currentImage != 1)
                currentImage++
            else
                currentImage = 0

            imageSwitcher.setImageResource(images[currentImage])
        }

    }
}