package com.example.proiectdentisti.Activity


import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
//import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.proiectdentisti.Domain.DoctorsModel
import com.example.proiectdentisti.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: DoctorsModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBundle()
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        item = item.copy(
            Location = "https://maps.google.com/?q=45.73909857525553, 21.235084185980583"

        )


        binding.apply {
            titleTxt.text = item.Name
            patiensTxt.text = item.Patiens


            experienceTxt.text = item.Expriense.toString() + " Years"
            ratingTxt.text = "${item.Rating}"
            backBtn.setOnClickListener { finish() }

            messageBtn.setOnClickListener {
                val uri = Uri.parse("smsto:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", "the SMS text")
                startActivity(intent)
            }

            callBtn.setOnClickListener {
                val uri = "tel:" + item.Mobile.trim()
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse(uri)
                )
                startActivity(intent)
            }
            directionBtn.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item.Location)
                )
                startActivity(intent)
            }

            Glide.with(this@DetailActivity)
                .load(item.Picture)
                .into(img)
        }
    }
}