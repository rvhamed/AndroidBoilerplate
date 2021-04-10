import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.hamedrahimvand.dynamicfeatures.dashboard.R
import com.hamedrahimvand.ui.BaseFragment

/**
 *
 *@author Hamed.Rahimvand
 *@since 4/7/21
 */
class DashboardFragment: BaseFragment(R.layout.fragment_dashboard){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO just for test
        view.findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(Uri.parse("launcher://list"))
        }
    }

}