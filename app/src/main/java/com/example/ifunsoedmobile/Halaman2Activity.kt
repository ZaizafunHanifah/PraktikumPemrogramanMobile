package com.example.ifunsoedmobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.ifunsoedmobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHalaman2Binding
    private val latitude = "-7.429427"
    private val longitude = "109.338082"
    private val gMapsUrl = "http://maps.google.com/maps?q=loc:"
    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        // Phone
        binding.layoutPhone.imgIcon.setImageResource(R.drawable.ic_phone)
        binding.layoutPhone.tvLayout.setText(R.string.telepon)

        // Email
        binding.layoutEmail.imgIcon.setImageResource(R.drawable.ic_email)
        binding.layoutEmail.tvLayout.setText(R.string.email)

        // Location
        binding.layoutLocation.imgIcon.setImageResource(R.drawable.ic_location)
        binding.layoutLocation.tvLayout.setText(R.string.alamat)

        // Instagram
        binding.layoutIg.imgIcon.setImageResource(R.drawable.ic_himpunan)
        binding.layoutIg.tvLayout.setText(R.string.ig_himpunan)

        binding.layoutBuku.imgIcon.setImageResource(R.drawable.ic_book) // icon buku
        binding.layoutBuku.tvLayout.setText(R.string.koleksi_buku)       // teks “Koleksi Buku”
    }

    private fun initListener() {
        // Phone
        binding.layoutPhone.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, "tel:${getString(R.string.telepon)}".toUri())
            startActivity(intent)
        }

        // Email
        binding.layoutEmail.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, "mailto:${getString(R.string.email)}".toUri())
            startActivity(intent)
        }

        // Location
        binding.layoutLocation.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "$gMapsUrl$latitude,$longitude".toUri())
                .setPackage(packageMaps)
            startActivity(intent)
        }

        // Instagram
        binding.layoutIg.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, getString(R.string.ig_himpunan).toUri())
            startActivity(intent)
        }

        binding.layoutBuku.root.setOnClickListener {
            startActivity(Intent(this, DaftarBukuActivity::class.java))
        }

        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
