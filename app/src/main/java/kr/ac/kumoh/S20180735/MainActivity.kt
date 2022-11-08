package kr.ac.kumoh.S20180735


import android.app.Activity
import android.view.View
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.S20180735.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    View.OnClickListener {

        companion object {
            const val keyName = "image"
        }
        private lateinit var binding: ActivityMainBinding
        private lateinit var launcher: ActivityResultLauncher<Intent>


        override fun onClick(v: View?) {
            val intent = Intent(this, ImageActivity::class.java)
            val value = when (v?.id) {
                binding.btnGundam.id -> "gundam"
                binding.btnZaku.id -> "zaku"
                else -> return
            }
            intent.putExtra(keyName, value)
            launcher.launch(intent)
        }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)




            setContentView(binding.root)

            binding.btnGundam.setOnClickListener(this)
            binding.btnZaku.setOnClickListener(this)

            launcher = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode != RESULT_OK)
                {
                    return@registerForActivityResult
                }

                val result = it.data?.getIntExtra(ImageActivity.resultName, ImageActivity.NONE)
                val str = when(result) {
                    ImageActivity.LIKE -> "좋아요"
                    ImageActivity.DISLIKE -> "싫어요"
                    else -> ""
                }
                val image = it.data?.getStringExtra(ImageActivity.imageName)
                when(image) {
                    "gundam" -> binding.btnGundam.text = "동상 ($str)"
                    "zaku" -> binding.btnZaku.text = "여신상 ($str)"
                }
            }


        }
    }
