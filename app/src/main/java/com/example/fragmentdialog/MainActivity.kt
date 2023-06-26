package com.example.fragmentdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fragmentdialog.MyDialog.MyDialogHost

class MainActivity : AppCompatActivity(), MyDialogHost {
    companion object {
        const val DIALOG_KEY = "DIALOG_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDialog(view: View) {
        val dialog = MyDialog()
        dialog.show(supportFragmentManager, null)
    }

    override fun positive() {
        Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
    }

    override fun negative() {
        Toast.makeText(this, "ГАЛЯ, У НАС ОТМЕНА!", Toast.LENGTH_SHORT).show()
    }
}