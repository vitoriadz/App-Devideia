package com.example.module

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.module.databinding.MoodboardBinding


class Moodboard : AppCompatActivity() {

    private var imageViewId: Int = -1
    private lateinit var binding: MoodboardBinding
    private lateinit var dialog: AlertDialog

    companion object {
        private const val PERMISSAO_GALERIA = Manifest.permission.READ_EXTERNAL_STORAGE
        private const val REQUEST_CODE_GALERIA = 1001
    }

    private fun redimensionarImagem(bitmap: Bitmap, larguraDesejada: Int, alturaDesejada: Int): Bitmap {
        return Bitmap.createScaledBitmap(bitmap, larguraDesejada, alturaDesejada, true)
    }

    private val requestGaleria = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK && result.data?.data != null) {
            val bitmap: Bitmap? = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(
                    contentResolver,
                    result.data?.data
                )
            } else {
                val source = ImageDecoder.createSource(
                    contentResolver,
                    result.data?.data!!
                )
                ImageDecoder.decodeBitmap(source)
            }

            if (bitmap != null) {
                val larguraDesejada = 600
                val alturaDesejada = 600
                val bitmapRedimensionado = redimensionarImagem(bitmap, larguraDesejada, alturaDesejada)

                if (imageViewId == 0) {
                    binding.imageView.setImageBitmap(bitmapRedimensionado)
                } else if (imageViewId == 1) {
                    binding.imageView1.setImageBitmap(bitmapRedimensionado)
                } else if (imageViewId == 2) {
                    binding.imageView2.setImageBitmap(bitmap)
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoodboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {
            imageViewId = 0
            verificaPermissaoGaleria()
        }

        binding.imageView1.setOnClickListener {
            imageViewId = 1
            verificaPermissaoGaleria()
        }

        binding.imageView2.setOnClickListener {
            imageViewId = 2
            verificaPermissaoGaleria()
        }
    }

    private fun verificaPermissaoGaleria() {
        val permissaoGaleriaAceita = verificaPermissao(PERMISSAO_GALERIA)

        if (permissaoGaleriaAceita) {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            requestGaleria.launch(intent)
        } else {
            showDialogPermissao()
        }
    }

    private fun showDialogPermissao() {
        val builder = AlertDialog.Builder(this)
            .setTitle("Atenção")
            .setMessage("Precisamos do acesso à galeria do dispositivo. Deseja permitir agora?")
            .setNegativeButton("Não") { _, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Sim") { _, _ ->
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                dialog.dismiss()
            }

        dialog = builder.create()
        dialog.show()
    }

    private fun verificaPermissao(permissao: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permissao) == PackageManager.PERMISSION_GRANTED
    }
}