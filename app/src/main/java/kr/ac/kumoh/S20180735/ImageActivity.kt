package kr.ac.kumoh.S20180735

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.S20180735.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val res = when (intent.getStringExtra(MainActivity.keyName)) {
            "gundam" -> R.drawable.statue
            "zaku" -> R.drawable.liberty
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)
    }


}
