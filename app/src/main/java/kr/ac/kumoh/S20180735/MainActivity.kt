package kr.ac.kumoh.S20180735


import android.view.View
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kr.ac.kumoh.S20180735.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    View.OnClickListener {

    companion object {
        const val keyName = "image"
    }
    private lateinit var binding: ActivityMainBinding

    override fun onClick(v: View?) {
        val intent = Intent(this, ImageActivity::class.java)
        val value = when (v?.id) {
            binding.btnGundam.id -> "gundam"
            binding.btnZaku.id -> "zaku"
            else -> return
        }
        intent.putExtra(keyName, value)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGundam.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            //intent.putExtra("image", R.drawable.gundam)
            intent.putExtra("image", "gundam")
            startActivity(intent)
        }
        binding.btnZaku.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("image", "zaku")
            startActivity(intent)
        }
    }
}