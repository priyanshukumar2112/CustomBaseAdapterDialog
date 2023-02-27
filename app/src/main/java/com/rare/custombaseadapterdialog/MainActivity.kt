package com.rare.custombaseadapterdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.rare.custombaseadapterdialog.databinding.ActivityMainBinding
import com.rare.custombaseadapterdialog.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    var arrayList = ArrayList<UserModel>()
    lateinit var arrayAdapter: ArrayAdapter<UserModel>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        binding.lv.adapter = arrayAdapter
        binding.fabAdd.setOnClickListener {
            /* var Dialogview = LayoutInflater.from(this).inflate(R.layout.customerbaseadapterdialog, null)
            var myDialog = Dialog(this)
            myDialog.setContentView(Dialogview)
            myDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            myDialog.show()
            var btnCancel = Dialogview.findViewById<Button>(R.id.cdbtnSave)
            btnCancel.setOnClickListener{
                    myDialog.dismiss()
            } */
            //with binding
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
        binding.lv.setOnItemClickListener { adapterView, view, position, l ->
            var dialogView = CustomdialogBinding.inflate(layoutInflater)
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
                    arrayList.set(position, usermodel)
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()

                }


            }


        }
    }
}



