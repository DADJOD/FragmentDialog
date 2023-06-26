package com.example.fragmentdialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    interface MyDialogHost {
        fun positive()
        fun negative()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Удаление файла")
        builder.setMessage("Файл будет удален. Вы уверены?")
        builder.setNegativeButton(
            "Cancel", DialogInterface.OnClickListener { dialog, _ ->
                val host = activity as MyDialogHost
                try {
                    host.negative()
                } catch (e: Exception) {
                } finally {
                    dialog.cancel()
                }
            }
        )

        builder.setPositiveButton(
            "Delete", DialogInterface.OnClickListener { dialog, _ ->
                val host = activity as MyDialogHost
                try {
                    host.positive()
                } catch (e: Exception) {}
                finally {
                    dialog.dismiss()
                }
            }
        )
        return builder.create()
    }
}