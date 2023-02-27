package com.rare.custombaseadapterdialog

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import com.rare.custombaseadapterdialog.databinding.CustomdialogBinding
import com.rare.custombaseadapterdialog.databinding.EditdialogBinding
import com.rare.custombaseadapterdialog.databinding.StuListBinding

class UserAdapter(var activity: MainActivity, var arrayList: ArrayList<UserModel>,var click: click) : BaseAdapter() {
    override fun getCount(): Int {
      return  arrayList.size
    }

    override fun getItem(position: Int): UserModel {
        return arrayList[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val binding = StuListBinding.inflate(activity.layoutInflater)
        binding.etAge.setText(arrayList[position].age.toString())
        binding.etName.setText(arrayList[position].name.toString())
        binding.etDistrict.setText(arrayList[position].district.toString())
        binding.btnEdit.setOnClickListener {
            click.editClick(position)

        }
        binding.btnDelete.setOnClickListener {
            click.deleteClick(position)
        }

        return binding.root
    }
}