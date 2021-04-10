package com.hamedrahimvand.launchers

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.hamedrahimvand.ui.BaseFragment

/**
 *
 *@author Hamed.Rahimvand
 *@since 4/9/21
 */
class LauncherDetailsFragment : BaseFragment(R.layout.fragment_launchers_details){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO just for test
        view.findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(Uri.parse("dashboard://dashboard"))
        }
    }
}