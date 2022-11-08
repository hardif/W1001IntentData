package kr.ac.kumoh.S20180735

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import kr.ac.kumoh.S20180735.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityImageBinding
    private var image: String? = null

    companion object{
        const val imageName = "image"
        const val resultName = "result"

        const val LIKE = 10
        const val DISLIKE = 20
        const val NONE = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        image = intent.getStringExtra(MainActivity.keyName)
        val res = when (image) {
            "gundam" -> R.drawable.statue
            "zaku" -> R.drawable.liberty
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imgGundam.setImageResource(res)
        binding.btnLike.setOnClickListener(this)
        binding.btnDislike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when (v?.id) {
            binding.btnLike.id-> LIKE
            binding.btnDislike.id-> DISLIKE
            else -> NONE
        }
        intent.putExtra(imageName,image)
        intent.putExtra(resultName,value)
        setResult(RESULT_OK,intent)
        finish()

    }


}
