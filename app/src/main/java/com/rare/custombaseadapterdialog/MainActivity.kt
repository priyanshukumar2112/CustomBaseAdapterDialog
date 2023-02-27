package com.rare.custombaseadapterdialog

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.rare.custombaseadapterdialog.databinding.ActivityMainBinding
import com.rare.custombaseadapterdialog.databinding.CustomdialogBinding
import com.rare.custombaseadapterdialog.databinding.EditdialogBinding

class MainActivity : AppCompatActivity(), click {
    var arrayList = ArrayList<UserModel>()
    lateinit var arrayAdapter: UserAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        arrayAdapter = UserAdapter(this, arrayList, this)
        binding.lv.adapter = arrayAdapter
        binding.fabAdd.setOnClickListener {
            var dialogView = CustomdialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogView.root)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            dialogView.btnSave.setOnClickListener {
                if (dialogView.etName.text.toString().trim().isEmpty()) {
                    dialogView.etName.error = "Enter the Name"
                } else if (dialogView.etAge.text.toString().trim().isEmpty()) {
                    dialogView.etAge.error = "Enter the Age"
                } else if (dialogView.etDistrict.text.toString().trim().isEmpty()) {
                    dialogView.etDistrict.error = "Enter the District"
                } else {
                    var usermodel = UserModel(
                        dialogView.etName.text.toString(),
                        dialogView.etAge.text.toString().toInt(),
                        dialogView.etDistrict.text.toString()
                    )
                    arrayList.add(usermodel)
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()

                }

            }
        }
//        binding.lv.setOnItemClickListener { adapterView, view, position, l ->
//            var dialogView = CustomdialogBinding.inflate(layoutInflater)
//            var dialog = Dialog(this)
//            dialog.setContentView(dialogView.root)
//            dialog.window?.setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            dialog.show()
//            dialogView.etAge.setText(arrayList[position].age.toString())
//            dialogView.etName.setText(arrayList[position].name.toString())
//            dialogView.etDistrict.setText(arrayList[position].district.toString())
//            dialogView.btnSave.setOnClickListener {
//                if (dialogView.etName.text.toString().trim().isEmpty()) {
//                    dialogView.etName.error = "Enter the Name"
//                } else if (dialogView.etAge.text.toString().trim().isEmpty()) {
//                    dialogView.etAge.error = "Enter the Age"
//                } else if (dialogView.etDistrict.text.toString().trim().isEmpty()) {
//                    dialogView.etDistrict.error = "Enter the District"
//                } else {
//
//                    var usermodel = UserModel(
//                        dialogView.etName.text.toString(),
//                        dialogView.etAge.text.toString().toInt(),
//                        dialogView.etDistrict.text.toString()
//                    )
//                    arrayList.set(position, usermodel)
//                    arrayAdapter.notifyDataSetChanged()
//                    dialog.dismiss()
////                }
//            }
//        }
    }

    override fun editClick(position: Int) {
        var dialogView = EditdialogBinding.inflate(layoutInflater)
        var dialog = Dialog(this)
        dialog.setContentView(dialogView.root)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.show()
        dialogView.etAge.setText(arrayList[position].age.toString())
        dialogView.etName.setText(arrayList[position].name.toString())
        dialogView.etDistrict.setText(arrayList[position].district.toString())
        dialogView.btnUpdate.setOnClickListener {
            if (dialogView.etName.text.toString().trim().isEmpty()) {
                dialogView.etName.error = "Enter the Name"
            } else if (dialogView.etAge.text.toString().trim().isEmpty()) {
                dialogView.etAge.error = "Enter the Age"
            } else if (dialogView.etDistrict.text.toString().trim().isEmpty()) {
                dialogView.etDistrict.error = "Enter the District"
            } else {

                var usermodel = UserModel(
                    dialogView.etName.text.toString(),
                    dialogView.etAge.text.toString().toInt(),
                    dialogView.etDistrict.text.toString()
                )
                arrayList.set(position, usermodel)
                arrayAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            System.out.println("click")
        }
    }

    override fun deleteClick(position: Int) {
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("Delete Alert!!")
        dialog.setMessage("Are you sure ")
        dialog.setPositiveButton("yes"){_,_ ->
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
            arrayList.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
        }


        dialog.setNegativeButton("no"){ _,_ ->
            Toast.makeText(this, "operation cancel", Toast.LENGTH_SHORT).show()

        }
        dialog.show()

        System.out.println("click")

    }
}



